<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo side for Admin
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Du er nu logget på som Admin.

        <a href="${pageContext.request.contextPath}/fc/showstudents"> Vis alle studerende </a>

        <h1>Hello ${sessionScope.email} </h1>
        Vis/Book Udstyr

        <a href="${pageContext.request.contextPath}/fc/showitems"> Vis alle items </a>
    </jsp:body>
</t:genericpage>
