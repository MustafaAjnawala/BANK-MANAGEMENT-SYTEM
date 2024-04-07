package ATMPack;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, exit, b8;
    JTextField t1;
    String pinnumber;

    FastCash(String pin) {
        this.pinnumber = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(220, 325, 700, 30);
        l3.add(l1);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(170, 415, 150, 30);
        b1.addActionListener(this);
        l3.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 450, 150, 30);
        b3.addActionListener(this);
        l3.add(b3);

        
        b4 = new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 485, 150, 30);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        l3.add(b6);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        l3.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from transaction where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                    
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance!");
//                        return;
                    } else {
                    Date date = new Date();
                    String query = "insert into transaction values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully!");
                    
                    }
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}