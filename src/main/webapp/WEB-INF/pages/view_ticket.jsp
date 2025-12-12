<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Tickets</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
<%@include file="admin_navbar.jsp" %>
</head>
<body>

<table class="table table-board  border-dark table-hover">
<thead class="table table-dark">
<tr>
<th>ID</th>
<th>Ticket Name</th>
<th>Title Name</th>
<th>Ticket Status</th>
<th>Created Date</th> 
<th>Remark</th>
</tr>
</thead>
<c:forEach var="s" items="${list}" varStatus="st">
<tr>
<td>${s.ticketId }</td>
<td>${s.ticketname}</td>
<td>${s.title}</td>
<td>${s.status}</td>
<td>${s.createdDate}</td>

<td>${s.remark}</td>

</tr>
</c:forEach>
</table>
</body>
</html>