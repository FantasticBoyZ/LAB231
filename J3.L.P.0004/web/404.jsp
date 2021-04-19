<%-- 
    Document   : 404
    Created on : Feb 25, 2021, 11:40:06 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <h1>Error Code 404 - Page Not Found!!! Please check your URL</h1>
                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
