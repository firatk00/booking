<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Side for Student
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Du er nu logget ind som Student.
        Role: ${sessionScope.role}

        Vis/Book Udstyr

        <a href="${pageContext.request.contextPath}/fc/showitemsforstudent"> Vis alle items </a>
    </jsp:body>
</t:genericpage>

