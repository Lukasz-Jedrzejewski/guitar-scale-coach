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
                        <tr>
                            <td class="fretboard-head">your tuning</td>
                            <td class="fretboard-head">string</td>
                            <c:forEach var = "i" begin = "1" end = "${frets.toString()}">
                                <td class="fretboard-head">${i}</td>
                            </c:forEach>
                        </tr>
                        <c:forEach items="${tuning}" var="sound" varStatus="iteration">
                            <tr>
                                <td>
                                    ${sound.toString()}
                                </td>
                                <td>
                                    <div class="dot" style="width: calc(3px*(${iteration.index+1})); height: calc(3px*(${iteration.index+1}));"></div>
                                </td>
                                    <jsp:useBean id="guitar" class="com.jedrzejewski.guitarscalecoach.model.Guitar"/>
                                    <c:set var="s" value="${sound}"/>
                                    <c:set var="f" value="${frets}"/>
                                    <c:set var="list" value="${guitar.fill(s, f)}"/>
                                    <c:forEach items="${list}" var="cs">
                                <td>
                                    ${cs.toString()}
                                </td>
                                    </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </article>
    </section>
    <%@include file="footer.jsp"%>
</body>
</html>