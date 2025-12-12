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
<%@include file="navbar.jsp" %>

<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2> Administrator Login Form</h2>
<form action="/admin_login" method="post">
<!-- <input placeholder="Enter name" name="fullname" type="text" class="form-control mb-2"> -->
<input placeholder="Enter email" name="email" type="email" class="form-control mb-2">
<input placeholder="Enter password" name="password" type="password" class="form-control mb-2">
<!-- <textarea placeholder="Enter the Address" class="form-control mb-2" name="address"></textarea> -->
<button type="submit" class="btn btn-success">Submit</button>
<br><a href="/forgotpass" class="mx-2 " >Forgot password</a>
</form>
</div>
<div class="col-sm-4"></div>
</div>
</body>
</html>