<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>Rate</title>

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
	<form method="post" action=Controller?action=confirmRate>
		<p>Geef een cijfer tussen 0 (ik beheers de competentie helemaal niet) en 6 (ik kan dit al erg goed).</p>
    	<p>Ik kan goed samenwerken.</p>
    	<p> Je huidige waarde is <c:out value='${student.samenwerking}'/>, en diegene daarvoor was <c:out value='${student.oudeSamenwerking}'/>.</p>
        <p><label for="samenwerking">Samenwerking</label><input type="range" min="0" max="6" step="1" value="<c:out value='${student.getSamenwerking()}'/>"
        id="samenwerking" name="samenwerking" required value="<c:out value='${param.samenwerking}'/>"/> </p>
        <p>Ik ben creatief.</p>
        <p> Je huidige waarde is <c:out value='${student.creativiteit}'/>, en diegene daarvoor was <c:out value='${student.oudeCreativiteit}'/>.</p>
        <p><label for="creativiteit">Creativiteit</label><input type="range" min="0" max="6" step="1" value="<c:out value='${student.getCreativiteit()}'/>"
        id="creativiteit" name="creativiteit" required value="<c:out value='${param.creativiteit}'/>"/> </p>
        <p><input type="hidden" id="name" name="name" required value="<c:out value='${student.name}'/>"></p>
        <p><input type="submit" id="rate" value="Rate"></p>
    </form>
</div>
</main>

</body>
</html>