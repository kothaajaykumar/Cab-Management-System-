package cab_booking;

import java.sql.*;

public class connectionclass {
    Connection con;
    Statement stm;

    connectionclass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cab_booking", "root", "123456");
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new connectionclass();
    }
}
