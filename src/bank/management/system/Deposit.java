
package bank.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text=new JLabel("Enter amount you want to Deposit");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,13));
        text.setBounds(235, 220, 700, 35);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,13));
        amount.setBounds(255, 255, 175, 20);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(367, 309, 125, 20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(367, 333, 125, 20);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want deposit");
            
            }else{
                try{
                conn conn=new conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+number+" Deposit Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                
                }   
            
            }
        
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        
        }
    
    }


    public static void main(String args[]) {
        new Deposit("");
        //SwingUtilities.invokeLater(()->new Deposit());
        
    }
}
