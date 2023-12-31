package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;
    JPasswordField p1;
    JButton b1, b2;

    signup() {
        f = new JFrame("Create new Account", null);
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        f.add(l1);

        l2 = new JLabel("name");
        l2.setBounds(40, 70, 100, 30);
        f.add(l2);

        l3 = new JLabel("password");
        l3.setBounds(40, 120, 100, 30);
        f.add(l3);

        l4 = new JLabel("phone num");
        l4.setBounds(40, 170, 100, 30);
        f.add(l4);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);
        f.add(t2);

        p1 = new JPasswordField();
        p1.setBounds(150, 120, 150, 30);
        f.add(p1);

        t3 = new JTextField();
        t3.setBounds(150, 170, 150, 30);
        f.add(t3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l5 = new JLabel(i3);
        l5.setBounds(350, 70, 150, 150);
        f.add(l5);

        b1 = new JButton("signup");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40, 240, 120, 30);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 240, 120, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(b1);
        f.add(b2);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(550, 340);
        f.setLocation(400, 300);
    }
    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == b1) {
            String Usename = t1.getText();
            String name = t2.getText();
            String password = p1.getText();
            String phone = t3.getText();
            try {
                connectionclass obj = new connectionclass();
                String q = "insert into signup values('" + Usename + "', '" + name + "','" + password + "','"+phone+"')";
                int aa = obj.stm.executeUpdate(q);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    f.setVisible(false);
                    new Login();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Account Created failed");
                    this.f.setVisible(false);
                    this.f.setVisible(true);
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e1.getSource() == b2) {
            this.f.setVisible(false);
            new Login();
        }
         
    }
    public static void main(String[] args) {
        new signup();
    }
    

    
    

}
