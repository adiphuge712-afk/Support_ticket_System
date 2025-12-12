<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complain form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="cnavbar.jsp" %>

<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2> Customer Complain Form</h2>
<form action="/complainform" method="post">

<input placeholder="Enter username" name="username" type="hidden" class="form-control mb-2" value="${cuser.fullname}">
<input placeholder="Enter Complain title" name="complaintitle" type="text" class="form-control mb-2">
<!-- <input placeholder="Enter " name="email" type="email" class="form-control mb-2"> -->
<!-- <input placeholder="Enter pass" name="password" type="password" class="form-control mb-2"> -->
<textarea placeholder="Enter the Discreption" class="form-control mb-2" name="complaindiscreption"></textarea>
<button type="submit" class="btn btn-success">Submit</button>
</form>
</div>
<div class="col-sm-4"></div>
</div>
</body>
</html>