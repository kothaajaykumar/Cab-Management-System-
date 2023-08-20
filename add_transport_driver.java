package cab_booking;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class add_transport_driver extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7;
    JButton b1, b2;
    JPanel p1, p2, p3;
    JTextField t1, t2, t3, t4, t5, t6;
    JPasswordField pf1;
    Font f1, f2;
    
    add_transport_driver() {
        super("Add Transport Driver");
        setLocation(450, 50);
        setSize(450, 400);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.BOLD, 15);

        l1 = new JLabel("Add Transport Driver");
        l2 = new JLabel("Driver Name");
        l3 = new JLabel("Source");
        l4 = new JLabel("Destination");
        l5 = new JLabel("Truck");
        l6 = new JLabel("Price");
        l7 = new JLabel("Distance");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        b1 = new JButton("Add Transport Driver");
        b2 = new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);


        p2 = new JPanel();
        p2.setLayout(new GridLayout(7, 2, 10, 10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);
        p2.add(l7);
        p2.add(t6);
        p2.add(b1);
        p2.add(b2);

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");




    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == b1) {

            String name = t1.getText();
            String source = t2.getText();
            String dest = t3.getText();
            String truck = t4.getText();
            String price = t5.getText();
            String dist = t6.getText();
            try{
                connectionclass obj = new connectionclass();
                String q = "insert into transport_driver(driver,source,destination,truck,price,distance) values('" + name + "','"
                        + source + "','" + dest + "','" + truck + "','" + price + "','"+dist+"')";
                int aa = obj.stm.executeUpdate(q);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "data sucessfully inserted");
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please fill carefully");
                }
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            this.setVisible(false);
            new Adminsection().setVisible(true);
            
        }

    }
    public static void main(String[] args) {
        new add_transport_driver().setVisible(true);
    }

    
    
}
