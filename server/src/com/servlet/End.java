package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.bean.UserBean;
import com.dao.KechengDao;
import com.dao.UserDao;

public class End extends HttpServlet {

	
	public End() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		String reqMessage, respMessage;
		JSONArray reqObject = null;
		JSONArray respObject = null;
		
		String abc="";
		int p=1;
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
		
			UserDao userDao = new UserDao();
			ArrayList<UserBean> users = userDao.selectbybuff("1");
			
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<users.size();i++){
			
				if(i==(users.size()-1)) 
				{
					abc += users.get(i).getUsername();
					
				}
				else {
					abc += users.get(i).getUsername();  
			           abc += ","; 
			           p++;
				}
				 
				}
			
			KechengDao ke=new KechengDao();
			ke.updatebybuff(abc, p);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("已签到:" + abc);
			System.out.println("已签到人数:" + p);
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
