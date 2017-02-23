<%--
  Created by IntelliJ IDEA.
  User: scheldejonas
  Date: 23/02/2017
  Time: 09.22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <title>Opret kunde</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="/static/vendor/materialize/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen, projection" />
    <link href="/static/app.css" type="text/css" rel="stylesheet" media="screen,projection"/>

</head>

<body>

<nav class="blue" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="/jsp" class="brand-logo">
            <img src="/static/images/jonas%20default%20training%20logo.png">
        </a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/">Frontpage</a></li>
            <li><a href="/customers/add">Opret kunde</a></li>
        </ul>
        <ul id="nav-mobile" class="side-nav">
            <li><a href="/">Frontpage</a></li>
            <li><a href="/customers/add">Opret kunde</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<div class="section no-pad-bot" id="index-banner">
    <div class="container bottom_50">
        <h1 class="header center grey-text">Opret kunde</h1>
        <div class="row center">
            <h5 class="header col s12 light">Velkommen til training sektionen</h5>
        </div>
    </div>
    <div class="container bottom_50">
        <div class="row">
            <form class="col s12" action="/customer/add" method="post" accept-charset="UTF-8">
                <div class="row">
                    <div class="col s4 offset-s2 input-field">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                        <label for="first_name">Fornavn</label>
                    </div>
                    <div class="col s4 input-field">
                        <input placeholder="Pris" id="price" class="validate" type="number">
                        <label for="price">Pris</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 offset-s4">
                        <button type="submit" class="btn waves-effect waves-light" name="action">Submit
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="/static/vendor/materialize/js/materialize.js"></script>
<script src="/static/vendor/materialize/js/init.js"></script>

</body>

</html>
