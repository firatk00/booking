<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        Her er en liste med alle Udstyr:
        <table class="table table-striped">
            <c:forEach var="item" items="${requestScope.getAllItems}">
                <tr>
                    <td>${itemDTO.id}</td>
                    <td>${itemDTO.udstyr}</td>
                    <td>${itemDTO.roomId}</td>
                    <td>${itemDTO.type}</td>
                </tr>

            </c:forEach>

        </table>

    </jsp:body>

</t:genericpage>

