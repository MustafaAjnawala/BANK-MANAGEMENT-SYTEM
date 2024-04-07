package ATMPack;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

        
public class Signup2 extends JFrame implements ActionListener {
    JComboBox religion,category,income,education,occupation;
    JRadioButton syes,sno;
    JRadioButton eyes,eno;
    JTextField aadhar,pan;
	String formno2;
    
    Signup2(String formno){
        // add formno here
        setLayout(null);
        
        formno2 = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel xformno = new JLabel("Application Form no. " + formno);
        xformno.setFont(new Font("Raleway",Font.BOLD,38));
        xformno.setBounds(140,20,600,40);
        add(xformno);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel xreligion = new JLabel("Religion: ");
        xreligion.setFont(new Font("Raleway",Font.BOLD,22));
        xreligion.setBounds(100,140,120,30);
        add(xreligion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion =  new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
      
        
        JLabel xcategory = new JLabel("Category: ");
        xcategory.setFont(new Font("Raleway",Font.BOLD,22));
        xcategory.setBounds(100,190,200,30);
        add(xcategory);
        
        
        String valCategory[] = {"General","OBC","SC","ST","OTHER"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel xincome = new JLabel("Income: ");
        xincome.setFont(new Font("Raleway",Font.BOLD,22));
        xincome.setBounds(100,240,200,30);
        add(xincome);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel xeducation = new JLabel("Educational");
        xeducation.setFont(new Font("Raleway",Font.BOLD,22));
        xeducation.setBounds(100,290,200,30);
        add(xeducation);
        
        
        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationCategory[] = {"Non-Graduate","Graduate","Post-Graduate","Other"};
        education = new JComboBox(educationCategory);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel xoccupation = new JLabel("Occupation: ");
        xoccupation.setFont(new Font("Raleway",Font.BOLD,22));
        xoccupation.setBounds(100,390,200,30);
        add(xoccupation);
        
        String occCategory[] = {"Salaried","Self-Employed","Buisness","Student","Other"};
        occupation = new JComboBox(occCategory);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
  
        JLabel xpan = new JLabel("PAN Number: ");
        xpan.setFont(new Font("Raleway",Font.BOLD,22));
        xpan.setBounds(100,440,200,30);
        add(xpan);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel xaadhar = new JLabel("Adhar number: ");
        xaadhar.setFont(new Font("Raleway",Font.BOLD,22));
        xaadhar.setBounds(100,490,200,30);
        add(xaadhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel xsenior = new JLabel("Senior Citizen: ");
        xsenior.setFont(new Font("Raleway",Font.BOLD,22));
        xsenior.setBounds(100,540,200,30);
        add(xsenior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel xexistingaccount = new JLabel("Existing account: ");
        xexistingaccount.setFont(new Font("Raleway",Font.BOLD,22));
        xexistingaccount.setBounds(100,590,200,30);
        add(xexistingaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
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
    
    public void actionPerformed(ActionEvent ae){
//            String formno =  "demo" ;
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            
            String seniorcitizen = null;
            if(syes.isSelected()){
                seniorcitizen = "yes";
            }else if(sno.isSelected()){
                seniorcitizen = "no";
            }
            
            String existingaccount = null;
            if(eyes.isSelected()){
                existingaccount = "yes";
            }else if(eno.isSelected()){
                existingaccount = "no";
            }
            
            String span = pan.getText();
            String saadhar = aadhar.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno2+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                //Signup3 object 
                setVisible(false);
                new Signup3(formno2).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
            }
    }
    
    public static void main(String[] args){
        new Signup2("");
    }
}