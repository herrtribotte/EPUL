<%-- 
    Document   : Connexion
    Created on : 3 juin 2013, 16:37:27
    Author     : epulapp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="headerBootstrap.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Net Articles - Identification</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <div class="row-fluid">
            <div class="span4">
            </div>
            <div class="span4">
                <form class="form-horizontal">
                    <legend>Identification :</legend> 
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Login:</label>
                        <div class="controls">
                            <input name="txtLogin" type="text" id="inputEmail" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword">Mot de passe:</label>
                        <div class="controls">
                            <input name="txtPwd" type="password" id="inputPassword" />
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn">Valider</button>
                        </div>
                        <span class="help-block">Vous souhaitez vous enregistrer ? <a>créer un compte</a></span>
                    </div>
                    
                </form>
            </div>
            <div class="span4">
            </div>
        </div>
    </body>
</html>
