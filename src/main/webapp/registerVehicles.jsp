<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Vehicle</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Register Vehicle</h2>
                    <form method="post" action="${pageContext.request.contextPath}/registerVehicles.jsp" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="category">Category</label>
                            <select name="category" id="category">
                                <option value="MOTORCYCLE">Motorcycle</option>
                                <option value="CAR">Car</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="brand">Brand</label>
                            <input type="text" name="brand" id="brand" placeholder="Brand" />
                        </div>
                        <div class="form-group">
                            <label for="plate">Plate</label>
                            <input type="text" name="plate" id="plate" placeholder="Plate" />
                        </div>
                        <div class="form-group">
                            <label for="state">State</label>
                            <input type="text" name="state" id="state" placeholder="State" />
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Submit" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
