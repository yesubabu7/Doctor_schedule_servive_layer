<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Confirmation</title>
    
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- Add your custom CSS link here -->
    <link rel="stylesheet" href="your-custom.css">
    
    <style>
        /* Custom styles */
        .container {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
        }
        
        h2 {
            color: #343a40;
        }
        
        .patient-details li {
            list-style-type: none;
            padding: 5px 0;
        }
        
        .slot-info {
            background-color: #17a2b8;
            color: #fff;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <h2 class="mb-4">Booking Successfully</h2>
                
                <!-- Display Doctor Details using Bootstrap classes -->
                <h3>Doctor Details:</h3>
                <ul class="doctor-details">
                    <li>Doctor ID: ${doctor[0].doctorid}</li>
                    <li>Name: ${doctor[0].fullname}</li>
                    <li>Qualification: ${doctor[0].qualification}</li>
                    <li>Experience: ${doctor[0].experience} years</li>
                    <li>Designation: ${doctor[0].designation}</li>
                </ul>
                
                <!-- Display Selected Slot Information -->
                <div class="slot-info mt-4">
                    <h4>Selected Slot:</h4>
                    <p>From: ${SlotTimeFrom}</p>
                    <p>To: ${SlotTimeTo}</p>
                    <p>Date: ${SlotTimeDate}</p>
                </div>
            </div>
            
            <div class="col-md-6">
                <!-- Display Patient Details -->
                <h3 class="mb-4">Patient Details:</h3>
                <ul class="patient-details">
                    <li>Patient ID: ${patientId}</li>
                    <li>Name: ${name}</li>
                    <li>Gender: ${gender}</li>
                    <li>Phone Number: ${phone}</li>
                    <li>Age: ${age}</li>
                </ul>
            </div>
        </div>
    </div>
    
    <!-- Include Bootstrap JS scripts here if needed -->
</body>
</html>
