package ATMPack;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	public Conn(){
		try {
			c = DriverManager.getConnection("jdbc:mysql:///bank","root","password");
			s= c.createStatement();
			System.out.println("Connected to databse");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
