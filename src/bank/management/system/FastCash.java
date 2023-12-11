
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,checkbalance,exit;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235, 220, 700, 35);
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit=new JButton("Rs.100");
        deposit.setBounds(208, 249, 125,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Rs.500");
        withdrawl.setBounds(367, 249, 125,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Rs.1000");
        fastcash.setBounds(208, 279, 125,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs.2000");
        ministatement.setBounds(367, 279, 125,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Rs.5000");
        pinchange.setBounds(208, 309, 125,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        checkbalance=new JButton("Rs.10000");
        checkbalance.setBounds(367, 309, 125,20);
        checkbalance.addActionListener(this);
        image.add(checkbalance);
        
        exit=new JButton("Back");
        exit.setBounds(367, 333, 125,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            //conn c=new conn();
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    
                    }
                    
                
                
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Account Balance");
                            return;
                    
                
                }else{
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+" Debited Sucessfully");
                }
   
                
            
            }catch(Exception e){
                System.out.println(e);
            
            }
        
        
        }
    
    }

    public static void main(String args[]) {
        new FastCash("");
        
    }
}
