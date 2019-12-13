package com.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.model.Login;
import com.model.Register;


public class CentralDb {
	Connection con;
	Register r;
	PreparedStatement ps;
	int i;
	
	public void myConnection() throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","1234");
		
		
	}
	public int saveData(Register r) throws Exception
	{
		myConnection();
		ps=con.prepareStatement("insert into Reg values(?,?,?,?)");
		ps.setString(1, r.getFirstname());
		ps.setString(2, r.getLastname());
		ps.setString(3, r.getUsername());
		ps.setString(4, r.getPassword ());
		int i=ps.executeUpdate();
		con.close();
		return i;
		
		
	}
	public Login validate(String Username,String Password)throws Exception
	{
		
			myConnection();
		
			ps=con.prepareStatement("select Uname , Password from Reg where Username=? and Password=?");
			ps.setString(1, Username );
			ps.setString(2,  Password);	
		ResultSet rs;
	rs = ps.executeQuery();
		
		Login l=new Login();
				
				
					while(rs.next())
					{
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						l.setUsername(s1);
						l.setPassword(s2);
					}
		
		
		return l;
		
	}
}
