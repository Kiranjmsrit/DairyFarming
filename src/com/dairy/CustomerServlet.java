package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    
	    String FirstName=request.getParameter("firstname");
	    String LastName=request.getParameter("lastname");
	    String MobNum=request.getParameter("mobnum");
	    String Aadnum=request.getParameter("aadnum");
	    String Gender=request.getParameter("gender");
	    String CardNum=request.getParameter("cnum");
	    
	    Connection con = null;
	    try{  
	    Class.forName("oracle.jdbc.driver.OracleDriver");  
	      
	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kiran");  
	      
	    PreparedStatement pstmt=con.prepareStatement("insert into customer_details2 values(customer_id_seq.nextval,?,?,?,?,?,?)");  
	      
	    pstmt.setString(1,FirstName); 
	    pstmt.setString(2,LastName);
	    pstmt.setString(3,MobNum);
	    pstmt.setString(4,Aadnum);
	    pstmt.setString(5,Gender);
	    pstmt.setString(6, CardNum);
	    int i=pstmt.executeUpdate();  
	    System.out.println(i+" records inserted"); 

	    if(i>0){
	    	//con.commit();
	    	out.println("Records saved Successfully");
	    }
	    else{
	    	out.println("records are not saved");
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
	    
		
		
	


