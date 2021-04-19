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
        <title>JSP Page</title>
        <link href="css/location.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="location_title">
                        Find Maria's Cafe
                    </div>
                    <div class="location">
                        <div class="location_left">
                            <div class="location_header">
                                Address and contact:
                            </div>
                            <p>${infor.address}</p>
                            <p>Tel:${infor.tel}</p>
                            <p>Email:${infor.email}</p>
                        </div>
                        <div class="location_right">
                            <div class="location_header">
                                Opening hours:
                            </div>
                            ${infor.openingHours}
                        </div>
                    </div>
                    <div class="map">
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
