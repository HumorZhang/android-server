package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.bean.UserBean;
import com.dao.UserDao;

public class Sign extends HttpServlet {

	
	public Sign() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		String reqMessage, respMessage;
		JSONArray reqObject = null;
		JSONArray respObject = null;
		String abc=null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			reqMessage = sb.toString();
			System.out.println("请求数据:" + reqMessage);
			reqObject = new JSONArray(reqMessage);
			UserDao userDao = new UserDao();
			UserBean ub = userDao.Selectbyname(reqObject.getJSONObject(0)
					.getString("username"));
			if (ub.getPassword() != null ) {
			 abc=ub.getUsername();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("返回数据:" + abc);
			PrintWriter pw = response.getWriter();
			pw.write(abc);
			pw.flush();
			pw.close();
		}
		
             new UserDao().update(abc);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
