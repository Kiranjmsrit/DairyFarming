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
           background-color:#00BFFF;
      }
      </style>
<body>

 <%
  HttpSession ssession=request.getSession(false); 
  %>
  
  


<form action="../UpdateServlet" method="post">

CID:          <input type="text" name="id" value="<%=ssession.getAttribute("cusid")%>"/><br/><br/>
First Name:   <input type="text" name="firstname" value="<%=ssession.getAttribute("cusfn")%>"/><br/><br/>
Last Name:    <input type="text" name="lastname" value="<%=ssession.getAttribute("cusln")%>"/><br/><br/>
Mobile Number:<input type="text" name="mobnum" value="<%=ssession.getAttribute("cusmob")%>"/><br/><br/>
Aadhar Number:<input type="text" name="aadnum" value="<%=ssession.getAttribute("cusaad")%>"/><br/><br/>
Gender:			<%
			if(ssession.getAttribute("cusgen").equals("male")){%>
			<input type="radio" name="gender" value="<%=ssession.getAttribute("cusgen")%>" checked/> Male <input type="radio" name="gender" value="<%=ssession.getAttribute("cusgen")%>"/>Female<br/><br/>
			<%}
			else if(ssession.getAttribute("cusgen").equals("female")){%>
			<input type="radio" name="gender" value="<%=ssession.getAttribute("cusgen")%>" checked/> Female <input type="radio" name="gender" value="<%=ssession.getAttribute("cusgen")%>"/>Male<br/><br/>
			<% }	
			%>
Card number:  <input type="text" name="cnum" value="<%=ssession.getAttribute("cuscnum")%>"/><br/><br/>
<input type="submit" value="Update"/>


  </form>
  
   
   
   



</body>
</html>