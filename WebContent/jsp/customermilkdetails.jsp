<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="../CustomerMilkServlet" method="post">
CardNumber:<input type="text" name="cnum" /><br/><br/>
Litres    :<input type="text" name="litr"/><br/><br/>
Date      :<input type="date"  name="sdate"/><br/><br/>
<input type="submit" value="Insert"/>
 
</form>

</body>
</html>