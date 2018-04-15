package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomerMilkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   @Override  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    int litre = 0;
	    int cprice = 0;
	   
	    String cnumber=request.getParameter("cnum");
	    String clitre=request.getParameter("litr");
	    if(clitre!=null){
			 litre = Integer.parseInt(clitre);
			}
	    String date=request.getParameter("sdate");

	    Connection con = null;
	    try{  
	    Class.forName("oracle.jdbc.driver.OracleDriver");  
	      
	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kiran"); 
	     Statement stmt=con.createStatement();  

	     String query="select * from milk_price where customer_date='" + date + "'";
	     System.out.println(query);
	     ResultSet rs=stmt.executeQuery(query); 

			while(rs.next()) { 
			Integer cprice1=rs.getInt(2); 
			 cprice=cprice1*litre;
			}
	     
	    
	     PreparedStatement pstmt=con.prepareStatement("insert into customer_milk values(?,?,?,?)"); 
	     
	     pstmt.setString(1,cnumber); 
	     pstmt.setInt(2, litre);
	     pstmt.setInt(3,cprice );
	     pstmt.setString(4, date);
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
