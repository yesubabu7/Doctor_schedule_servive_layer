<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Form</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Custom CSS Styles -->
    <style>
        /* Add your custom CSS styles here */
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        /* Style for form labels */
        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mb-4">Booking Form</h2>
        <form action="BookingDetails" method="post">
            <!-- Hidden fields for doctorId and selectedDate -->
            <input type="hidden" name="doctorId" value="${param.doctorId}">
            <input type="hidden" name="selectedSlot" value="${param.selectedDate}">
            
            <!-- Patient details -->
            <div class="mb-3">
                <label for="patientId" class="form-label">Patient ID:</label>
                <input type="text" class="form-control" name="patientId" required>
            </div>
            
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            
            <div class="mb-3">
                <label for="gender" class="form-label">Gender:</label>
                <select class="form-select" name="gender" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            
            <div class="mb-3">
                <label for="phone" class="form-label">Phone Number:</label>
                <input type="tel" class="form-control" name="phone" required>
            </div>
            
            <div class="mb-3">
                <label for="age" class="form-label">Age:</label>
                <input type="number" class="form-control" name="age" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Book Appointment</button>
        </form>
    </div>
</body>
</html>
