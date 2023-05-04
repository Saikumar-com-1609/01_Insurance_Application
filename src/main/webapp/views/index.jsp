<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2 class="pb-3 pt-3">Insurance Application</h2>

		<form:form action="search" modelAttribute="search" method="POST">

			<table class="table-hover">

				<tr>

					<td>Plan Name:</td>
					<td><form:select path="PLAN_NAME">
							<form:option value="">-Select-</form:option>
							<form:options items="${plannames}" />
						</form:select></td>

					<td>Plan Status:</td>
					<td><form:select path="PLAN_STATUS">
							<form:option value="">-Select-</form:option>
							<form:options items="${planstatuses}" />
						</form:select></td>

					<td>Gender:</td>
					<td><form:select path="GENDER">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">FeMale</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>Plan Start Date:</td>
					<td><form:input path="PLAN_START_DATE" type="date" /></td>

					<td>Plan End Date:</td>
					<td><form:input type="date" path="PLAN_END_DATE" /></td>
				</tr>

				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>



			</table>
		</form:form>
		<hr />
		<table border="1" class="table table-dark table-striped table-hover">
			<thead>
				<tr>
					<th>S.NO</th>
					<th>Customer Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Plan Start Date</th>
					<th>Plan End Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerplans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.CITIZEN_NAME}</td>
						<td>${plan.GENDER}</td>
						<td>${plan.PLAN_NAME}</td>
						<td>${plan.PLAN_STATUS}</td>
						<td>${plan.PLAN_START_DATE}</td>
						<td>${plan.PLAN_END_DATE}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty customerplans}">
						<td colspan="7" style="text-align: center">No Records Found</td>
					</c:if>
				</tr>
			</tbody>
		</table>
		<hr />


		Export :<img src="C:\Users\test\Downloads\excelimage.png" /> <a
			href="excel">Excel</a> <a href="pdf">Pdf</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>