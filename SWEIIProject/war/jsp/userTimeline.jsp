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


<c:forEach items="${it.hashtags }" var = "hashtag">

<a href="hashtagTimeline/"+${hashtag.name}><p><c:out value="${hashtag.name }"></c:out></p></a>


<br><br>
</c:forEach>



  
</body>
</html>