<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
      body{
           background-color:#8FBC8F;
      }
      </style>

<body>
<form action="../SearchServlet" method="post">
<input type="text" name="search"/> <input type="submit" value="Search"/>
</form>



      
   <%

   HttpSession ssession=request.getSession(false); 

 if(ssession!=null){
	  if(ssession.getAttribute("cusid") != null){
   Integer id=(Integer)ssession.getAttribute("cusid"); 
   
   String fn=(String)ssession.getAttribute("cusfn");
   
   String ln=(String)ssession.getAttribute("cusln");
   
  String mn=(String)ssession.getAttribute("cusmob");
   
   String an=(String)ssession.getAttribute("cusaad"); 
   
   String gen=(String)ssession.getAttribute("cusgen");
   
   String cn=(String)ssession.getAttribute("cuscnum");
   
   
 
   //out.println(id);
   //out.println(fn);
   //out.println(ln);
  // out.println(mn);
  // out.println(an);
   //out.println(gen);
   //out.println(cn);
}
 }
   



 
   
   
   %>

    
   <% if(ssession!=null){%>
   <%
   if(ssession.getAttribute("cusid") != null){%>
      <table border=2>
   <tr>
   
   <th>customer_id</th>
   <th>cusomer_first_name</th>
   <th>customer_last_name</th>
   <th>customer_mobnum</th>
   <th>customer_aadnum</th>
   <th>customer_gen</th>
   <th>customer_cnum</th>
   <th>checkbox</th>
   </tr>
   
   <tr>
  
	   <td><%=ssession.getAttribute("cusid") %></td>
	   <td><%=ssession.getAttribute("cusfn") %></td>
	   <td><%=ssession.getAttribute("cusln") %></td>
	   <td><%=ssession.getAttribute("cusmob") %></td>
	   <td><%=ssession.getAttribute("cusaad") %></td>
	   <td><%=ssession.getAttribute("cusgen") %></td>
	   <td><%=ssession.getAttribute("cuscnum") %></td>
	   <td><input type="checkbox" name="cbox" value="cid"/></td>
	 </tr>
  
 
   </table>  
	    <form action="../ResultServlet" method="post">
	     <input type="hidden" name="cid" value="<%=ssession.getAttribute("cusid") %>"/>
    <input type="hidden" name="cfn" value="<%=ssession.getAttribute("cusfn") %>"/>
    <input type="hidden" name="cln" value="<%=ssession.getAttribute("cusln") %>"/>
    <input type="hidden" name="cmn" value="<%=ssession.getAttribute("cusmob") %>"/>
    <input type="hidden" name="can" value="<%=ssession.getAttribute("cusaad") %>"/>
    <input type="hidden" name="cgen" value="<%=ssession.getAttribute("cusgen") %>"/>
    <input type="hidden" name="ccn" value="<%=ssession.getAttribute("cuscnum") %>"/>
   <input type="submit" value="UpdateCustomers"/>
   </form>
	  <%  }
  
   %>
   
      
  
   
   <%
   
   }
 
   
   
   %>
      

  
   
     

</body>
</html>