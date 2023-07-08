package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionmanager.connectionmanager;
import model. product;

public class productdao 
{
	public void addProduct(product product) throws ClassNotFoundException, SQLException
	{
		//1.Java and JDBC connect
		connectionmanager conm=new connectionmanager();
		Connection con=conm.establishConnection(); 
		
		String sql_query = "insert into product(productId,productname,minsellquantity,price,quantity) values (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinsellquantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
		
		conm.closeConnection();
		
	}
	public void display() throws ClassNotFoundException, SQLException {
		connectionmanager conm=new connectionmanager();
		Connection con=conm.establishConnection(); 
		 Statement s=con.createStatement();
		  ResultSet rs=s.executeQuery("select * from product");
		  while(rs.next())			  
			  {
				 System.out.println(rs.getInt("productId")+"|"+rs.getString("productName")+"|"+rs.getInt("minsellquantity")+"|"+rs.getInt("price")+"|"+rs.getInt("quantity"));
			  }
		
		
	}

}