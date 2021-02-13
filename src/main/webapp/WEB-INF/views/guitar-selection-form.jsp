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
        <div id="selection">
            <form:form method="post" action="/practice/guitar-selection" modelAttribute="guitar">
                <div class="form-field">
                    <label>Choose number of strings</label>
                    <form:select id="str" onchange="changeSelected(this);" path="numberOfStrings" multiple="false">
                        <option disabled selected value> -- select number of strings -- </option>
                        <c:forEach items="${numberOfStrings}" var="strings">
                            <option value="${strings}">${strings}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-field">
                    <label>Choose number of frets</label>
                    <form:select id="fr" onchange="changeSelected(this)" path="numberOfFrets" multiple="false">
                        <option disabled selected value> -- select number of frets -- </option>
                        <c:forEach items="${numberOfFrets}" var="frets" varStatus="status">
                            <option value="${frets}">${frets}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-field" id="tune">
                    <form:select path="tuning" multiple="false" id="t-s" style="display: none;">
                        <option disabled selected value> -- select the sound -- </option>
                        <c:forEach var="sound" items="${sounds}">
                            <option value="${sound}">${sound}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="div-table">
                    <table class="table--">

                    </table>
                </div>
            </form:form>
        </div>
    </section>
    <%@include file="footer.jsp"%>

    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>