<!DOCTYPE html>
<%@page import="my.example.model.Person"%>
<%@page import="my.example.service.impl.OperatorService"%>
<html lang="th">
<head>
<meta charset="UTF-8">
<title>HTML Form</title>
</head>
<body>
	<%
	OperatorService n = new OperatorService();
			Person p = new Person();
			p.setFirstName(request.getParameter("fname"));
			p.setLastName(request.getParameter("lname"));
			
			String fullname =n.display(p);
	%>
	Your name is <%= fullname %>
<br/>	<a href="form-03.html"> Back </a>
</body>
</html>
