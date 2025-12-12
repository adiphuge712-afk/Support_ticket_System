<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Complain </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="admin_navbar.jsp" %>
<table class="table table-board  border-dark table-hover">
<thead class="table table-dark">
<tr>
<th>ID</th>
<th>FulName</th>
<th>Complain name</th>
<th>Complain Discreption</th>
<!-- <th>Date</th> -->
<th>TickitState</th>
<th>StaffName</th>
<th>Customer Contact number</th>
<th>Customer id</th>
<th>FeedBack</th>

</tr>
</thead>
<c:forEach var="s" items="${list}" varStatus="st">
<tr>
<td>${st.index + 1}</td>
<td>${s.username }</td>
<td>${s.complaintitle }</td>
<td>${s.complaindiscreption }</td>
<td>${s.ticket.status}</td> 
<td>${s.ticket.assign_ticket_staff}</td>
<td>${s.c_id.contactno }</td>
<td>${s.c_id.id }</td>
<td>${s.remark }<br><a href="/create_ticket/${s.id }">create ticket</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>