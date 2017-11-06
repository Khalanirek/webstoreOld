<%-- 
    Document   : welcome
    Created on : 2017-10-31, 15:23:25
    Author     : Piotr Turli?ski
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-
1">
<link rel="stylesheet"
href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1> ${greeting} </h1>
                <p> ${tagline} </p>
            </div>
        </div>
    </section>
</body>
</html>
