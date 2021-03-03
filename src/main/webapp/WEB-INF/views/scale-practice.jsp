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
            <h1>Your fretboard looks like this</h1>
                <table>
                    <tbody>
                        <c:forEach items="${tuning}" var="sound">
                            <tr>
                                <td>
                                    ${sound.toString()}
                                </td>
                                <td>
                                    <div class="dot" style="width: 3px; height: 3px;"></div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </article>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>