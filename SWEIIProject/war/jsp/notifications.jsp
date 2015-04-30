<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Users</title>
</head>
<body>


<c:forEach items="${it.Notifications }" var = "Notification">

<p>  <c:out value="${Notification }"></c:out></p>


<br><br>
</c:forEach>


  
</body>
</html>