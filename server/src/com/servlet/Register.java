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
import org.json.JSONException;

import com.bean.UserBean;
import com.dao.UserDao;

public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		String reqMessage;
		JSONArray reqObject = null;
		
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
			System.out.println("ÇëÇóÊý¾Ý:" + reqMessage);
			reqObject = new JSONArray(reqMessage);
			UserDao userDao = new UserDao();
			new UserDao().insert(reqObject.getJSONObject(0)
					.getString("username"), 
					reqObject.getJSONObject(0).getString("password"),
					reqObject.getJSONObject(0).getString("id"));
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
}
		
	

	public void init() throws ServletException {
		// Put your code here
	}

}
