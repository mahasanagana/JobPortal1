<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      
   <c:foreach items="${jobs}" var="job" >
      <h3 style="display:inline;font-style:oblique; font_size:19px:">${job.jobName}</h3></br>
        ${job.messageBody} </br>
        <i>${job.posterName}</i>
        <small>${job.contactName}</small>
        </br>
        </br>
    </c:foreach> 
</body>
</html>