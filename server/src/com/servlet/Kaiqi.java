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

import com.dao.KechengDao;
import com.dao.UserDao;

public class Kaiqi extends HttpServlet {

	
	public Kaiqi() {
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
			System.out.println("��������:" + reqMessage);
			reqObject = new JSONArray(reqMessage);
			KechengDao kc=new KechengDao();
			
		   kc.update(reqObject.getJSONObject(0)
					.getString("selecte"));
		   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
