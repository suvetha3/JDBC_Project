package dao;

import java.sql.*;

import connectionmanager.connectionmanager;
import model.login;

public class logindao 
{
  public boolean validate(login log) throws ClassNotFoundException, SQLException
  {
	  String username=log.getUsername();
	  String password=log.getPassword();
	  connectionmanager conm=new connectionmanager();
	  Connection con = conm.establishConnection();
	  Statement s=con.createStatement();
	  ResultSet rs=s.executeQuery("select * from login");
	  while(rs.next())
	  {
		  if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
		  {
			 return true; 
		  }
	  }
	  conm.closeConnection();
	  return false;
  }
}
