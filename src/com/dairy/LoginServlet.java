package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
		
		

		
		boolean isRecordFound = false;
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	   String n=request.getParameter("username");  
	   String p=request.getParameter("userpass");  
	   
	    Connection con = null;
		try{  
		 
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		 con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","kiran");  
		  
		  
		Statement stmt=con.createStatement();  

		  String query = "select * from customer_auth where 	user_name = '" + n + "' and user_password = '" + p +"'";
		  System.out.println(query);
		ResultSet rs=stmt.executeQuery(query);  
		
		while(rs.next()) { 
		Integer Cid=rs.getInt(1);    
		String Cun=rs.getString(2);
		String Cup=rs.getString(3);  
		  
//		  if(n != null && !n.equalsIgnoreCase("") && p != null && !p.equalsIgnoreCase("")){	
	
		if(Cun.equalsIgnoreCase(n) && Cup.equalsIgnoreCase(p) ) {
		out.print(Cun +" "+Cup);
		isRecordFound = true;
   response.sendRedirect(request.getContextPath() +"/jsp/admin.jsp");
			
		}   
		
		 }

		if(!isRecordFound) {
			 out.print("Sorry username or password error");   
		        response.sendRedirect(request.getContextPath() +"/jsp/inValidLogin.jsp");
		}
		
//		else{
//			out.print("user name or passwprrd not empty");   
//		 }
////		 
//		 }		  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		finally{
			if(con !=  null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	    }  
	
}

