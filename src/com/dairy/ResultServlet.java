package com.dairy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 int id = 0;
		String sid=request.getParameter("cid");
		if(sid!=null){
		 id=Integer.parseInt(sid);
		}
		String fn=request.getParameter("cfn");
		System.out.println(fn);
		String ln=request.getParameter("cln");
		String mn=request.getParameter("cmn");
		String an=request.getParameter("can");
		String gn=request.getParameter("cgen");
		String cn=request.getParameter("ccn");
		
		
		
		HttpSession session=request.getSession(true);  
		
        session.setAttribute("cusid",id); 
        session.setAttribute("cusfn",fn);
        session.setAttribute("cusln",ln); 
        session.setAttribute("cusmob",mn); 
        session.setAttribute("cusaad",an); 
        session.setAttribute("cusgen",gn); 
        session.setAttribute("cuscnum",cn); 
        
        response.sendRedirect(request.getContextPath() +"/jsp/update.jsp");
		
		
		
		
	}

}
