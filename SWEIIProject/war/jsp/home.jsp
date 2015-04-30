-+<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//   String name = request.getParameter( "uname" );
  // session.setAttribute( "theName", name );
%>


<html>
<head>
<title> home page</title>

<body>
<form>
<body bgcolor="#F0F8FF">
<br>

<img src="face.png" width="70" height="70"/> 
<form action="/social/SearchF" method="get">
<td><input type="txt" name ="search" value=''size="50"/></td>

<tr><td><input type="submit" value="search" color="#F0F8FF"/></td></tr>
</form>
&nbsp;
&nbsp;
&nbsp;
<form action="/social/viewf" method="get">
<tr><td><input type="submit" value="add friend" color="#F0F8FF"/></td></tr>
<img src="addf.jpg" width="40" height="40"/> 
</form>
&nbsp;
&nbsp;
&nbsp;
<form action="/social/posts" method="get">
<tr><td><input type="submit" value="profile" color="#F0F8FF"/></td></tr>
<img src="me.png" width="40" height="40"/> 
</form>
&nbsp;
&nbsp;
&nbsp;
<form action="MSg" method="get">
<tr><td><input type="submit" value="message" color="#F0F8FF"/></td></tr>
<img src="mess.jpg" width="40" height="40"/> 
</form>
&nbsp;
&nbsp;
&nbsp;
<form action="show" method="post">
<tr><td><input type="submit" value="notification" color="#F0F8FF"/></td></tr>
<img src="notify.jpg" width="40" height="40"/> 
</form>
&nbsp;
&nbsp;
&nbsp;
<form action="/social/signout" method="get">
<tr><td><input type="submit" value="sign out" color="#F0F8FF"/></td></tr>
<img src="sign out.jpg" width="40" height="40"/> 
</form>
<br>
<br>
<br>

<img src="page.png" width="60" height="40"/> 
<form action="social/CreatePage" method="get" >
<input type="submit" value="create page" color="#F0F8FF"/>
</form> 
<br>
<form action="social/group" method="get">
<img src="group.jpg" width="60" height="50"/> 
<tr><td><input type="submit" value="create group" color="#F0F8FF"/></td></tr>
<center></center> <iframe scrolling="auto" src=" HomePosts.jsp " width="300" height="300"> 
</iframe></center></td></tr>

</form>
<br>
</body>
</head>
</html>

</body>
</html>