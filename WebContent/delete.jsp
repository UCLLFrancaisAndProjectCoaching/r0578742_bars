<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>Delete</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<main>
<div class="all">
<jsp:include page="header.jsp">
    <jsp:param value="Users" name="title" />
</jsp:include>
	<div class="alert-danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li><c:out value='${error }'/></li>
				</c:forEach>
		</ul>
	</div>
	<td><c:out value='${student.getName()}'/></td>
	<form method="post" action=Controller?action=confirmDelete>
		<p>Wens je deze student te verwijderen?</p>
        <p><input type="hidden" id="name" name="name" required value="<c:out value='${student.name}'/>"></p>
        <p><input type="submit" id="delete" value="Delete"></p>
    </form>
</div>
</main>

</body>
</html>