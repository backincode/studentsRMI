<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sezione Piani di Studi</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@ include file="header.html" %>
	<div id="container">
	<h1>Sezione Piani di Studio</h1>
	<form method="post" action="indexPianiDiStudio.do">
		<p><input class="blueButton" type="submit" name="scelta" value="Mostra Piano di Studio" /></p>
		<p><input class="blueButton" type="submit" name="scelta" value="Compila Piano di Studio" /></p>
	</form>
	</div>
</body>
</html>