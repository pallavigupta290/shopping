<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><marquee>WELCOME TO REGISTER PAGE</h1></marquee>
<form action="Registercontroller" method="post">
<br>Firstname<input type="text" name="fname"></br>
<br>Lastname<input type="text" name="lname"></br>
<br>Username<input type="text" name="uname"></br>
<br>Password<input type="text" name="pass"></br>
<input type="submit" value="submit" name="save">
</form>
<br>
<a href=Login.jsp">Already register? Login</a>
<%!String status; %>
<%
if (!session.isNew())
{
	Object obj=session.getAttribute("data");
	status=(String)obj;
	session.invalidate();

		%>
		<h1><%=status %></h1>
		<%
	
}
%>
</body>
</html>