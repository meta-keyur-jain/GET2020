<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateStudent" method="post">
		<fieldset>
			<legend>Student Detail</legend>
			<%
				String sid = request.getParameter("id");
				int id = Integer.parseInt(sid);
			%>
			<input type="text" name="id" value="<%=id%>" hidden> <label>First
				Name:</label><input type="text" name="firstName"
				value="<%=request.getParameter("firstName")%>"><br> <label>Last
				Name :</label><input type="text" name="lastName"
				value="<%=request.getParameter("lastName")%>"><br> <label>Father
				Name:</label><input type="text" name="fatherName"
				value="<%=request.getParameter("fatherName")%>"><br> <label>Email
				Id:</label><input type="email" name="emailId"
				value="<%=request.getParameter("emailId")%>"><br> <label>Class
				:</label><select name="class">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select><br> <label>Age : </label><input type="number" name="age"
				value="<%=request.getParameter("age")%>"><br> <input
				type="submit">
		</fieldset>
	</form>
</body>
</html>