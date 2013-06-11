<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Rechercher</title>
    </head>

    <script type="text/javascript">
        function submitform() {
            document.forms["rechercheForm"].submit();
        }
    </script>
    <body>
        <%@ include file="menu.jspf" %>
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <h3>Choisir un domaine</h3>
                    <form id="rechercheForm" method="post" action="rechercher.do">
                        <select name="codedomaine" size="1" onchange="javascript: submitform()">
                                <option value="0">Sélectionner un domaine</option>
                                <c:forEach items="${domaines}" var="item">
                                    <c:if test="${codeDomaine == item.idDomaine}">
                                        <option value="${item.idDomaine }" selected="true">${item.libdomaine }</option>
                                    </c:if>
                                    <c:if test="${codeDomaine != item.idDomaine}">
                                        <option value="${item.idDomaine }">${item.libdomaine }</option>
                                    </c:if>
                                </c:forEach>
                            </select> 
                    </form>
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
                                    Résumé
                                </th>
                                <th>
                                    Choisir
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${lstArticles}" var="item">
                            <tr>
                                <td>
                                    ${item.idArticle }
                                </td>
                                <td>
                                    ${item.titre }
                                </td>
                                <td>
                                    <a href="article.do?id=${item.idArticle }">Résumé</a>
                                </td>
                                <td>
                                    <a href="ajoutpanier.do?id=${item.idArticle }">Choisir</a>
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
