<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
        <h1><%= "Formulario JSP" %></h1>


        <form method="post" action="ServletLogin">
            <input type="hidden" value="<%= request.getParameter("url")%>" name="url">
            <table>
                <tr>
                    <td><label>Login</label></td>
                    <td><input name="login" type="text"></td>
                </tr>
                <tr>
                    <td><label>Senha</label></td>
                    <td><input name="password" type="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Enviar Formulario">
                    </td>
                </tr>
            </table>
        </form>
    <h4>${msng}</h4>
    </body>
</html>