
package bank.management.system;
 
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser; 


public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField dobTextField,nameTextField,emailTextField,addressTextField,nicTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    JComboBox district;
    SignupOne(){
        
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()% 9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField); 
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,190,200,30);
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 240, 200, 30);
        add(gender);
        male=new JRadioButton("Male");
        male.setBackground(Color.white);
        male.setBounds(300, 240, 60, 30);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(435, 240, 80, 30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email=new JLabel("Email");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 290, 200, 30);
        add(email);
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 290, 400, 30);
        add(emailTextField); 
        
        JLabel marital=new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 340, 200, 30);
        add(marital);
        married=new JRadioButton("Married");
        married.setBackground(Color.white);
        married.setBounds(300, 340, 100, 30);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(435, 340, 100, 30);
        add(unmarried);
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        JLabel address=new JLabel("Address ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 390, 200, 30);
        add(address);
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 390, 400, 30);
        add(addressTextField); 
        
        JLabel city=new JLabel("District");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 440, 200, 30);
        add(city);
        
        String valReligion[]={"","Colombo","Kandy","Jaffna","Anuradhapura","Galle","Polonnaruwa","Kandy","Nuwara Eliya","Ratnapura","Kurunagala","Badulla","Matara","Hambantota"};
        district=new JComboBox(valReligion);
        district.setFont(new Font("Raleway",Font.BOLD,14));
        district.setBounds(300, 440, 400, 30);
        add(district); 
        
        JLabel nic=new JLabel("NIC Number");
        nic.setFont(new Font("Raleway",Font.BOLD,20));
        nic.setBounds(100, 490, 200, 30);
        add(nic);
        nicTextField=new JTextField();
        nicTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nicTextField.setBounds(300, 490, 400, 30);
        add(nicTextField); 
        
        JLabel pincode=new JLabel("Postal Code");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300, 540, 200, 30);
        add(pincodeTextField); 
        
        next=new JButton("Next");
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Bank Management System");
        setSize(850,750);
        setLocation(350,10);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
            
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
        marital="Married";
        }else if(unmarried.isSelected()) {
        marital="Unmarried";
        }
        String address=addressTextField.getText();
        String sdistrict=(String)district.getSelectedItem();
        String nic=nicTextField.getText();
        String pincode=pincodeTextField.getText();
        
        try{
            
            
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        
        }else if(dob.equals("")){
            JOptionPane.showMessageDialog(null, "Date of birth is Required");
        
        }
        else{
            conn c=new conn();
            String query="insert into signup values('"+formno+"','"+name+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+sdistrict+"','"+nic+"','"+pincode+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
            
            


        
        
        
        }
        
        }catch(Exception e){
            
        System.out.println(e);
        
        }
            
        
    
    
    }
    
    

    
    public static void main(String args[]) {
       new SignupOne();
       
    }
}
