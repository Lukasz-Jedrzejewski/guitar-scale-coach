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
                    <form:select id="str" onchange="changeSelected(this)" path="numberOfStrings" multiple="false">
                        <c:forEach items="${numberOfStrings}" var="strings">
                            <c:choose>
                                <c:when test="${strings eq 6}">
                                    <option value="${strings}" selected="true">${strings}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${strings}">${strings}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-field">
                    <label>Choose number of frets</label>
                    <form:select id="fr" onchange="changeSelected(this)" path="numberOfFrets" multiple="false">
                        <c:forEach items="${numberOfFrets}" var="frets" varStatus="status">
                            <c:choose>
                                <c:when test="${frets eq 24}">
                                    <option value="${frets}" selected="true">${frets}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${frets}">${frets}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-field">
                    <label>Choose your tuning</label>
                        <script>
                            function changeSelected(selectObj) {
                                var index = selectObj.selectedIndex;
                                var val = selectObj.options[index].value;
                                console.log(val);
                            }
                        </script>
                </div>
            </form:form>
        </div>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>