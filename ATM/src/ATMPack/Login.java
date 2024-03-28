package ATMPack;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
	//class inheriting the Jframe and implementing the actionListener for adding actions to buttons
	public class Login extends JFrame implements ActionListener {
		JButton login,clear,sinup;//defining them globally to access outside the constructor too
		JTextField cardText;
		JPasswordField pinText;
		
		Login(){
			setTitle("ATM Window");//setting name to the window
						
			setLayout(null);//to set the by default layout as null
			
			ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
			Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //to scale the image
			ImageIcon i3 = new ImageIcon(i2);
			JLabel label= new JLabel(i3); //as can't place ImageIcon individually
			label.setBounds(50, 10, 100, 100);
			add(label);
			
			//to add the Page Heading
			JLabel text = new JLabel("Welcome to ATM");
			text.setFont(new Font("Osward",Font.BOLD,40));
			text.setBounds(230, 10, 400, 100);
			add(text);
			
			JLabel card = new JLabel("Card No.:");
			card.setFont(new Font("Raleway",Font.BOLD,30));
			card.setBounds(140, 150, 400, 100);
			add(card);
			
			//to add the textfield for the Card num
			cardText = new JTextField();
			cardText.setBounds(300, 180, 230, 35);
			cardText.setFont(new Font("Raleway",Font.PLAIN,15));
			add(cardText);
			
			JLabel pin = new JLabel("PIN:");
			pin.setFont(new Font("Raleway",Font.BOLD,30));
			pin.setBounds(140, 220, 400, 100);
			add(pin);
			
			pinText = new JPasswordField();
			pinText.setBounds(300, 255, 230, 35);
			pinText.setFont(new Font("Raleway",Font.PLAIN,15));
			add(pinText);
			
			//to add the signin button
			login  =new JButton("SIGN IN");
			login.setBounds(300,320,100,30);
			login.setBackground(Color.BLACK);
			login.setForeground(Color.WHITE);
			login.addActionListener(this);
			add(login);
			
			clear  =new JButton("CLEAR");
			clear.setBounds(430,320,100,30);
			clear.setBackground(Color.BLACK);
			clear.setForeground(Color.WHITE);
			clear.addActionListener(this);
			add(clear);
			
			sinup  =new JButton("SIGN UP");
			sinup.setBounds(300,370,230,30);
			sinup.setBackground(Color.BLACK);
			sinup.setForeground(Color.WHITE);
			sinup.addActionListener(this);
			add(sinup);
			
			getContentPane().setBackground(Color.gray);//to set the color of the window BG
			
			setSize(800,480);
			setVisible(true);//for showing the ATM window
			setLocation(350,200);
		}
		
		public void actionPerformed(ActionEvent ae) {
			//for overriding the method in the interface
			if(ae.getSource() == clear) {
				cardText.setText("");
				pinText.setText("");
				
			} else if(ae.getSource() == login) {
				
			} else if(ae.getSource() == sinup) {
				
			}
		}
		
		public static void main(String args[]) {
			new Login();
		}
	
	}
