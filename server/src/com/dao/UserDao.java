package com.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.bean.UserBean;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tools.DBTools;

public class UserDao {
	
	public UserBean Selectbyid(String id) {
		UserBean user=null;
		Connection con=DBTools.getConnection();
		String sql="select * from tab_user where id=?";
		PreparedStatement sta=null;
		ResultSet res =null;
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,id);
			
			res=sta.executeQuery();
			while(res.next()){
				user= new UserBean();
				
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, res);
		}
		return user;
		
		
	}
	
	
	
	public UserBean Selectbyname(String id) {
		UserBean user=null;
		Connection con=DBTools.getConnection();
		String sql="select * from tab_user where username=?";
		PreparedStatement sta=null;
		ResultSet res =null;
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,id);
			
			res=sta.executeQuery();
			while(res.next()){
				user= new UserBean();
				
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, res);
		}
		return user;
		
		
	}
	
	
	public void Clear() {
	
		Connection con=DBTools.getConnection();
		String sql= "update tab_user set buff=0";
		PreparedStatement sta=null;
	
		try {
			sta=con.prepareStatement(sql);
			
			
			sta.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, null);
		}
	}
	
	

	public UserBean update(String va1){
		
		Connection con = DBTools.getConnection();
		String sql = "update tab_user set buff=1 where username=?";
		PreparedStatement sta = null;
		
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1,va1);
			
			
		
			sta.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.closeAll(con,sta,null);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<UserBean> selectbybuff(String buff){
		UserBean user = null;
		Connection con = DBTools.getConnection();
		
		String sql = "select * from tab_user where buff=?";//Õ¼Î»·û
		PreparedStatement sta = null;
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1,buff);
			res = sta.executeQuery();
			while(res.next()){
				user = new UserBean();
				user.setUsername(res.getString("username"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.closeAll(con,sta,res);
		}
		return users;
		
		
		
	}
	public UserBean insert(String va1,String va2,String va3){
		
		Connection con = DBTools.getConnection();
		String sql = "insert into tab_user(username,password,buff,id) values(?,?,?,?)";
		PreparedStatement sta = null;
		
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1,va1);
			sta.setString(2,va2);
			sta.setString(3, "0");
			sta.setString(4,va3);
			sta.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.closeAll(con,sta,null);
		}
		return null;
	}



}
