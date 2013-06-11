<%-- 
    Document   : Panier
    Created on : 3 juin 2013, 17:37:55
    Author     : epulapp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Panier</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <div class="row-fluid">
            <div class="span3">
            </div>
            <div class="span6">
                <table class="table table-bordered">
                    <legend>Votre panier</legend> 
                    <thead>
                        <tr>
                            <th>
                                Titre
                            </th>
                            <th>
                                Prix
                            </th>
                            <th>
                                Action
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="article" items="${articles}">
                            <tr>
                                <th>
                                    ${article.titre}
                                </th>
                                <th>
                                    ${article.prix}
                                </th>
                                <th>
                                    <a href="${article.idArticle}" class="btn btn-primary">Retirer</a>
                                </th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="span3">
            </div>
    </body>
</html>
