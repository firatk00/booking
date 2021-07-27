<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Du er logget på som Admin
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        Her er en liste med alle Udstyr:
        <table class="table table-striped">
            <form action="bookitem" method="post">
                <c:forEach var="item" items="${requestScope.itemsList}">
                <tr>
                    <td><input type="radio" name="bookitem" value="${item.id}"></td>
                    <td>${item.id}</td>
                    <td>${item.udstyr}</td>
                    <td>${item.roomId}</td>
                    <td>${item.type}</td>
                </tr>

            </c:forEach>

        </table>
        <input type="submit" value="Book Item">
            </form>
    </jsp:body>

</t:genericpage>

