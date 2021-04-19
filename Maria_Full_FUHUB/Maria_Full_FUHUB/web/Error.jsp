<%-- 
    Document   : Error.jsp
    Created on : Mar 1, 2019, 2:14:35 PM
    copyright by fu hub
    link group https://www.facebook.com/groups/498752080529382/
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1>${error}</h1>
                </div>
            </div>
            <jsp:include page="Right.jsp"/> 
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
