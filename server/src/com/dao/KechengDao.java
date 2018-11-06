package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Time;
import com.bean.UserBean;
import com.tools.DBTools;

public class KechengDao {
	public ArrayList<Time> selectbyMon(){
		Time time = null;
		Connection con = DBTools.getConnection();
		
		String sql = "select * from tab_time ";//Õ¼Î»·û
		PreparedStatement sta = null;
		ArrayList<Time> times = new ArrayList<Time>();
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			
			res = sta.executeQuery();
			while(res.next()){
				time = new Time();
				time.setShijian(res.getString("Time"));
				time.setKecheng(res.getString("keming"));
				times.add(time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTools.closeAll(con,sta,res);
		}
		return times;
		
		
		
	}
	
	public Time Selectbytime(String time) {
		Time kc=null;
		Connection con=DBTools.getConnection();
		String sql="select * from tab_time where Time=?";
		PreparedStatement sta=null;
		ResultSet res =null;
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,time);
			
			res=sta.executeQuery();
			while(res.next()){
				kc= new Time();
				
				kc.setName(res.getString("name"));
				kc.setNumber(res.getString("number"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, res);
		}
		return kc;
		
		
	}
	
	
public void update(String va1){
		
		Connection con = DBTools.getConnection();
		String sql = "update tab_time set buff=1 where Time=?";
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
	
	}
public void updatebybuff(String va1,int va2){
	
	Connection con = DBTools.getConnection();
	String sql = "update tab_time set name=? ,number=? where buff=1";
	PreparedStatement sta = null;
	
	try {
		sta = con.prepareStatement(sql);
		sta.setString(1,va1);
		sta.setInt(2, va2);
		
	
		sta.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBTools.closeAll(con,sta,null);
	}

}

public void Clear() {
	
	Connection con=DBTools.getConnection();
	String sql= "update tab_time set buff=0";
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
	
}
