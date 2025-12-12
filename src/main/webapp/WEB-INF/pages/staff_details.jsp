<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="admin_navbar.jsp" %>

<table class="table table-board  border-dark table-hover">
<thead class="table table-dark">
<tr>
<th>ID</th>
<th>Staff Name</th>
<th>Email</th>
<!-- <th>Date</th> -->
<th>Password</th>
<th>Phone_Number</th>
<th>Ticket_Status</th>
<th>Assin_Ticket</th>
<th>Assin_Ticket_id</th>
<th>Ticket Remark</th>
<th>Remark</th>
<th>Assign Work</th>
</tr>
</thead>
<c:forEach var="s" items="${list}" varStatus="st">
<tr>
<td>${st.index +1 }</td>
<td>${s.fullname}</td>

<td>${s.email }</td>
<td>${s.password }</td>
<td>${s.contactno }</td>

<td> ${s.ticket.status }</td>
<td>
        ${s.ticket.title }
    </td>
    <%-- <td>
        ${s.ticket.ticketId }
    </td> --%>
   <td>
    <c:choose>
        <c:when test="${s.ticket != null}">
            ${s.ticket.ticketId},
        </c:when>

        <c:otherwise>
            No ticket assigned
        </c:otherwise>
    </c:choose>
</td> 
<%-- <td>
    <c:set var="ticketPrinted" value="false" />

    <c:forEach var="t" items="${list}">
        <c:if test="${t.id == s.id}">
            <c:if test="${ticketPrinted}">
                , 
            </c:if>
            ${t.ticket.ticketId}
            <c:set var="ticketPrinted" value="true" />
        </c:if>
    </c:forEach>

    <c:if test="${!ticketPrinted}">
        No ticket assigned
    </c:if>
</td>

 --%>
    
    <td>${s.ticket.remark }</td>

<td><a href="addremarkandstatusadmin/${s.ticket.ticketId }" class="btn btn-primary">Add remark</a></td>
<td>
<a href="/asign_ticket/${s.id}" class="btn btn-primary">Assign Ticket</a>
</td>

</tr>
</c:forEach>
</table>
</body>
</html>