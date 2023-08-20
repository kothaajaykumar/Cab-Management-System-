package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Delete_customer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JFrame f;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b1, b2;
    Font f1, f2;
    Choice ch;
    JPanel p1, p2, p3;


    Delete_customer() {
        super("Update Customer");
        setSize(800, 600);
        setLocation(50, 50);
        setBackground(Color.WHITE);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);

        ch = new Choice();
        try{
            connectionclass obj=new connectionclass();
            String q="select username from customer";
            ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next()){
                ch.add(rs.getString("username"));
            }
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        
        l1 = new JLabel("Delete Customer");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = new JLabel("Userame:");
        l3 = new JLabel("Name:");
        l4 = new JLabel("Age:");
        l5 = new JLabel("Date of Birth:");
        l6 = new JLabel("Address:");
        l7 = new JLabel("Phone:");
        l8 = new JLabel("Email:");
        l9 = new JLabel("Country:");
        l10 = new JLabel("Gender:");
        l11 = new JLabel("Aadhar");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();

        b1 = new JButton("Delete");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

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

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);
        t9.setFont(f2);

        ch.setFont(f2);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b2.setFont(f2);
        b1.setFont(f2);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/3d.jpeg"));
        Image i1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l12 = new JLabel();
        l12.setIcon(i2);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l12);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(11, 2, 10, 10));
        p3.add(l2);
        p3.add(ch);
        p3.add(l3);
        p3.add(t1);
        p3.add(l4);
        p3.add(t2);
        p3.add(l5);
        p3.add(t3);
        p3.add(l6);
        p3.add(t4);
        p3.add(l7);
        p3.add(t5);
        p3.add(l8);
        p3.add(t6);
        p3.add(l9);
        p3.add(t7);
        p3.add(l10);
        p3.add(t8);
        p3.add(l11);
        p3.add(t9);
        p3.add(b1);
        p3.add(b2);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "West");
        add(p3, "Center");

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try{
                    connectionclass obj = new connectionclass();
                    String username = ch.getSelectedItem();
                    String q = "select * from customer where username='" + username + "'";
                    ResultSet rs = obj.stm.executeQuery(q);
                    while (rs.next()) {
                        t1.setText(rs.getString("name"));
                        t2.setText(rs.getString("age"));
                        t3.setText(rs.getString("dob"));
                        t4.setText(rs.getString("address"));
                        t5.setText(rs.getString("phone"));
                        t6.setText(rs.getString("email"));
                        t7.setText(rs.getString("country"));
                        t8.setText(rs.getString("gender"));
                        t9.setText(rs.getString("aadhar"));

                    }
                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            String username = ch.getSelectedItem();
            
            try{
                connectionclass obj = new connectionclass();
                
                String q = "delete from customer where username='" + username + "'";
                String q1 = "delete from transport_package where username='" + username + "'";
                String q2 = "delete from intercity_cab where username='" + username + "'";
                String q3="delete from intracity_cab where username='"+username+"'";
                        int aa=obj.stm.executeUpdate(q);
                        if(aa==1){
                            JOptionPane.showMessageDialog(null, "your data sucessfully Deleted");
                            obj.stm.executeUpdate(q1);
                            obj.stm.executeUpdate(q2);
                            obj.stm.executeUpdate(q3);
                            this.setVisible(false);
                            new View_customer().setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"please fill all the data");
                        }
            }
            catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new Delete_customer().setVisible(true);
    }
}
