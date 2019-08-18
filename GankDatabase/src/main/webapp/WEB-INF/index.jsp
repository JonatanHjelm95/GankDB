<%-- 
    Document   : index
    Created on : Aug 15, 2019, 3:17:53 PM
    Author     : jonab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="stylesheet.css"/>




    </head>
    <body onload="myMove()">
        <%=request.getAttribute("topnav")%>
        <%=request.getAttribute("hitlistFeed")%>

        <h1>Home</h1>

        <script>
            function myMove() {
                var elem0 = document.getElementById("animate0");
                var elem1 = document.getElementById("animate1");
                var elem2 = document.getElementById("animate2");
                var elem3 = document.getElementById("animate3");
                var elem4 = document.getElementById("animate4");
                var borderStart = 100;
                var borderEnd = 372;
                var pos0 = borderStart + 0;
                var pos1 = borderStart+68;
                var pos2 = borderStart+136;
                var pos3 = borderStart+204;
                var pos4 = borderStart+272;


                var id = setInterval(frame, 60);
                function frame() {
                    if (pos0 == borderEnd) {
                        pos0 = borderStart;
                    }
                    if (pos1 == borderEnd) {
                        pos1 = borderStart;
                    }
                    if (pos2 == borderEnd) {
                        pos2 = borderStart;
                    }
                    if (pos3 == borderEnd) {
                        pos3 = borderStart;
                    }
                    if (pos4 == borderEnd) {
                        pos4 = borderStart;
                    } else {
                        pos0++;
                        pos1++;
                        pos2++;
                        pos3++;
                        pos4++;

                        elem0.style.top = pos0 + "px";
                        elem1.style.top = pos1 + "px";
                        elem2.style.top = pos2 + "px";
                        elem3.style.top = pos3 + "px";
                        elem4.style.top = pos4 + "px";



                    }
                }
            }
        </script>

    </body>
</html>
