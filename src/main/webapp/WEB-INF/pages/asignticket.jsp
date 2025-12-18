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
<%@include file="admin_navbar.jsp" %>
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2> Assign Ticket </h2>
<form action="/assign_ticket_admin" method="post">
<input placeholder="Enter name" name="st_id" type="hidden" value="${sid }" class="form-control mb-2">
<input placeholder="Enter name" name="fullname" type="text" value="${sname }" class="form-control mb-2">
<!--  <input placeholder="Enter id" name="ticket_id" type="text" class="form-control mb-2"> -->

            <select name="ticket_id" class="form-control mb-2">
            <option selected>Select the ticket id</option>
                <c:forEach var="t" items="${tic}">
                    <option value="${t.ticketId}">${t.ticketId} ${t.ticketname}</option>
                </c:forEach>
            </select>
<button type="submit" class="btn btn-success">Submit</button>
</form>
</div>
<div class="col-sm-4"></div>
</div>
</body>
</html>