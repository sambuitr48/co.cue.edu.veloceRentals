<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="main">

    <!-- Vehicle List -->
    <section class="vehicle-list">
        <div class="container">
            <div class="vehicle-list-content">
                <h2 class="form-title">Vehicle List</h2>

                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Category</th>
                        <th>Brand</th>
                        <th>Plate</th>
                        <th>State</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Iterate over vehicles and display each row -->
                    <c:forEach items="${vehicles}" var="vehicle">
                        <tr>
                            <td>${vehicle.id}</td>
                            <td>${vehicle.category}</td>
                            <td>${vehicle.brand}</td>
                            <td>${vehicle.plate}</td>
                            <td>${vehicle.state}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
