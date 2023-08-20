package cab_booking;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Check_bill extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7;
    JButton b1, b2, b3, b4;
    JPanel p1, p2, p3;
    JTextField t1, t2, t3, t4, t5, t6;
    Font f1, f2;
    Choice ch1;

    public int price = 0;

    Check_bill() {
        super("Check Total Cab Bill");
        setLocation(50, 50);
        setSize(1100, 500);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.BOLD, 15);

        l1 = new JLabel("Check Total Cab Bill");
        l2 = new JLabel("Userame");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Address");
        l6 = new JLabel("Price");

        ch1 = new Choice();
        try {
            connectionclass obj = new connectionclass();
            String q = "select * from customer";
            ResultSet rs = obj.stm.executeQuery(q);
            while (rs.next()) {
                ch1.add(rs.getString("username"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);

        b1 = new JButton("Intercity Cab");
        b2 = new JButton("Intracity Cab");
        b3 = new JButton("Transport");
        b4 = new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        ch1.setFont(f2);

        b1.setBackground(Color.YELLOW);
        b2.setBackground(Color.YELLOW);
        b3.setBackground(Color.YELLOW);
        b4.setBackground(Color.BLACK);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(7, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/bill.jpeg"));
        Image i1 = img.getImage().getScaledInstance(500, 280, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l7 = new JLabel();
        l7.setIcon(i2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l7);

        setLayout(new BorderLayout(0, 0));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg1) {
                try {
                    connectionclass obj = new connectionclass();
                    String username = ch1.getSelectedItem();
                    String q = "select * from customer where username='" + username + "'";
                    ResultSet rs = obj.stm.executeQuery(q);
                    while (rs.next()) {
                        t1.setText(rs.getString("name"));
                        t2.setText(rs.getString("email"));
                        t3.setText(rs.getString("address"));
                    }
                    rs.close();

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });



    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            price = 0;
            String username = ch1.getSelectedItem();
            try {
                connectionclass obj = new connectionclass();
                String q = "select price from intercity_cab where username='" + username + "'";
                ResultSet rs = obj.stm.executeQuery(q);
                while (rs.next()) {
                    price = price + Integer.parseInt(rs.getString("price"));
                }
                t4.setText(price + "");
                rs.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            price = 0;
            String username = ch1.getSelectedItem();
            try {
                connectionclass obj = new connectionclass();
                String q = "select price from intracity_cab where username='" + username + "'";
                ResultSet rs = obj.stm.executeQuery(q);
                while (rs.next()) {
                    price = price + Integer.parseInt(rs.getString("price"));
                }
                t4.setText(price + "");
                rs.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b3) {
            price = 0;
            String username = ch1.getSelectedItem();
            try {
                connectionclass obj = new connectionclass();
                String q = "select price from transport_package where username='" + username + "'";
                ResultSet rs = obj.stm.executeQuery(q);
                while (rs.next()) {
                    price = price + Integer.parseInt(rs.getString("price"));
                }
                t4.setText(price + "");
                rs.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b4) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Check_bill().setVisible(true);
    }
}
