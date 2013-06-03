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
                        <form class="form-horizontal">
                            <legend>Détails de l'article :</legend> 
                            <div class="control-group">
                                <label class="control-label" for="infoNumero">N° Article:</label>
                                <div class="controls">
                                    <p id="infoNumero"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="infoTitre">Titre:</label>
                                <div class="controls">
                                    <p id="infoTitre"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="infoResume">Résumé:</label>
                                <div class="controls">
                                    <p id="infoResume"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="infoPrix">Prix:</label>
                                <div class="controls">
                                    <p id="infoPrix"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="infoDatePub">Date de publication:</label>
                                <div class="controls">
                                    <p id="infoDatePub"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="infoDomaine">Domaine</label>
                                <div class="controls">
                                    <p id="infoDomaine"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <button type="button" class="btn">Retour à la recherche</button>
                                    <button type="submit" class="btn">Ajouter au panier</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="span3">
            </div>
        </div>
    </body>
</html>
