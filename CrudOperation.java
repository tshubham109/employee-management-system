package com.swing;
import java.sql.*;

public class CrudOperation 
{
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	public static void CloseConnection()
	{
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public static ResultSet fetchData(String sql) throws Exception
	{
		try {
			con=connection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
		}
		catch(SQLException se)
		{System.out.println(se);}
		return rs;
	}
public static Connection connection()throws Exception
{
Class.forName("com.mysql.jdbc.Driver");//Load the Driver
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
Statement stmt=con.createStatement();
return con;
}
public static void main(String[] args)throws Exception {
	connection();
}

}
