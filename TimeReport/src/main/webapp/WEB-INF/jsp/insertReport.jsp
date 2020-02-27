<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Confirmation</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<body>
			<div class="table-responsive-vertical shadow-z-1">
			<c:if test="${not empty emInsertList}">
			<h3><center>Data to be Inserted</center></h3>
				<table class="table table-hover table-mc-light-blue">



					<tr>
						<th>Employee ID</th>
						<th>BRID ID</th>
						<th>Employee Name</th>
						<th>Accenture Email ID</th>
						<th>Level</th>
						<th>DU</th>
						<th>Status</th>
						<th>Role</th>
						<th>Period</th>


					</tr>



					<c:forEach items="${emInsertList}" var="itr">

						<tr>
							<td><c:out value="${itr.employeeId}"></c:out></td>
							<td><c:out value="${itr.BRID}"></c:out></td>
							<td><c:out value="${itr.employeeName}"></c:out></td>
							<td></td>
							<td></td>
							<td><c:out value="${itr.DU}"></c:out></td>
							<td></td>
							<td></td>
							<td>
								<%-- <c:out value="${itr.period}"  > --%> <fmt:formatDate
									value="${itr.period}" pattern="yyyy-MM-dd" /> <%-- </c:out> --%>
							</td>

						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	<div class="table-responsive-vertical shadow-z-1">
			<c:if test="${not empty emRejectList}">
			<h3><center>Duplicate Data</center></h3>
				<table class="table table-hover table-mc-light-blue">



					<tr>
						<th>Employee ID</th>
						<th>BRID ID</th>
						<th>Employee Name</th>
						<th>Accenture Email ID</th>
						<th>Level</th>
						<th>DU</th>
						<th>Status</th>
						<th>Role</th>
						<th>Period</th>


					</tr>



					<c:forEach items="${emRejectList}" var="itr">

						<tr>
							<td><c:out value="${itr.employeeId}"></c:out></td>
							<td><c:out value="${itr.BRID}"></c:out></td>
							<td><c:out value="${itr.employeeName}"></c:out></td>
							<td></td>
							<td></td>
							<td><c:out value="${itr.DU}"></c:out></td>
							<td></td>
							<td></td>
							<td>
								<%-- <c:out value="${itr.period}"  > --%> <fmt:formatDate
									value="${itr.period}" pattern="yyyy-MM-dd" /> <%-- </c:out> --%>
							</td>

						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	
</body>
</html>