<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
        <h1><%= "Hello World!" %></h1>
        <h1><%= "Cleonildo Junior, Teste de JSP" %></h1>
        <% out.println("Testando Compilaçao Java dentro do JSP"); %>

        <form method="post" action="receber-nome.jsp">
            <input name="nome">
            <input name="idade">

            <input type="submit" value="Enviar Formulario">


        </form>


        <br/>
        <a href="hello-servlet">Hello Servlet</a>
    </body>
</html>