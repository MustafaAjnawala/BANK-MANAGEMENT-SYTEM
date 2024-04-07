package ATMPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	JButton deposit,back;
	JTextField amount;
	String pinnumber;
	Deposit( String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);//to make setBounds function work
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		text.setBounds(190,300,400,25);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,20);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			String depoAmnt = amount.getText();
			Date date = new Date();
			if(depoAmnt.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter amount to enter");
			} else {
				try {
				Conn conn = new Conn();
				String query = "insert into transaction values('"+pinnumber+"','"+date+"','Deposit' ,'"+depoAmnt+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+depoAmnt+" deposited successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);;
		}
	}
	
	public static void main(String args[]) {
		new Deposit("");
	}

}
