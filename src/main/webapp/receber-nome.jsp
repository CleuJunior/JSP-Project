<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <% String nome = request.getParameter("nome");
    String idade = request.getParameter("idade");
    out.println(nome);
    out.println("\n" + idade);
  %>


</body>
</html>
