<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Registration</h1>
	<form action="registration.hr">
	<table>
		<tr>
			<th>PS Number</th>
			<td><input name="empId" type="text">
		</tr>
		<tr>
			<th>First Name</th>
			<td><input name="firstName" type="text">
		</tr>
		<tr>
			<th>Last Name</th>
			<td><input name="lastName" type="text">
		</tr>
		<tr>
			<th>Email</th>
			<td><input name="email" type="email">
		</tr>
		<tr>
			<th>Hire Date</th>
			<td><input name="hireDate" type="date">
		</tr>
		<tr>
			<th>Job Id</th>
			<td><input name="jobId" type="text">
		</tr>
		<tr><td colspan="2"><input type="submit"></td></tr>
	</table>
	</form>
</body>
</html>