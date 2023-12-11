
package bank.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text=new JLabel("Enter amount you want to Withdraw");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,13));
        text.setBounds(235, 220, 700, 35);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,13));
        amount.setBounds(255, 255, 175, 20);
        image.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(367, 309, 125, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(367, 333, 125, 20);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==withdraw){
        String number = amount.getText();
        Date date = new Date();
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
        } else {
            try {
                conn conn = new conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(number)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Account Balance");
                    return;
                } else {
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+number+" withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } catch(Exception e) {
                System.out.println(e);
            }   
        }
    } else if(ae.getSource()==back) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}



    public static void main(String args[]) {
        new Withdrawl("");
        //SwingUtilities.invokeLater(()->new Deposit());
        
    }
}
