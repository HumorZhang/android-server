package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.TeacherBean;
import com.bean.UserBean;
import com.tools.DBTools;

public class TeacherDao {
	
	
	public static TeacherBean Selectbyname(String name) {
	
		TeacherBean teacher=null;
		Connection con=DBTools.getConnection();
		String sql="select * from tab_admin where username=?";
		PreparedStatement sta=null;
		ResultSet res =null;
		try {
			sta=con.prepareStatement(sql);
			sta.setString(1,name);
			
			res=sta.executeQuery();
			while(res.next()){
				teacher= new TeacherBean();
				
				teacher.setUsername(res.getString("username"));
				teacher.setPassword(res.getString("password"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			DBTools.closeAll(con, sta, res);
		}
		return teacher;
		
		
	}
}
