package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class View_booked_package extends JFrame {
    
    Font f;
    JTable t1;
    String x[] = { "Book Id", "Username","Name", "Driver Name", "Source", "Destination","Weight","Truck","Distance", "Price"};
    String y[][] = new String[20][10];
    int i = 0, j = 0;
    View_booked_package() {
        
        super("All booked Transport Truck details");
        setSize(1300, 400);
        setLocation(0, 10);
        f = new Font("MS UI Gothic ", Font.BOLD, 17);

        try{
            connectionclass obj = new connectionclass();
            String q = "select * from transport_package";
            ResultSet rs = obj.stm.executeQuery(q);
            while (rs.next()) {
                y[i][j++] = rs.getString("bid");
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("dname");
                y[i][j++] = rs.getString("source");
                y[i][j++] = rs.getString("destination");
                y[i][j++] = rs.getString("weight");
                y[i][j++] = rs.getString("truck");
                y[i][j++] = rs.getString("distance");
                y[i][j++] = rs.getString("price");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        t1.setFont(f);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);

        JScrollPane js = new JScrollPane(t1);
        add(js);
    }
    public static void main(String[] args) {
        new View_booked_package().setVisible(true);
    }
}
