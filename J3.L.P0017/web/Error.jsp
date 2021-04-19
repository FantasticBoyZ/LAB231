<%-- 
    Document   : HomePage
    Created on : Feb 25, 2021, 4:52:34 PM
    Author     : Vu Tien Khoi
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <h1>${error}</h1>
                </div>
                
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
