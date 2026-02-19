

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
body {
    font-family: Arial;
    background:#e6f2ff;
}

.container {
    width:320px;
    margin:100px auto;
    background:white;
    padding:25px;
    border-radius:8px;
    box-shadow:0 0 10px gray;
}

h2 {
    text-align:center;
}

input {
    width:100%;
    padding:8px;
    margin:10px 0;
    border:1px solid #ccc;
    border-radius:4px;
}

button {
    width:100%;
    padding:10px;
    background:#007bff;
    border:none;
    color:white;
    font-size:16px;
    border-radius:5px;
}

button:hover {
    background:#0056b3;
}

a {
    text-decoration:none;
}
</style>

</head>
<body>

<div class="container">
<h2>User Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    Username:
    <input type="text" name="username" required>

    Password:
    <input type="password" name="password" required>

    <button type="submit">Login</button>
</form>

<br>
<center>
New user ? <a href="register">Register here</a>
<h3 style="color:red; text-align:center;">
    ${msg}
</h3>

</center>

</div>

</body>
</html>
