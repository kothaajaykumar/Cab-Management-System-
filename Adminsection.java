package cab_booking;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Adminsection extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4;
    JPanel p1, p2;
    Font f1, f2;

    Adminsection() {
        super("Admin section");
        setLocation(450, 50);
        setSize(450, 270);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.BOLD, 15);

        l1 = new JLabel("Admin section");
        l1.setHorizontalAlignment(JLabel.CENTER);

        b1 = new JButton("Intercity Driver");
        b2 = new JButton("Intracity Driver");
        b3 = new JButton("Transport Driver");
        b4 = new JButton("SignUp");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        l1.setFont(f1);
        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1, 10, 10));
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);

        setLayout(new BorderLayout(10, 10));
        add(p1, "Center");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new add_intercity_driver().setVisible(true);
        }
        if (e.getSource() == b2) {
            new add_intracity_driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == b3) {
            new add_transport_driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == b4) {
            new signup().setVisible(true);
            this.setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new Adminsection().setVisible(true);
    }
    
}
