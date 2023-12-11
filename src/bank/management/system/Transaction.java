
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,checkbalance,exit,logout;
    String pinnumber;

    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(235, 220, 700, 35);
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(208, 249, 125,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(367, 249, 125,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(208, 279, 125,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(367, 279, 125,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(208, 309, 125,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        checkbalance=new JButton("Check Balance");
        checkbalance.setBounds(367, 309, 125,20);
        checkbalance.addActionListener(this);
        image.add(checkbalance);
        
        exit=new JButton("Exit");
        exit.setBounds(367, 333, 125,20);
        exit.addActionListener(this);
        image.add(exit);
        
        logout=new JButton("Log Out");
        //logout.setBackground(Color.black);
        //logout.setForeground(Color.white);
        logout.setBounds(208, 333, 125,20);
        logout.addActionListener(this);
        image.add(logout);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
    
    
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
            System.exit(0);
        
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        
        }else if(ae.getSource()==checkbalance){
            setVisible(false);
            new CheckBalance(pinnumber).setVisible(true);
        
       }else if(ae.getSource()==ministatement){
           
           new MiniStatement(pinnumber).setVisible(true);
       
       }else if(ae.getSource()==logout){
           setVisible(false);
           new Login().setVisible(true);
       
       }
    
    }

    public static void main(String args[]) {
        new Transaction("");
        
    }
}
