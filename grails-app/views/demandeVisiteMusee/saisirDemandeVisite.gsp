<!DOCTYPE html>
<%@ page import="museetoulouse.MuseePrefere; museetoulouse.Musee" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Musée Toulouse</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
            color: brown;
        }
        #page-left h1 {
            margin-top: 0;
            color: brown;
        }
    }
    #search {
        float: right;
        border: 1px solid black;
        width: 50%;
    }
    #page-left{
        float: left;
        border: 1px solid black;
        width: 45%;
    }
    #index{
        margin-left: 20%;
        border: 1px solid crimson;
        width: 60%;
    }

    </style>
</head>
<body>
<div id="index" >

    <h1 align="center" style="color: brown">Saisir Demande Visite </h1>
    <g:form controller="demandeVisiteMusee" action="justCreatedDemandeVisiteMusee">
        <fieldset class="form">
            <div class="fieldcontain">
                <label for="datedebut">
                    <b>Date Debut:</b>
                </label>
                <g:datePicker name="datedebut" value="${new Date()}" precision="day" years="${2015..2020}"/>

            </div>
            <div class="fieldcontain">
                <label for="datefin">
                    <b>Date Fin:</b>
                </label>
                <g:datePicker name="datefin" value="${new Date()}" precision="day" years="${2015..2020}"/>
            </div>
            <div class="fieldcontain">
                <label for="nbpersonnes">
                    <b>Nombre de personnes:</b>
                </label>
                <g:select name="nbpersonnes" from="${[1,2,3,4,5,6]}" style="color: darkred" />
            </div>
            <br>
            <div style="float: right">
                <g:submitButton name="Confirmer" value="Confirmer" />
            </div>
        </fieldset>
    </g:form>
</div>
<div>
    <%

        museetoulouse.MuseePrefere mesPreferes = session.getAttribute("mesPreferes")

        if(!mesPreferes) {
            mesPreferes = new museetoulouse.MuseePrefere(idSession: session.getId())
            session["mesPreferes"] = mesPreferes

        }

    %>
    <h1 style="color: #BE5B5B" align="center"><b><u> Liste des Musées à associer à cette Demande</u></b></h1>
    <table border="1px solid #BE5B5B ">
        <thead>

        <tr>
            <th><g:message code="musee.nom.label" default="Nom Musee" /></th>
            <th>
                <% if(mesPreferes?.museePreferes){ %>
                <g:form controller="museePrefere" action="removeAllFromMesPreferes">
                    <input src="../images/close.png" placeholder="DeleteAll" value="Supprimer" type="image">
                </g:form>
                <% }
                %>
            </th>
        </tr>
        <tbody>
        <%
            if(mesPreferes?.museePreferes){
        %>
        <g:each in="${mesPreferes.museePreferes}" status="i" var="musee">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <g:form controller="museePrefere" action="removeFromMesPreferes">
                    <input type="hidden" name="nomMusee" value="${fieldValue(bean: musee, field: "nom")}" />
                    <td>${fieldValue(bean: musee, field: "nom")}</td>
                    <td><input src="../images/delete.png" value="Supprimer" type="image"></td>
                </g:form>
            </tr>
        </g:each>
        <% }
        else {
        %>
        <tr>
            <td style="color: red"> La Liste est vide <img src="../images/warning.gif"></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
