package cab_booking;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class book_intercity_cab extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7,l8,l9,l10,l11,l12,l13;
    JButton b1, b2;
    JPanel p1, p2, p3;
    JTextField t1, t2, t3, t4, t5, t6,t7,t8,t9;
    Font f1, f2;
    Choice ch1, ch2, ch3,ch4;


    book_intercity_cab() {
        super("Book Intercity Cab");
        setLocation(50, 10);
        setSize(1100, 700);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);

        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();
        ch4 = new Choice();

        try{
            connectionclass obj = new connectionclass();
            String q = "select DISTINCT source from intercity_driver";
            ResultSet rs = obj.stm.executeQuery(q);
            while (rs.next()) {
                ch1.add(rs.getString("source"));
            }
            rs.close();

        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        try{
            connectionclass obj = new connectionclass();
            String q = "select username from customer";
            ResultSet rs = obj.stm.executeQuery(q);
            while (rs.next()) {
                ch3.add(rs.getString("username"));
            }
            rs.close();
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }

        l1 = new JLabel("Book Intercity Cab");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = new JLabel("Book ID:");
        l3 = new JLabel("Source");
        l4 = new JLabel("Destination:");
        l5 = new JLabel("Username:");
        l6 = new JLabel("Name:");
        l7 = new JLabel("Driver Name:");
        l8 = new JLabel("Car:");
        l9 = new JLabel("Destination from:");
        l10 = new JLabel("Destination to:");
        l11 = new JLabel("Price:");
        l13 = new JLabel("Type");


        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);

        b1 = new JButton("Book Cab");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setBackground(Color.YELLOW);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        Random rm = new Random();
        t1.setText("" + Math.abs(rm.nextInt() % 100000));
        t1.setForeground(Color.RED);

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);
        ch1.setFont(f2);
        ch2.setFont(f2);
        ch2.setFont(f2);
        ch3.setFont(f2);
        l13.setFont(f2);
        ch4.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(12, 2, 10, 10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch2);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(t2);
        p2.add(l7);
        p2.add(t4);
        p2.add(l8);
        p2.add(t5);
        p2.add(l9);
        p2.add(t6);
        p2.add(l10);
        p2.add(t7);
        p2.add(l11);
        p2.add(t8);
        p2.add(l13);
        p2.add(ch4);
        p2.add(b1);
        p2.add(b2);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/bmw2.jpg"));
        Image i1 = img.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l12 = new JLabel();
        l12.setIcon(i2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l12);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg1) {
                try{
                    connectionclass obj = new connectionclass();
                    String username = ch3.getSelectedItem();
                    String q = "select name from customer where username='" + username + "'";
                    ResultSet rs = obj.stm.executeQuery(q);
                    while (rs.next()) {
                        t2.setText(rs.getString("name"));
                    }
                    rs.close();

                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg1) {
                ch2.removeAll();
                try{
                    connectionclass obj = new connectionclass();
                    String source = ch1.getSelectedItem();
                    String q = "select destination from intercity_driver where source='" + source + "'";
                    ResultSet rs = obj.stm.executeQuery(q);
                    while (rs.next()) {
                        ch2.add(rs.getString("destination"));
                    }
                    rs.close();

                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        ch2.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg1) {
                ch4.removeAll();
                try{
                    connectionclass obj = new connectionclass();
                    String source = ch1.getSelectedItem();
                    String dest = ch2.getSelectedItem();
                    String q = "select * from intercity_driver where source='" + source + "' and destination='"+dest+"'";
                    ResultSet rs = obj.stm.executeQuery(q);
                    while (rs.next()) {
                        t4.setText(rs.getString("driver"));
                        t5.setText(rs.getString("car"));
                        t6.setText(rs.getString("source"));
                        t7.setText(rs.getString("destination"));
                        t8.setText(rs.getString("price"));

                    }
                    String q1 = "select * from intercity_driver where source='" + source + "' and destination='"+dest+"'";
                    ResultSet rs1 = obj.stm.executeQuery(q1);

                    while (rs1.next()) {
                        ch4.add(rs1.getString("type"));
                    }
                    rs.close();

                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        

    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String bid = t1.getText();
            String user = ch3.getSelectedItem();
            String dname = t4.getText();
            String source = t6.getText();
            String dest = t7.getText();
            String car = t5.getText();
            String price = t8.getText();
            String type = ch4.getSelectedItem();
            String name = t2.getText();

            try{
                connectionclass obj = new connectionclass();
                String q= "insert into intercity_cab(bid,username,dname,car,source,destination,price,type,name) values('" + bid + "','"
                        + user + "','" + dname + "','" + car + "','" + source + "','" + dest + "','" + price + "','"+type+"','"+name+"')";
                int aa = obj.stm.executeUpdate(q);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Cab Booked Successfully");
                    this.setVisible(false);
                    new Update_customer().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please fill details carefully");

                }
            }
            catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new book_intercity_cab().setVisible(true);
    }
    
}
