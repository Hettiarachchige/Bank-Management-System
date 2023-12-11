package bank.management.system;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login(){
        
        setTitle("HNB ATM"); 
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //label to welcome atm
        JLabel text=new JLabel("WELCOME TO HNB ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 500, 40);
        add(text);
        
        //text label to cardNo
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        /*JLabel hashini=new JLabel("Power By Hashini Nishara Rupasighe");
        hashini.setFont(new Font("Raleway",Font.BOLD,10));
        hashini.setBounds(10, 400, 600, 30);
        add(hashini);*/
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        //cardTextField.setBackground(Color.black);
        //cardTextField.setForeground(Color.white);
        add(cardTextField);
        

        
        //label to pin
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        //cardTextField.setBackground(Color.black);
        //cardTextField.setForeground(Color.white);
        add(pinTextField);
        
        //Sign in button
        login=new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);
        
        //clear button
        clear=new JButton("RESET");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        //clear.setBackground(Color.red);
       // clear.setForeground(Color.black);
        add(clear);
        
        //register/sign in button
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        
        }else if(ae.getSource()==login){
            conn conn=new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
               /* }else if(cardnumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Card number is required");
                
                }*/
                
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                
                }
            
            }catch(Exception e){
                System.out.println(e);
            
            }
        
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        
        }
        
        
    }


    public static void main(String args[]) {
        new Login();
        
    }
}
