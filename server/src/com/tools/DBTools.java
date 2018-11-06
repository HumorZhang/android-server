package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBTools {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		}
	
	public static Connection  getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biyesheji","root","root");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return con;
		
	}
	public static void closeAll(Connection con,Statement sta,ResultSet res) {
		
			try {
				if(null!=res)
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				if(null!=sta){
					sta.close();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		
			try {
				if(null!=con)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		
		
		
	}
	
	
}
