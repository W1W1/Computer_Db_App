<%--
  Created by IntelliJ IDEA.
  User: Richard-DT
  Date: 07/09/2016
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Test</title>
</head>
<body>
<p>Ceci est une page générée depuis une JSP.</p>
<p>
    <%
            String attribut = (String) request.getAttribute("test");
        out.println(attribut);
    %>
</p>
</body>
</html>
