<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Assignment.css">
<script>
function editFun(){
	
	
	document.getElementById("name").removeAttribute('readonly');
	document.getElementById("name").style.border="2px solid green";
	
	document.getElementById("gender").removeAttribute('readonly');
	document.getElementById("gender").style.border="2px solid green";
	
	document.getElementById("emailId").removeAttribute('readonly');
	document.getElementById("emailId").style.border="2px solid green";
	
	document.getElementById("contact").removeAttribute('readonly');
	document.getElementById("contact").style.border="2px solid green";
	
	document.getElementById("org").removeAttribute('readonly');
	document.getElementById("org").style.border="2px solid green";
	
	document.getElementById("vechiletype").removeAttribute('readonly');
	document.getElementById("vechiletype").style.border="2px solid green";
	
	document.getElementById("vechilename").removeAttribute('readonly');
	document.getElementById("vechilename").style.border="2px solid green";
	
	document.getElementById("vechileno").removeAttribute('readonly');
	document.getElementById("vechileno").style.border="2px solid green";
	
	document.getElementById("vechileidentity").removeAttribute('readonly');
	document.getElementById("vechileidentity").style.border="2px solid green";
	
}
</script>
<style>
input[type=text] {
	margin: 7px;
	padding: 8px;
}

input[type=submit] {
	border: none;
	margin: 0;
	outline: 0;
	padding: 0;
	color: orange;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 8rem;
	height: 40px;
	font-size: 14px;
	border-radius: 2rem;
}
</style>


</head>
<body>
	<form id='basicInformation' action="userdetail" method="post">
		<fieldset>
			<legend>Personal Details</legend>
			<span id="msg"></span><br> <label>UserId</label><input
				type="text" value="<%=session.getAttribute("id")%>" id="userid"
				readonly> <br /> <label>Full Name</label><input type="text"
				name="fullName" value="<%=session.getAttribute("name")%>" id="name"
				readonly><br /> <label>Gender </label><input type="text"
				name="gender" id="gender"
				value="<%=session.getAttribute("gender")%>" readonly><br />
			<label>E-Mail</label><input type="email" name="email" id="emailId"
				value="<%=session.getAttribute("email")%>" readonly><br /> <label>Contact
				Number</label><input type="text" name="contact" id="contact"
				value="<%=session.getAttribute("contactno")%>" readonly><br />
			<label>Organisation</label><input type="text" name="org" id="org"
				value="<%=session.getAttribute("organisation")%>" readonly><br />
			<label>Vehicle Type</label><input type="text" name="vechiletype"
				id="vechiletype" value="<%=session.getAttribute("vechileType")%>"
				readonly><br /> <label>Vehicle Name.</label><input
				type="text" name="vechilename" id="vechilename"
				value="<%=session.getAttribute("vechileName")%>" readonly><br />
			<label>Vehicle No.</label><input type="text" name="vechileno"
				id="vechileno" value="<%=session.getAttribute("vechileNo")%>"
				readonly><br /> <label>Vehicle Identity</label><input
				type="text" name="vechileidentity" id="vechileidentity"
				value="<%=session.getAttribute("vechileIdentity")%>" readonly><br />
			<input type="button" id="myButton" value="Edit" onclick="editFun()">
			<input type="submit" value="update">
		</fieldset>
	</form>
	</div>
</body>
</html>