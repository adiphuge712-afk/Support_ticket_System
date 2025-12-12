<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="admin_navbar.jsp" %>


<table class="table table-board  border-dark table-hover">
<thead class="table table-dark">
<tr>
<th>ID</th>

<th>Ticket Id</th>

<th>Staff Id</th>
<th>Administrator Id</th>
<th>Updated Date</th>
<!-- <th>Ticket_Status</th>
<th>Assin_Ticket</th>
<th>Remark</th> -->
</tr>
</thead>
<c:forEach var="s" items="${history}" varStatus="st">
<tr>
<td>${st.index+1 }</td>
<td>${s.ticket_id}</td>
<td>${s.st_id}</td>
<td>${s.ad_id}</td>
<td>${s.updatedDate}</td>

<td>${s.remark}</td>

</tr>
</c:forEach>

</table>

</body>
</html>