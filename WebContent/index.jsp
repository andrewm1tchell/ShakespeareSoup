<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shakespeare Soup</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script src="http://code.responsivevoice.org/responsivevoice.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/imgs/shakespeare-favicon/favicon.ico">
</head>
<body>
	<h1>Shakespeare Soup</h1>
	<h2>Generate sentences and phrases as if you were The Bard himself</h2>
	<input type="text" id="root" name="root" placeholder="Enter a root word"  onkeyup="validateRoot()" size="20">
	<input type="button" id="submit" value="Speak"/>
	<text id="error"></text></br>
	<input type="radio" name="text" value="merchantofvenice" checked> The Merchant of Venice
	<input type="radio" name="text" value="merrywives"> The Merry Wives of Windsor
	<input type="radio" name="text" value="macbeth"> Macbeth  
	<div id="response"></div>
	
	<br><br><img src="${pageContext.request.contextPath}/imgs/s1.png" id="shakespeare">
</body>
</html>