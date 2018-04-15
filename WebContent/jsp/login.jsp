<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dairy farming</title>
</head>

<style>
body {
     background-image:url("../../images/cow.jpg");
     }
form {
    width: 300px;
    margin: 0 auto;
   
}
</style>

<body>
<form action = "../LoginServlet" method="post"> 
Name:<input type="text" name="username"/><br/><br/>  
Password:<input type="password" align="middle"  name="userpass"/><br/><br/>  
<input type="submit" value="login"/>  
</form>

</body>
</html>


