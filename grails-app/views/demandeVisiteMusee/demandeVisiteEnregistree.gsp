<!DOCTYPE html>
<%@ page import="museetoulouse.Musee" %>
<html xmlns="http://www.w3.org/1999/html">
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


    #index{
        margin-left: 20%;
        border: 1px solid crimson;
        width: 65%;
    }

    </style>
</head>
<body>
<h1 align="center" style="color: black"><u> Votre demande a bien été enregistrée, Voici le resumé: </u></h1><br>
<div id="index" >
    <fieldset class="form">
        <div class="fieldcontain">

               <li><p><b>Votre Code est:</b> <b style="color: #AA0E0E">${codeDemande}</b> (A conserver pour consulter votre demande)</p>
               </li>
        </div>
        <div class="fieldcontain">

               <li><b>Date Debut de visite:</b> <b style="color: #AA0E0E">${dateDebut}</b></li>


        </div>
        <div class="fieldcontain">
            <li><b>Date Fin de visite:</b> <b style="color: #AA0E0E">${dateFin}</b></li>


        </div>
        <div class="fieldcontain">
            <li><b>Nombre de personnes:</b> <b style="color: #AA0E0E">${nbPersonnes}</b></li>

        </div>
        <div class="fieldcontain">
            <li><b>Etat de la demande:</b> <b style="color: #AA0E0E">${status}</b></li>

        </div>
        <br>
    </fieldset>
</div>
</body>
</html>
