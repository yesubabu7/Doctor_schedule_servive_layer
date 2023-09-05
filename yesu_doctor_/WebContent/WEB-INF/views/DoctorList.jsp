<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="/DocApp/doctorDetails">
			<div class="container-fluid m-2 display-flex"
				id="specilization-options">
				<label for="sp-select" class="h4">Filter By Specialization</label> <select
					onchange="navigate()" name="sp-select" id="specialization-select">
					<option value="all">All</option>
					<c:forEach items="${specializationData}" var="specialization">
						<option value="${specialization.specializationname}">${specialization.specializationname}</option>
					</c:forEach>
				</select>
			</div>
			<div class="row" id="doctor-list">
				<c:forEach items="${doctorsData}" var="doctor">
					<div class="col-md-4 mb-4">
						<div class="card">
							<div class="card-body">
								<img class="card-img-top" src="${doctor.photo}"
									alt="Doctor Photo">
								<h5 class="card-title">${doctor.fullname}</h5>
								<h6 class="card-title">${doctor.designation}</h6>
								<button class="btn btn-info" type="submit" name="doctorid"
									value="${doctor.doctorid}">View Details</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</form>
	</div>
	<script>
		function navigate() {
			var select = document.querySelector('select');
			var selectedOption = select.options[select.selectedIndex];

			window.location.href = "/DocApp/doctorList?specialization="
					+ selectedOption.value;
		}
	</script>
</body>
</html>
