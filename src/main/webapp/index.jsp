<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
        <h1><%= "Formulario JSP" %></h1>

        <form method="post" action="ServletLogin">
            <input name="nome">
            <input name="idade">

            <input type="submit" value="Enviar Formulario">


        </form>
    </body>
</html>