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
<title>Report</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--Here function is passed to the change method-->
<!-- <script>
	$(document).ready(function() {
		$("#dlist").change(function() {
			alert($("#dlistt").val());
		});

		$("#year").change(function() {
			$("#quarter").prop("disabled", this.value == -1);
			$("#du").prop("disabled", this.value == -1);
		});
	});
</script> -->

<script>
	$(document).ready(function() {

		if($("#year").val()!=0 && $("#year").val()!=null )
			{
			$("#quarter").prop("disabled", false);
			}
		$("#year").change(function() {
			if($("#year").val()!=0 && $("#year").val()!=null )
			{
			$("#quarter").prop("disabled", false);
			}
			else{
				$("#quarter").prop("disabled", true);
				
				}
		});

		if ($("#empId").length > 0 && $("#empId").val() != "") {
			$("#du").prop("disabled", true);
		} 
		$("#empId").change(function() {

			if ($("#empId").length > 0 && $("#empId").val() != "") {
				$("#du").prop("disabled", true);
			} else {
				$("#du").prop("disabled", false);
			}
		});
	});
</script>
<script type="text/javascript">


$(document).ready(function() {

    var table = $('#table');

    // Table bordered
    $('#table-bordered').change(function() {
        var value = $( this ).val();
        table.removeClass('table-bordered').addClass(value);
    });

    // Table striped
    $('#table-striped').change(function() {
        var value = $( this ).val();
        table.removeClass('table-striped').addClass(value);
    });
  
    // Table hover
    $('#table-hover').change(function() {
        var value = $( this ).val();
        table.removeClass('table-hover').addClass(value);
    });

    // Table color
    $('#table-color').change(function() {
        var value = $(this).val();
        table.removeClass(/^table-mc-/).addClass(value);
    });
});

// jQuery’s hasClass and removeClass on steroids
// by Nikita Vasilyev
// https://github.com/NV/jquery-regexp-classes
(function(removeClass) {

	jQuery.fn.removeClass = function( value ) {
		if ( value && typeof value.test === "function" ) {
			for ( var i = 0, l = this.length; i < l; i++ ) {
				var elem = this[i];
				if ( elem.nodeType === 1 && elem.className ) {
					var classNames = elem.className.split( /\s+/ );

					for ( var n = classNames.length; n--; ) {
						if ( value.test(classNames[n]) ) {
							classNames.splice(n, 1);
						}
					}
					elem.className = jQuery.trim( classNames.join(" ") );
				}
			}
		} else {
			removeClass.call(this, value);
		}
		return this;
	}

})(jQuery.fn.removeClass);

</script>
</head>
<body>


	<form:form modelAttribute="filterObj" action="/accenture/timereport"
		method="POST">


			<table class="table table-bordered">
				<tr>
					<td><form:select path="year" id="year" cssClass="form-control" >
							<option selected="selected" disabled="disabled">Year</option>
							<option value="0">All</option>
							<!-- <option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020	">2020</option> -->
							<c:forEach items="${yearObj}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:select path="quarter" id="quarter" disabled="true" cssClass="form-control" >
							<option selected="selected" disabled="disabled">Quarter</option>
						 	<option value="all">All</option>
					<!--	<option value="q1">Q1</option>
					<option value="q2">Q2</option>
					<option value="q3">Q3</option>
					<option value="q4">Q4</option> -->
							<c:forEach items="${quarterList}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:select path="du" id="du" disabled="false" cssClass="form-control"  >
							<option selected="selected" disabled="disabled">DU</option>
							<option value="all">All</option>

							<!-- <option value="FSBBAR01">FSBBAR01</option>
					<option value="FSBBAR02">FSBBAR02</option>
					<option value="FSBBAR03">FSBBAR03</option>
					<option value="FSBBAR04">FSBBAR04</option>
 -->

							<c:forEach items="${duList}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:input path="employeeId" id="empId" cssClass="form-control" placeholder="Employee Id"  /></td>
					 <td><form:checkbox
							path="isCount" id="cnt" label="Get Result as Count"
							value="checked"></form:checkbox>
					<td><input type="submit" id="submit" Class="form-control btn btn-primary"  ></td>
				</tr>
			</table>
		<br>
		<div class="table-responsive-vertical shadow-z-1">
			<c:if test="${not empty list}">
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



					<c:forEach items="${list}" var="itr">

						<tr>
							<td><c:out value="${itr.employeeId}"></c:out></td>
							<td></td>
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
		<c:if test="${not empty reportList}">
			<table class="table table-bordered">



				<tr>
					<th>Employee ID</th>
					<th>BRID ID</th>
					<th>Employee Name</th>
					<th>Accenture Email ID</th>
					<th>Level</th>
					<th>DU</th>
					<th>Status</th>
					<th>Role</th>
					<th>Count</th>

				</tr>



				<c:forEach items="${reportList}" var="itr">

					<tr>
						<td><c:out value="${itr.employeeId }"></c:out></td>
						<td></td>
						<td><c:out value="${itr.employeeName}"></c:out></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><c:out value="${itr.count }"></c:out></td>

					</tr>
				</c:forEach>
			</table>
		</c:if>



	</form:form>

	<!-- <form th:object="${filterObj}" action="/accenture/getAll" method="get">
	<table class="table table-bordered">
		<tr>
			<th><select th:field="*{filterObj.year}" name="year" id="year">
					<option disabled="disabled" selected="selected" value="">Year</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020	">2020</option>
			</select></th>

		<th>
		
		<select name="quarter" id="quarter" disabled="disabled" th:value="${filterObj.quarter}">
					<option disabled="disabled">Quarter</option>
					<option value="q1">Q1</option>
					<option value="q2">Q2</option>
					<option value="q3">Q3</option>
					<option value="q4">Q4</option>
					
			</select>
		</th>
		
		<th>
		
		<select name="du" id="du" disabled="disabled" th:value="${filterObj.du}">
					<option disabled="disabled" selected="selected">DU</option>
					<option value="FSBBAR01">FSBBAR01</option>
					<option value="FSBBAR02">FSBBAR02</option>
					<option value="FSBBAR03">FSBBAR03</option>
					<option value="FSBBAR04">FSBBAR04</option>
					
			</select>
		</th>
		<th> <input type="submit" id="submit"> </th>
		</tr>
		<tr>
			<th>Employee ID</th>
			<th>BRID ID</th>
			<th>Employee Name</th>
			<th>Accenture Email ID</th>
			<th>Level</th>
			<th>DU</th>
			<th>Status</th>
			<th>Role</th>

		

		</tr>


		<tr th:each="emp : ${list}">
			<td th:text="${emp.employeeName}"></td>
			<td th:text="${emp.period}"></td>

		</tr>
	
	</table>
	
</form> -->
</body>
</html>