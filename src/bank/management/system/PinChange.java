
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
        JPasswordField pin,repin;
        JButton change,exit;
        String pinnumber;
        
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
       
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.black);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(275, 220, 700, 35);
        image.add(text);
        
        JLabel pintext=new JLabel("NEW PIN:");
        pintext.setForeground(Color.black);
        pintext.setFont(new Font("System",Font.BOLD,14));
        pintext.setBounds(210, 250, 180, 25);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(350, 250, 140, 25);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.black);
        repintext.setFont(new Font("System",Font.BOLD,14));
        repintext.setBounds(210, 280, 180, 25);
        image.add(repintext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        repin.setBounds(350, 280, 140, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(367, 310, 123, 20);
        change.addActionListener(this);
        image.add(change);
                
        exit=new JButton("Back");
        exit.setBounds(367, 333, 123,20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
            return;
            }
            if(npin.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter New PIN");
            return;
            
            }
            if(rpin.equals("")){
            JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
            return;
            
            }
            conn conn=new conn();
            String query1="update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
            String query2="update login set pin ='"+rpin+"' where pin='"+pinnumber+"'";
            String query3="update signupthree set pinnumber ='"+rpin+"' where pinnumber='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
            
            setVisible(false);
            new Transaction(rpin).setVisible(true);

        
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
      }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
                        
        
        
        }
    
    
    }


    public static void main(String args[]) {
      new PinChange("").setVisible(true);  
    }
}
