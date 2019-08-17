<%-- 
    Document   : allPlayersPage
    Created on : Aug 15, 2019, 7:34:15 PM
    Author     : jonab
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Players Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="stylesheet.css"/>

        <script src="autocomplete.js"></script>
        <link rel="stylesheet" href="autocomplete.css">

            <%=request.getAttribute("DatalistScript")%>

        </head>
        <body>
            <%=request.getAttribute("topnav")%>
            <h1>Search</h1>

            <%=request.getAttribute("Datalist")%>


            <label for="autocomplete">Search for Players</label>
            <form action="FrontController" method="POST">
                <input type="text" name="searchValue" id="SearchValue">
                <input type="submit" name="command" value="Search">
                <input type="hidden" name="playerName" value="Fuglenørden">  
            </form>

        </body>
    </html>
