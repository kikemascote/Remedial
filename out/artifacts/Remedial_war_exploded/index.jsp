<%--
  Created by IntelliJ IDEA.
  User: Kike
  Date: 19/04/2020
  Time: 02:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css"/>
    <title>Taller Automotriz</title>
</head>
<body id="mainbody">
<div id="maindiv">
    <div id="container">
        <div id="logTitle">
            <h1>Bienvenido</h1>
            <h3>Introduce tus credenciales</h3>
        </div>
        <div style="height: 50px"></div>
        <div>
            <form action="ValidaServlet">
                <label><strong>Usuario</strong></label><br>
                <input type="text" name="user">
                <div style="height: 15px"></div>
                <label><strong>Contraseña</strong></label><br>
                <input type="password" name="pass">
                <div style="height: 50px"></div>
                <input type="submit" class="boton_pro" value="Log In">
            </form>
        </div>

    </div>

</div>
<div>

</body>
</html>
