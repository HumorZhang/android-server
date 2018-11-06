package com.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bean.Time;
import com.bean.UserBean;
import com.dao.GgDao;
import com.dao.KechengDao;
import com.dao.UserDao;

public class Kebiao extends HttpServlet {

	
	public Kebiao() {
		super();
	}

	public void destroy() {
		super.destroy(); 
		
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
		
		String abc="";
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
			KechengDao kecheng=new KechengDao();
			ArrayList<Time> times = kecheng.selectbyMon();
			JSONObject jsonObject=new JSONObject();
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<times.size();i++){
				
				
				jsonObject.put(times.get(i).getShijian(),times.get(i).getKecheng());
				
					
					
					System.out.println(times.get(i).getKecheng());
				 
				
				
				
				 
		     				
				}
			jsonArray.put(jsonObject);
			//System.out.println(jsonArray.toString());
			abc=jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("返回数据:" + abc);
			PrintWriter pw = response.getWriter();
			pw.write(abc);
			pw.flush();
			pw.close();
		}
    
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
