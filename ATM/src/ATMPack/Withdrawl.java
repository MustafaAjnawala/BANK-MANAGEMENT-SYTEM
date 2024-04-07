package ATMPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	JButton withdraw ,back;
	JTextField amount;
	String pinnumber;
	Withdrawl( String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);//to make setBounds function work
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);	
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		text.setBounds(190,300,400,25);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,20);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
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
		if(ae.getSource()==withdraw) {
			String withdrawAmnt = amount.getText();
			Date date = new Date();
			if(withdrawAmnt.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter amount to withdraw");
			} else {
				try {
				Conn conn = new Conn();
				ResultSet rs = conn.s.executeQuery("select * from transaction where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance < Integer.parseInt(withdrawAmnt)) {
                	JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                  
                }else {
                	String query = "insert into transaction values('"+pinnumber+"','"+date+"','Withdrawl' ,'"+withdrawAmnt+"')";
    				conn.s.executeUpdate(query);
    				JOptionPane.showMessageDialog(null, "Rs "+withdrawAmnt+" Withdraw successfully");
    				setVisible(false);
    				new Transactions(pinnumber).setVisible(true);
    				
                }		
				
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
		new Withdrawl("");
	}

}
