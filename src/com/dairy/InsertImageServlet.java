package com.dairy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

public class InsertImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("servlet1");
		PrintWriter out = response.getWriter(); 
		
		
		
		InputStream inputStream = null; 
		//InputStream isFoto = request.getPart("pic").getInputStream();
		String filePath = request.getParameter("pic");
		File photo = new File(filePath);
		System.out.println(filePath);
	 //   Part photo = request.getPart("pic");
	    System.out.println(photo);
        if (photo != null) {
            
            //System.out.println(filePart.getName());
            //System.out.println(filePart.getSize());
           // System.out.println(filePart.getContentType());
             
             
           inputStream = new FileInputStream(photo);
            
       }
        System.out.println("servlet3");

		Connection con=null;
		try
		{
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		System.out.println("servlet4");
	  con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","kiran");  
	  System.out.println("servlet5");
		              
		PreparedStatement ps=con.prepareStatement("insert into imgtable1 (photo) values(?)"); 
		System.out.println("servlet6");
		 
		  
		
//		  if (inputStream != null) {
//			  System.out.println("servlet7");
//              ps.setBlob(1, inputStream);
//          }
//		if(photo.getInputStream()!=null ){
		ps.setBinaryStream(1, (InputStream) inputStream, (int) photo.length());
//		}
		

		int i=ps.executeUpdate();  
		 System.out.println("servlet8");
		System.out.println(i+" records affected");

	    if(i>0){
	    	//con.commit();
	    	out.println("Image saved Successfully");
	    }
	    else{
	    	out.println("Image not saved");
	    }
	    }
	    catch(SQLException e){ System.out.println(e);} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

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
