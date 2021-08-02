package sqlServerPractice;
import java.io.*;
import java.sql.*;
import java.sql.CallableStatement;

public class Booklist {
	Connection con;
	
	public void booklist() {
		String Driver="";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=Madang;";
		String userid="mduser";
		String pwd="mdpass";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Loaded");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Connecting to the database...");
			con=DriverManager.getConnection(url,userid,pwd);
			System.out.println("Connected to the database");
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	private void sqlRun() {
		String query = "SELECT * FROM Book";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			System.out.printf("BOOK NO\tBOOK NAME\tPUBLISHER\tPRICE\n");
			while(rs.next()) {
				System.out.print("	"+rs.getInt(1));
				System.out.print("	"+rs.getString(2));
				System.out.print("	"+rs.getString(3));
				System.out.print("	"+rs.getInt(4));
			}
			
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Booklist so=new Booklist();
		so.sqlRun();
	}
}
