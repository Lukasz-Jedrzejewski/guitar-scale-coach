<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <div>
            <form:form method="post" action="/practice/guitar-selection" modelAttribute="guitar">
                <div class="form-field">
                    <label>Choose number of strings</label>
                    <form:select path="numberOfStrings" items="${numberOfStrings}" multiple="false"/>
                </div>
                <div class="form-field">
                    <label>Choose number of frets</label>
                    <form:select path="numberOfFrets" items="${numberOfFrets}" multiple="false"/>
                </div>
            </form:form>
        </div>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>