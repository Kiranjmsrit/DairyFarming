package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetResult extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 HttpSession ssession=request.getSession(false);  
	        Integer id=(Integer)ssession.getAttribute("cusid"); 
	        
	        String fn=(String)ssession.getAttribute("cusfn");
	        
	        String ln=(String)ssession.getAttribute("cusln");
	        
	        String mn=(String)ssession.getAttribute("cusmob");
	        
	        String an=(String)ssession.getAttribute("cusaad"); 
	       
	        String gen=(String)ssession.getAttribute("cusgen");
	        
	        String cn=(String)ssession.getAttribute("ccardnum");
	         
	        PrintWriter pw=null;
	        pw=response.getWriter();
	        
	        pw.println(id);
	        pw.println(fn);
	        pw.println(ln);
	        pw.println(mn);
	        pw.println(an);
	        pw.println(gen);
	        pw.println(cn);
	        
		
		
		
	}

}
