<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Mes articles</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <h2>Mes articles</h2>
                </div>
                <div class="span12">
                    <c:if test="${lstArticles.size() != 0}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>
                                    Numéro de l'article
                                </th>
                                <th>
                                    Titre
                                </th>
                                <th>
                                    Télécharger
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${lstArticles}" var="item">
                            <tr>
                                <td>
                                    ${item.article.idArticle }
                                </td>
                                <td>
                                    ${item.article.titre }
                                </td>
                                <td>
                                    <a href="${item.article.fichier }">Télécharger</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
    </body>
</html>
