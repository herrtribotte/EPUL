<%-- 
    Document   : CompteUtilisateur
    Created on : 3 juin 2013, 15:30:57
    Author     : epulapp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Compte Utilisateur</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <div class="row-fluid">
            <div class="span4">
            </div>
            <div class="span4">
                <form class="form-horizontal">
                    <legend>Vos informations :</legend> 
                    <div class="control-group">
                        <label class="control-label" for="inputIdentite">Identité:</label>
                        <div class="controls">
                            <input id="inputIdentite" type="text" name="txtIdentiteClient" value="${utilisateurR.identite}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputAdresse">Adresse:</label>
                        <div class="controls">
                            <input id="inputAdresse" type="text" name="txtAdresseClient" value="${utilisateurR.adresse}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLogin">Login:</label>
                        <div class="controls">
                            <input id="inputLogin" type="text" name="txtLoginClient" value="${utilisateurR.login}"/>  
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPwd">Mot de passe:</label>
                        <div class="controls">
                            <input id="inputPwd" type="text" name="txtPwdClient" value="${utilisateurR.pwd}"/> 
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputCredits">Credits:</label>
                        <div class="controls">
                            <input id="inputCredits" type="number" name="txtCredits" value="${utilisateurR.credits}"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputCategories">Catégorie:</label>
                        <div class="controls">
                            <select id="inputCategories" name="lstCategories">
                                <c:forEach var="categorie" items="${lstCategories}">
                                    <option value="${categorie.name}">${categorie.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>    
                    <div class="control-group">
                        <div class="controls">
                            <button type="button" class="btn">Annuler</button>
                            <button type="submit" class="btn">Valider</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="span4">
            </div>
        </div>
    </body>
</html>
