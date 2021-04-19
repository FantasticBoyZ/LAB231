<%-- 
    Document   : Header
    Created on : Apr 11, 2019, 8:37:36 PM
    copyright by fu hub
    link group https://www.facebook.com/groups/498752080529382/
--%>
<%@page import="javax.naming.Context"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">                
                    <div class="left">
                        <c:forEach items="${listSearch}" var="article">
                            <div class="title1">
                                <a href="detail?id=${article.id}">      
                                    ${article.title}
                                </a>
                            </div>
                            <div class="contentArticle">
                                <div class="image1">
                                    <a href="detail?id=${article.id}"><img src="${article.image}" alt=""/></a>
                                </div>
                                <div class="content1">
                                    <a href="detail?id=${article.id}"><p>${article.content.substring(0,100)}...</p></a>
                                </div>
                            </div>
                            <br>
                        </c:forEach>
                        <div class="paging">
                            <c:if test="${maxPage < 1}">
                                <h3>Not Found !!</h3>
                            </c:if>
                            <c:if test="${maxPage >= 1}">
                                <c:forEach begin="1" end="${maxPage}" var="i">
                                    <a class="${i==index?"active":""}" href="search?index=${i}&Search=${txt}">${i}</a>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div> 
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>

    </body>
</html>
