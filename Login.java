package cab_booking;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JPanel pane1;
        JFrame f;
        JLabel l1, l2, l3, l4;
        JTextField t1;
        JPasswordField p1;
        JButton b1, b2;

        Login() {
            f = new JFrame("Login Account");
            f.setBackground(Color.WHITE);
            f.setLayout(null);

            l1 = new JLabel();
            l1.setBounds(0, 0, 580, 350);
            l1.setLayout(null);

            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/bg3.jpeg"));
            Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
            l1.setIcon(i2);

            l2 = new JLabel("Login Account");
            l2.setBounds(190, 30, 500, 50);
            l2.setFont(new Font("Airal", Font.BOLD, 30));
            l2.setForeground(Color.PINK);
            l1.add(l2);
            f.add(l1);

            l3 = new JLabel("Username:");
            l3.setBounds(120, 120, 150, 30);
            l3.setForeground(Color.BLACK);
            l3.setFont(new Font("Arial", Font.BOLD, 20));
            l1.add(l3);

            l4 = new JLabel("Password:");
            l4.setBounds(120, 170, 150, 30);
            l4.setForeground(Color.BLACK);
            l4.setFont(new Font("Arial", Font.BOLD, 20));
            l1.add(l4);

            t1 = new JTextField();
            t1.setBounds(300, 120, 150, 30);
            l1.add(t1);

            p1 = new JPasswordField();
            p1.setBounds(300, 170, 150, 30);
            l1.add(p1);

            b1 = new JButton("Login");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(120, 220, 150, 30);
            l1.add(b1);

            b2 = new JButton("SignUp");
            b2.setBackground(Color.RED);
            b2.setForeground(Color.WHITE);
            b2.setBounds(300, 220, 150, 30);
            l1.add(b2);

            b1.addActionListener(this);
            b2.addActionListener(this);

            f.getContentPane();
            f.setVisible(true);
            f.setSize(580, 350);
            f.setLocation(400, 300);
        }

        public void actionPerformed(ActionEvent e1) {
            if (e1.getSource() == b1) {
                try{
                    connectionclass obj = new connectionclass();
                    String user = t1.getText();
                    String pass = p1.getText();

                    String q = "select * from `signup`" + "where username=? and password=?";
                    PreparedStatement stmt = obj.con.prepareStatement(q);
                    stmt.setString(1, user);
                    stmt.setString(2, pass);
                    ResultSet rs=stmt.executeQuery();

                    if (rs.next()) {
                        new HomePage().setVisible(true);
                        f.setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "enter correct credentials");
                        this.f.setVisible(false);
                        f.setVisible(true);
                    }
                    rs.close();


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (e1.getSource() == b2) {
                f.setVisible(false);
                new signup();

            }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
