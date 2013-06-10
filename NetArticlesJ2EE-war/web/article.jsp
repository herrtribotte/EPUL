<%-- 
    Document   : Article
    Created on : 3 juin 2013, 16:43:26
    Author     : epulapp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Détail Article</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <div class="row-fluid">
            <div class="span3">
            </div>
            <div class="span6">
                <div class="thumbnail">
                    <img alt="1000x70" class="img-rounded" src="http://lorempixel.com/1000/70/abstract" />
                    <div class="caption">
                            <%@ include file="detailArticle.jspf" %>
                            <div class="control-group">
                                <div class="controls">
                                    <a href="/rechercher.do?codedomaine=${codeDomaine}" class="btn btn-primary">Retour à la recherche</a>
                                    <a href="/ajouterpanier.do?idarticle=${article.id}" class="btn btn-primary">Ajouter au panier</a>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
            <div class="span3">
            </div>
        </div>
    </body>
</html>
