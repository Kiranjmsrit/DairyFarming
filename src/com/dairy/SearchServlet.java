package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boolean isRecordFound=false;
		response.setContentType("text/html");  
	  //  PrintWriter out = response.getWriter();
	    System.out.println("inside dopodt");
	    String cnum=request.getParameter("search");
	    System.out.println("cnum " + cnum);
	    Connection con = null;
		try{  
		 
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		 con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","kiran");  
		 
		 Statement stmt=con.createStatement();
		 
		  String query="select * from customer_details2 where customer_card_number='"+ cnum +"'"; 
		  System.out.println("query : " + query);
		  
		ResultSet rs=stmt.executeQuery(query);  
		
		while(rs.next()) { 
		Integer cid=rs.getInt(1);  
		System.out.println("cid " + cid);
		String cfirstname=rs.getString(2);
		String clastname=rs.getString(3);
		String cmobnum=rs.getString(4);
		String caadnum=rs.getString(5);
		String cgender=rs.getString(6);
		String ccardnum=rs.getString(7);
		if(cnum.equals(ccardnum)){
		HttpSession session=request.getSession(true);  
         session.setAttribute("cusid",cid); 
         session.setAttribute("cusfn",cfirstname);
         session.setAttribute("cusln",clastname); 
         session.setAttribute("cusmob",cmobnum); 
         session.setAttribute("cusaad",caadnum); 
         session.setAttribute("cusgen",cgender); 
         session.setAttribute("cuscnum",ccardnum); 
        // isRecordFound=true;
        
         //request.getServletContext().getRequestDispatcher("../GetResult").include(request, response);
         
         
         
       response.sendRedirect(request.getContextPath() +"/jsp/search.jsp");
        
	    
		
	}
		}
		  
		
		}
		catch(Exception e){ System.out.println(e);}  
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