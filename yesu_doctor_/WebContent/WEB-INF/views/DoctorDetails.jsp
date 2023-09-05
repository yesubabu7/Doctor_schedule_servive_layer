<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center m-5"> </h1>
        <form action="/DocApp/doctorCalendar">
            <div class="row" id="doctor-list">
                <div class="col">
                    <div class="card border-light">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img class="card-img-top" src="${doctor.photo}" alt="Doctor Photo">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body text-center display-1">
                                    <h5 class="card-title">${doctor.fullname}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">${doctor.designation}</h6>
                                    <p class="card-text">${doctor.qualification}</p>
                                    <p class="card-text">${doctor.experience} years of experience</p>
                                    <button class="btn btn-info" type="submit" name="doctorid" value="${doctor.doctorid}">
                                        View Availability
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
