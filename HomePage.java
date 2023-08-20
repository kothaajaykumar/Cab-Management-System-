package cab_booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {

    JFrame j;
    JLabel l1;
    Font f, f1, f2;
    JPanel p1, p2;

    HomePage() {
        super("Home Page");
        setLocation(0, 0);
        setSize(1550, 800);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking/images/bg4.jpeg"));
        Image i = img.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon ic = new ImageIcon(i);
        l1 = new JLabel(ic);

        f = new Font("Lucida Fax", Font.BOLD, 20);
        f1 = new Font("Gadugi", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 18);

        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Customer Profile");
        JMenuItem meni1 = new JMenuItem("Add Customer Profile");
        JMenuItem meni2 = new JMenuItem("View Customer Profile");

        JMenu men2 = new JMenu("Manage Customer");
        JMenuItem meni3 = new JMenuItem("Update Customer Profile");

        JMenu men3 = new JMenu("Book Intracity Cab");
        JMenuItem meni4 = new JMenuItem("Book Cab");
        JMenuItem meni5 = new JMenuItem("View Booked Cab");

        JMenu men4 = new JMenu("Book Intercity Cab");
        JMenuItem meni6 = new JMenuItem("Book Intercity Cab");
        JMenuItem meni7 = new JMenuItem("View Booked Intercity Cab");

        JMenu men5 = new JMenu("Transport");
        JMenuItem meni8 = new JMenuItem("Book Package");
        JMenuItem meni9 = new JMenuItem("View Booked Package");

        JMenu men6 = new JMenu("Bill");
        JMenuItem meni10 = new JMenuItem("Check Bill");

        JMenu men7 = new JMenu("Delete");
        JMenuItem meni11 = new JMenuItem("Delete Customer");

        JMenu men8 = new JMenu("About");
        JMenuItem meni12 = new JMenuItem("About");
        JMenuItem meni13 = new JMenuItem("Exit");

        men1.add(meni1);
        men1.add(meni2);
        men2.add(meni3);
        men3.add(meni4);
        men3.add(meni5);
        men4.add(meni6);
        men4.add(meni7);
        men5.add(meni8);
        men5.add(meni9);
        men6.add(meni10);
        men7.add(meni11);
        men8.add(meni12);
        men8.add(meni13);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        m1.add(men8);

        m1.setBackground(Color.BLACK);
        men1.setForeground(Color.YELLOW);
        men2.setForeground(Color.YELLOW);
        men3.setForeground(Color.YELLOW);
        men4.setForeground(Color.YELLOW);
        men5.setForeground(Color.YELLOW);
        men6.setForeground(Color.YELLOW);
        men7.setForeground(Color.YELLOW);
        men8.setForeground(Color.YELLOW);
        men8.setForeground(Color.RED);

       
        

        meni1.setBackground(Color.BLACK);
        meni2.setBackground(Color.BLACK);
        meni3.setBackground(Color.BLACK);
        meni4.setBackground(Color.BLACK);
        meni5.setBackground(Color.BLACK);
        meni6.setBackground(Color.BLACK);
        meni7.setBackground(Color.BLACK);
        meni8.setBackground(Color.BLACK);
        meni9.setBackground(Color.BLACK);
        meni10.setBackground(Color.BLACK);
        meni11.setBackground(Color.BLACK);
        meni12.setBackground(Color.BLACK);
        meni13.setBackground(Color.BLACK);

        meni1.setForeground(Color.YELLOW);
        meni2.setForeground(Color.YELLOW);
        meni3.setForeground(Color.YELLOW);
        meni4.setForeground(Color.YELLOW);
        meni5.setForeground(Color.YELLOW);
        meni6.setForeground(Color.YELLOW);
        meni7.setForeground(Color.YELLOW);
        meni8.setForeground(Color.YELLOW);
        meni9.setForeground(Color.YELLOW);
        meni10.setForeground(Color.YELLOW);
        meni11.setForeground(Color.YELLOW);
        meni12.setForeground(Color.RED);
        meni13.setForeground(Color.RED);

        meni1.setActionCommand("Add Customer Profile");

        setJMenuBar(m1);

        add(l1);
        ActionListener menuListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if ("Add Customer Profile".equals(cmd)) {
                    new Add_customer().setVisible(true);
                } 
                else if (cmd.equals("View Customer Profile")) {
                    new View_customer().setVisible(true);
                } 
                else if (cmd.equals("Update Customer Profile")) {
                    new Update_customer().setVisible(true);
                } 
                else if (cmd.equals("Book Cab")) {
                    new Book_cab().setVisible(true);
                } 
                else if (cmd.equals("View Booked Cab")) {
                    new View_booked_cab().setVisible(true);
                } 
                else if (cmd.equals("Book Intercity Cab")) {
                    new book_intercity_cab().setVisible(true);
                } 
                else if (cmd.equals("View Booked Intercity Cab")) {
                    new View_intercity_booked_cab().setVisible(true);
                } 
                else if (cmd.equals("Book Package")) {
                    new Book_package().setVisible(true);
                } 
                else if (cmd.equals("View Booked Package")) {
                    new View_booked_package().setVisible(true);
                } 
                else if (cmd.equals("Check Bill")) {
                    new Check_bill().setVisible(true);
                } 
                else if (cmd.equals("Delete Customer")) {
                    new Delete_customer().setVisible(true);
                } 
                else if (cmd.equals("About")) {
                    new About().setVisible(true);
                } 
                else if (cmd.equals("Exit")) {
                    System.exit(0);
                }
            }
        };
        meni1.addActionListener(menuListener);
        meni2.addActionListener(menuListener);
        meni3.addActionListener(menuListener);
        meni4.addActionListener(menuListener);
        meni5.addActionListener(menuListener);
        meni6.addActionListener(menuListener);
        meni7.addActionListener(menuListener);
        meni8.addActionListener(menuListener);
        meni9.addActionListener(menuListener);
        meni10.addActionListener(menuListener);
        meni11.addActionListener(menuListener);
        meni12.addActionListener(menuListener);
        meni13.addActionListener(menuListener);
        


    }

    

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
