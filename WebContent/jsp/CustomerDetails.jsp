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
           background-color:#00FFFF;
      }
      </style>
<body>
<form action="../CustomerServlet" method="post">
First Name:   <input type="text" name="firstname"/><br/><br/>
Last Name:    <input type="text" name="lastname"/><br/><br/>
Mobile Number:<input type="text" name="mobnum"/><br/><br/>
Aadhar Number:<input type="text" name="aadnum"/><br/><br/>
Gender:       <input type="radio" name="gender" value="male"/>Male <input type="radio" name="gender" value="female"/>Female<br/><br/>
Card number:  <input type="text" name="cnum"/><br/><br/>
<input type="submit" value="Add"/>
</form>

</body>
</html>