<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Insert Job Information</h1>
    <br/>
    <br/>
MessageBody:
<br/><textarea  style="font-size:14pt;" rows="20" cols="70" form="postJobform"
     name="messageBody" ></textarea>
<form action="/JobPortal/postJob" method="POST" id="postJobform"><br/>
JobName:<input type="text" name="jobname"/><br/>
Poster Name:<input type="text" name="postername"/><br/>
Password:<input type="text" name="password"/></br>
ContactNumber:<input type="text" name="contactnumber"/></br>
<input type="submit" type="submit"/>

</form>

</body>
</html>