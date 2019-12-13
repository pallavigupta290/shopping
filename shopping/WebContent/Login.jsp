<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Logincontroller">
<br>Username<input type="text" name="uname"></br>
<br>Password<input type="text" name="pass"></br>
<input type="submit" value="submit" name="save">
</form>
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