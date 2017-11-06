<%-- 
    Document   : customers
    Created on : 2017-11-02, 22:07:14
    Author     : Piotr Turli?ski
--%>

<%-- 
    Document   : products
    Created on : 2017-10-31, 23:42:15
    Author     : Piotr Turli?ski
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-
        8859-1">
        <link rel="stylesheet"

        href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Customers</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customers</h1>
                    <p>All ours Customers</p>
                </div>
            </div>
        </section>
        
        <section class="container">
            <div class="row">
                <c:forEach items="${customers}" var="customer">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>${customer.customerId}</h3>
                            <p>${customer.name}</p>
                            <p>${customer.address}</p>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
