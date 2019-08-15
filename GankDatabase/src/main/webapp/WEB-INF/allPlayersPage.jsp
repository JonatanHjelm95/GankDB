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
        <link rel = "stylesheet" type = "text/css" href = "stylesheet.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <%=request.getAttribute("topnav")%>
        <h1>All Players</h1>
        <%=request.getAttribute("playersList")%>

    </body>
</html>
