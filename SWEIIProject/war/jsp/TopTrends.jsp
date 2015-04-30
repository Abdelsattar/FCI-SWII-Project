
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<font color="#00FFFF" size ="1">
<title>facebok </title>
</head>
<body bgcolor="#AA000">
</head>

<h2>top trends</h2>
<br>
<c:forEach items="${it.hashtags }" var = "hashtag">

<a href="social/viewTimeline/"+hashtag.name><p><c:out value="${hashtag.name }"></c:out></p></a>


<br><br>
</c:forEach>

</form>
</body>
</html>