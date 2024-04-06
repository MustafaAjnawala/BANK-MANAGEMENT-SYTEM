package ATMPack;

import javax.swing.*;
import java.awt.*;//for the images to be imported
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit,withdrawl,fastCash,balanceEnquiry,pinChange,exit;
	
	Transactions(){
		setLayout(null);		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Select your Transaction");
		text.setBounds(235,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		image.add(text);//to add text above the image
		
		deposit  = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl  = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastCash  = new JButton("Fast Cash");
		fastCash.setBounds(170,450,150,30);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		balanceEnquiry  = new JButton("Blance Enquiry");
		balanceEnquiry.setBounds(355,450,150,30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		pinChange  = new JButton("Pin Change");
		pinChange.setBounds(170,485,150,30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		exit  = new JButton("Exit");
		exit.setBounds(355,485,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		new Transactions();
	}

}
