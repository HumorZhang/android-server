package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Gonggao;
import com.bean.UserBean;
import com.tools.DBTools;

public class GgDao {
	
	public Gonggao Select() {
		Gonggao gonggao=null;
		Connection con=DBTools.getConnection();
		String sql="select * from tab_gonggao";
		PreparedStatement sta=null;
		ResultSet res =null;
		try {
			sta=con.prepareStatement(sql);
			
			
			res=sta.executeQuery();
			while(res.next()){
				gonggao =new Gonggao();
				gonggao.setNeirong(res.getString("gonggao"));
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, res);
		}
		return gonggao;
		
		
	}
	
public void update(String va1){
		
		Connection con = DBTools.getConnection();
		String sql = "update tab_gonggao set gonggao=?";
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
	
	
	

}
