<%-- 
    Document   : HomePage
    Created on : 25-Dec-2019, 03:26:19
    /*copyright by fu hub*/
    /*link group https://www.facebook.com/groups/498752080529382/*/
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cake Detail</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="cake">
                        <div class="cake_title">${cake.name}</div>
                        <div class="cake_detail">
                            <div class="cake_image">
                                <img src="${cake.picture}" alt=""/>
                            </div>
                            ${cake.detailDescription}
                        </div>
                        <div class="cake_price">
                            Price: ${cake.price} $
                        </div>
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
