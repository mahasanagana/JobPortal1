<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Remove Job</h1>
<c:if test ="${error !=null}">
<h1 style="color:red;">There Was An Error</h1>
</br>
</br>
</c:if>
<form action="/JobPortal/RemoveJob" method=post">
      Job Id:<input type="text" name="password">
      Job Password:<input type="text" name="password">
      <input type="submit" value="submit"/>
</form>
</body>
</html>