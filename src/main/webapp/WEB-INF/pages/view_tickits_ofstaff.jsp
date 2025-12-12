<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="staff_navbar.jsp" %>

<table class="table table-board  border-dark table-hover">
<thead class="table table-dark">
<tr>
<th>Staff ID</th>
<th>Staff Name</th>
<th>Ticket Name</th>
<th>Title Name</th>
<th>Ticket Status</th>
<!-- <th>Created Date</th>  -->
<th>Remark</th>
<th>Change Status</th>
</tr>
</thead>

<%-- <tr>
<td>${st.index +1}</td>
<td>${suser.fullname}</td>
<td>${s.ticketname}</td>
<td>${s.title}</td>
<td>${s.status}</td>
<!-- <td>${s.createdDate}</td>-->

<td>${s.remark}</td>
                <td>${row[3]}</td>
                <td>${row[4]}</td>
                <td>${row[0]}</td>
                <td>${row[1]}</td>

</tr> --%>
<tr>
        <td>${stafftickets[5]}</td>
        <td>${stafftickets[4]}</td>
        <td>${stafftickets[2]}</td>
        <td>${stafftickets[3]}</td>
        <td>${stafftickets[0]}</td>
        <td>${stafftickets[7]}</td>
         <td><a href="/addremarkandstatus/${stafftickets[6]}" class="btn btn-primary">add remark change status</a></td>
    </tr>

</table>
</body>



</html>