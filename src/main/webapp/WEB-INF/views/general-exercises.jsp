<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/fontello-1600921a/css/fontello.css"/>"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>General exercises</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <%@include file="navigation-bar.jsp"%>
    <section>
        <article>
            <div class="info-head">
                <h1>Here are some general exercises. You should practice everyday!</h1>
            </div>
            <div id="exercise-header">
                <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                <div class="single-ex">
                    <h2>Spider</h2>
                    <button id="spider-btn" class="start-btn" onclick="executeSpider()">start</button>
                </div>
                <div class="single-ex">
                    <h2>Backward spider</h2>
                    <button id="back-spider-btn" class="start-btn" onclick="executeBackwardSpider()">start</button>
                </div>
                <a class="next" onclick="plusSlides(1)">&#10095;</a>
            </div>
            <%@include file="speed-params.jsp"%>
            <div id="selection">
                <table id="spider-tab">
                    <tbody>
                        <tr>
                            <td class="fretboard-head">tuning</td>
                            <td class="fretboard-head">string</td>
                                <c:forEach var = "i" begin = "1" end = "${guitar.NUMBER_OF_FRETS.toString()}">
                                    <td class="fretboard-head">${i}</td>
                                </c:forEach>
                        </tr>
                        <c:forEach items="${guitar.TUNING}" var="sound" varStatus="iteration">
                            <tr>
                                <td>${sound.toString()}</td>
                            <td>
                                <div class="dot" style="width: calc(3px*(${iteration.index+1})); height: calc(3px*(${iteration.index+1}));"></div>
                            </td>
                                <jsp:useBean id="currentGuitar" class="com.jedrzejewski.guitarscalecoach.model.Guitar"/>
                                <c:set var="s" value="${sound}"/>
                                <c:set var="f" value="${guitar.NUMBER_OF_FRETS}"/>
                                <c:set var="list" value="${guitar.fill(s, f)}"/>
                                <c:forEach items="${list}" var="cs">
                                    <td><hr><p class="test">${cs.toString()}</p></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td class="fretboard-head"></td>
                            <td class="fretboard-head"></td>
                            <c:forEach var = "i" begin = "1" end = "${guitar.NUMBER_OF_FRETS.toString()}">
                                <c:choose>
                                    <c:when test="${i == 3 || i == 5 || i == 7 || i == 9 || i == 15 || i == 17 || i == 19 || i == 21}">
                                        <td class="fretboard-head">
                                            <div class="dot" style="width: 7px; height: 7px;"></div>
                                        </td>
                                    </c:when>
                                    <c:when test="${i == 12 || i == 24}">
                                        <td class="fretboard-head" >
                                            <div class="dot" style="width: 7px; height: 7px; display: inline-block;"></div>
                                            <div class="dot" style="width: 7px; height: 7px; display: inline-block;"></div>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="fretboard-head"></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        </article>
    </section>
    <%@include file="footer.jsp"%>

    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>