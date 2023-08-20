package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class View_customer extends JFrame {
    
    Font f;
    JTable t1;
    String x[] = { "Username", "Name", "Age", "Date of birth", "Address", "Phone", "Email", "Country", "Gender",
            "Aadhar" };
    String y[][] = new String[20][10];
    int i = 0, j = 0;
    View_customer() {
        
        super("All customer details");
        setSize(1300, 400);
        setLocation(0, 10);
        f = new Font("MS UI Gothic ", Font.BOLD, 17);

        try{
            connectionclass obj = new connectionclass();
            String q = "select * from customer";
            ResultSet rs = obj.stm.executeQuery(q);
            while (rs.next()) {
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("age");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("Email");
                y[i][j++] = rs.getString("country");
                y[i][j++] = rs.getString("gender");
                y[i][j++] = rs.getString("aadhar");
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
        new View_customer().setVisible(true);
    }
}
