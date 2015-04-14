<!DOCTYPE html>
<%@ page import="museetoulouse.Musee" %>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
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
				}
			}
		</style>
	</head>
	<body>
    <g:form controller="musee" action="doSearchMusee">
        <fieldset class="form">
            <div class="fieldcontain">
                <label for="nom">
                    Nom Musée :
                </label>
                <g:textField name="nom"/>

            </div>
            <div class="fieldcontain">
                <label for="codePostal">
                    Code Postale :
                </label>
                <g:select name="codePostal"
                          from="${museetoulouse.Adresse.list().codePostal.unique()}" />
            </div>
            <div class="fieldcontain">
                <label for="rue">
                    Le nom Rue :
                </label>
                <g:textField name="rue"/>
            </div>
            <div style="float: right">
                <span class="buttons" >
                    <input value="Submit" type="submit">
                </span>
            </div>
        </fieldset>

    </g:form>
	</body>
</html>
