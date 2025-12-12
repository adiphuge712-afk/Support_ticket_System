<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2>update Ticket Status and Remark</h2>
<form action="/updatestatusadmin" method="post">
<input placeholder="Enter name" name="id" type="hidden" class="form-control mb-2" value="${ticdata.ticketId  }">
<input placeholder="Enter tickit open closed resolved In-progread" name="status" type="text" class="form-control mb-2" value="${ticdata.status }">
<input placeholder="Enter remark optional" name="remark" type="text" class="form-control mb-2" value="${ticdata.remark }">
<!-- <textarea placeholder="Enter the Address" class="form-control mb-2" name="address"></textarea> -->
<button type="submit" class="btn btn-success">Update</button>
<br><a href="/forgotpass" class="mx-2 " >Forgot password</a>
</form>
</div>
<div class="col-sm-4"></div>
</div>

</body>
</html>