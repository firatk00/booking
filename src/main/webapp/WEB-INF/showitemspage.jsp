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
        <h1>Hello ${sessionScope.email} </h1>
        Her er en liste med alle studernde:
        <table class="table table-striped">
            <c:forEach var="item" items="${requestScope.itemsList}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.udstyr}</td>
                    <td>${item.roomId}</td>
                    <td>${item.type}</td>
                </tr>

            </c:forEach>

        </table>

    </jsp:body>

</t:genericpage>

