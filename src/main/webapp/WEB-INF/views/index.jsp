<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/fontello-1600921a/css/fontello.css"/>"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <%@include file="navigation-bar.jsp"%>
    <section>
        <article>
            <div class="info-head">
                <h1>Idea of ​​the project</h1>
                <p>Here will be a description of the project assumptions</p>
            </div>
        </article>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>