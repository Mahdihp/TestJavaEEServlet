<%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 03/08/2018
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
<header>
  <div>
    <p id="title">صفحه ورود</p>
  </div>
</header>
<section>
  <div>

    <form action="./LoginServlet" method="POST">
      <input name="username" type="text"/> <label>: نام کاربری </label> <br/>
      <input name="password" type="text"/>  <label>: رمز عبور </label> <br/>
      <input value="   ورود   " type="submit"/><br/>
    </form>

  </div>
</section>
</body>
</html>
