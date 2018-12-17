<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="nl">
<head>
<meta charset="ISO-8859-1">
<title>Overzicht studenten</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
	<div class="all">
		
		
		<main>
		
		<jsp:include page="header.jsp">
    		<jsp:param value="Users" name="title" />
		</jsp:include>
		<section>
			<h2>Overzicht studentinformatie</h2>
			<p>Testing</p>
			<table id="overview">
					<tr>
						<th>Naam</th>
						<th class="getal">Samenwerking</th>
						<th class="getal">Creativiteit</th>
					</tr>
					<c:forEach  var="student" items="${students}"> 
					<tr>
						<td><c:out value='${student.getName() }'/></td>
						<td><c:out value='${student.getSamenwerking() }'/></td>
						<td><c:out value='${student.getCreativiteit() }'/></td>
						<td><a href="Controller?action=getRate&name=<c:out value='${student.getName()}'/>">Rate</a></td>
						<td><a href="Controller?action=getDelete&name=<c:out value='${student.getName()}'/>">Delete</a></td>
					</tr>
					</c:forEach>
			</table>
			</article>
		</main>
	</div>
	</div>
</body>
</html>