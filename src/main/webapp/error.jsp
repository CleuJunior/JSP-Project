<%--
  Created by IntelliJ IDEA.
  User: Desktop
  Date: 18/06/2022
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tela de Error</title>
</head>
<body>
    <h1>Menssagem de Erro, entre em contato com a equipe de suporte</h1>

    <% out.print(request.getAttribute("msg")); %>

</body>
</html>
