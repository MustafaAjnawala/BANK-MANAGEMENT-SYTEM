package ATMPack;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
        
public class Signup extends JFrame implements ActionListener {
	
	long random;
	JTextField nameTF, fnameTF,emailTF,addressTF,cityTF,stateTF,pincodeTF;
	JButton next;
	JRadioButton male,female,married,unmarried;
	JDateChooser dateChooser;
        
    Signup(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno = new JLabel("Application Form no. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        nameTF.setBounds(300,140,400,30);
        add(nameTF);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTF.setBounds(300,190,400,30);
        add(fnameTF);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.GREEN);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        //creating a Button Group so that both dont get selected together
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway",Font.BOLD,14));
        emailTF.setBounds(300,340,400,30);
        add(emailTF);
        
        JLabel marital_status = new JLabel("Marital Status: ");
        marital_status.setFont(new Font("Raleway",Font.BOLD,22));
        marital_status.setBounds(100,390,200,30);
        add(marital_status);
        
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway",Font.BOLD,14));
        addressTF.setBounds(300,440,400,30);
        add(addressTF);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        cityTF.setBounds(300,490,400,30);
        add(cityTF);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        stateTF.setBounds(300,540,400,30);
        add(stateTF);
        
        JLabel pincode = new JLabel("Pin code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodeTF = new JTextField();
        pincodeTF.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTF.setBounds(300,590,400,30);
        add(pincodeTF);
        
        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    //overiding the function of the actionListener interface implemented
    public void actionPerformed(ActionEvent ae) {
    	//firstly getting out all the values of the page
    	String formno = "" + random;// converting long to string
    	String name = nameTF.getText();
    	String fname = fnameTF.getText();
    	//converting it to textfield and then performing getText as it returns a textField.
    	String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
    	String gender = null;
    	if(male.isSelected()) 
    		gender = "Male";
    	else if(female.isSelected())
    		gender = "Female";
    	
    	String email = emailTF.getText();
    	String marital = null;
    	if(married.isSelected())
    		marital = "Married";
    	else if(unmarried.isSelected())
    		marital = "Unmarried";
    	
    	String address = addressTF.getText();
    	String city = cityTF.getText();
    	String state = stateTF.getText();
    	String pin = pincodeTF.getText();
    	
    	try {
    		//adding validation
    		if(name.equals(""))
    			JOptionPane.showMessageDialog(null, "Name is required");
    		else {//establishing connection with DB
    			Conn c = new Conn();
    			String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";	 
    			c.s.executeUpdate(query);
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
    
    public static void main(String[] args){
        new Signup();
    }
}
