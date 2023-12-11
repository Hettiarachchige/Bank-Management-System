
package bank.management.system;
 
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SignupTwo  extends JFrame implements ActionListener{
    
    JTextField dobTextField,nameTextField,emailTextField,addressTextField,cityTextField,stateTextField,phoneNumberTextField;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
        
        JLabel additionalDetails=new JLabel("Page 2: Aditional Details");
       additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[]={"Sinhala","Tamil","Muslim","English","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        JLabel dob=new JLabel("Category:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
        
        String valCategory[]={"General","Saving","Fix"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        
        JLabel gender=new JLabel("Income:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 240, 200, 30);
        add(gender);
        
        String valIncome[]={"Null","<150,000","<250,000","<500,000","upto 10 Lak"};
        income=new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income); 

        
        
        JLabel email=new JLabel("Educational");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 290, 200, 30);
        add(email);
        JLabel marital=new JLabel("Qualification:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 315, 200, 30);
        add(marital);
        String valEducation[]={"Non-Graduate","Graduate","Post-Graduate","PHD","Other"};
        education=new JComboBox(valEducation);
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.white);
        add(education); 

        
        JLabel address=new JLabel("Occupation");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 390, 200, 30);
        add(address);
        String valOccupation[]={"Salaried","Self-Employee","Business","Student","Other"};
       occupation=new JComboBox(valOccupation);
       occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation); 

        
        JLabel city=new JLabel("Senior Citizen:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 440, 200, 30);
        add(city);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300, 430, 100, 50);
        syes.setBackground(Color.white);
        add(syes); 
        sno=new JRadioButton("No");
        sno.setBounds(400, 430, 100, 50);
        sno.setBackground(Color.white);
        add(sno); 
        ButtonGroup senior=new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
        JLabel state=new JLabel("Existing Accounts:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 490, 200, 30);
        add(state);
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300, 480, 100, 50);
        eyes.setBackground(Color.white);
        add(eyes); 
        eno=new JRadioButton("No");
        eno.setBounds(400, 480, 100, 50);
        eno.setBackground(Color.white);
        add(eno); 
        ButtonGroup exist=new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);
        
        JLabel pincode=new JLabel("Phone Number:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);
        phoneNumberTextField=new JTextField();
        phoneNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        phoneNumberTextField.setBounds(300, 540, 400, 30);
        add(phoneNumberTextField);
        
        
        

        
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
    
        private void checkLength() {
        if (phoneNumberTextField.getText().length() > 10) {
            phoneNumberTextField.setText(phoneNumberTextField.getText().substring(0, 10));
        }
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String senior=null;
        if(syes.isSelected()){
            senior="Yes";
        }else if(sno.isSelected()){
            senior="NO";
            
        }
        
        String existAccount=null;
        if(eyes.isSelected()){
        existAccount="Yes";
        }else if(eno.isSelected()) {
        existAccount="No";
        }

        String sphoneNumber=phoneNumberTextField.getText();
        
        try{
            conn c=new conn();
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+senior+"','"+existAccount+"','"+sphoneNumber+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            
            //signup 3 object
            new SignupThree(formno).setVisible(true);

        
        
        
        
        
        }catch(Exception e){
            
        System.out.println(e);
        
        }
            
        
    
    
    }
    
    

    
    public static void main(String args[]) {
       new SignupTwo("");
       
    }
}
