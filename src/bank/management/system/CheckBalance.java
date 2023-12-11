package bank.management.system;

import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CheckBalance extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;

    CheckBalance(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);

        JLabel text = new JLabel("Your Account Balance is:");
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(235, 220, 700, 35);
        image.add(text);

        try {
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            JLabel balanceLabel = new JLabel("Rs. " + balance);
            balanceLabel.setForeground(Color.black);
            balanceLabel.setFont(new Font("System", Font.BOLD, 18));
            balanceLabel.setBounds(310, 250, 300, 35);
            image.add(balanceLabel);
        } catch (Exception e) {
            System.out.println(e);
        }

        back = new JButton("Back");
        back.setBounds(367, 333, 125, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new CheckBalance("").setVisible(true);
    }
}
