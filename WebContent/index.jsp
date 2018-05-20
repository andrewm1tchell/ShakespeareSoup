<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shakespeare Soup</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<style type="text/css" src="${pageContext.request.contextPath}/css/index.css"></style>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/imgs/shakespeare-favicon/favicon.ico">
</head>
<body>
	<h1>Shakespeare Soup</h1>
	<h2>Generate sentences and phrases from The Bard's own ink</h2>
	<form action="Soupify" method="post">	
		<input type="text" id="root" name="root" placeholder="Enter a root word"  onkeyup="validateRoot()" size="20">
		<input type="submit" id="submit" value="Speak""/>
		<text id="error"></text></br>
		<input type="radio" name="text" value="merchantofvenice" checked> The Merchant of Venice
		<input type="radio" name="text" value="merrywives"> The Merry Wives of Windsor
		<input type="radio" name="text" value="macbeth"> Macbeth  
	</form>
</body>
</html>