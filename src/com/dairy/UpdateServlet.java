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

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int cid = 0;
		
		
		PrintWriter out = response.getWriter();
		String sid=request.getParameter("id");
		if(sid!=null){
		 cid=Integer.parseInt(sid);
		}
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String mnum=request.getParameter("mobnum");
		String anum=request.getParameter("aadnum");
		String gen=request.getParameter("gender");
		String cn=request.getParameter("cnum");
		
		
		Connection con = null;
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kiran");  
		  
			Statement stmt=con.createStatement();  

			  String query = "select * from customer_details2 where customer_id ='" + cid + "'";
			  System.out.println(query);
			ResultSet rs=stmt.executeQuery(query); 
			//int id=0;
			//String cfn=" ";
			//String cln=" ";
			//String cmn=" ";
			//String can=" ";
			//String cgen=" ";
			//String ccn=" ";
			
			while(rs.next()) { 
			Integer id=rs.getInt(1);    
			String cfn=rs.getString(2);
			String cln=rs.getString(3);
			String cmn=rs.getString(4);
			String can=rs.getString(5);
			String cgen=rs.getString(6);
			String ccn=rs.getString(7);
			}
			
			
			  
		String can=" ";
		String cfn=" ";
		String cln=" ";
		String cmn=" ";
		String cgen=" ";
		if(!(can).equalsIgnoreCase(anum)){  
		PreparedStatement pstmt=con.prepareStatement("update customer_details2 set customer_aadhar_number=? where customer_id=?");  
		pstmt.setString(1,anum);  
		pstmt.setInt(2,cid);

		int i=pstmt.executeUpdate();  
		System.out.println(i+" records updated"); 
		}
		
		if(!(cfn).equalsIgnoreCase(fname)){
			PreparedStatement pstmt=con.prepareStatement("update customer_details2 set customer_first_name=? where customer_id=?");  
			pstmt.setString(1,fname);  
			pstmt.setInt(2,cid);

			int i=pstmt.executeUpdate();  
			System.out.println(i+" records updated");
			
		}
		if(!(cln).equalsIgnoreCase(lname)){
			PreparedStatement pstmt=con.prepareStatement("update customer_details2 set customer_last_name=? where customer_id=?");  
			pstmt.setString(1,lname);  
			pstmt.setInt(2,cid);

			int i=pstmt.executeUpdate();  
			System.out.println(i+" records updated");
			
			
		}
		 if(!(cmn).equalsIgnoreCase(mnum)){
			PreparedStatement pstmt=con.prepareStatement("update customer_details2 set customer_phone_number=? where customer_id=?");  
			pstmt.setString(1,mnum);  
			pstmt.setInt(2,cid);

			int i=pstmt.executeUpdate();  
			System.out.println(i+" records updated");
			
			
		}
		 if(!(cgen).equalsIgnoreCase(gen)){
			PreparedStatement pstmt=con.prepareStatement("update customer_details2 set customer_gender=? where customer_id=?");  
			pstmt.setString(1,gen);  
			pstmt.setInt(2,cid);

			int i=pstmt.executeUpdate();  
			System.out.println(i+" records updated");
			
			
		}
		//if(i>0){
			//con.commit();
			//out.println("Records updated successfully");
		//}
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
