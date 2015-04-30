
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<font color="#00FFFF" size ="3"><b> facebook </b><br></font><br>
<title> face book </title>
</head>
<body bgcolor="10000">
 <center><img src="timeline.jpg" width = "900" height ="330"/></center>
<br>
<br>
<form action="/social/userpost" method="post">
<td> <tr> <iframe scrolling="auto" src=" TopTrends.jsp " width="70" height="70"> 
</iframe></td></tr>
<br>
<font color="#00FFFF" size="5" width ="200 " height= "250">post here </font>
<input type="txt" name="content"/>

<select name="feeling">
<option value ="feeling"> feeling </option>
<option value ="happy"> happy </option>
<option value ="sad"> sad </option>
<option value ="woring"> woring </option>
</select>


<select name="Privacy">
<option value ="Privacy"> Privacy </option>
<option value ="public"> public </option>
<option value ="private"> private </option>
<option value ="friends"> friends </option>
</select>

<br><td><input type="txt" name ="ownerId" value=''size="50"/></td>

<input type="submit" value=" post ">

<iframe scrolling="auto" src=" TimeLinePosts.jsp " width="200" height="200"> 
</iframe></td></tr>


</form>
</body>
</html>