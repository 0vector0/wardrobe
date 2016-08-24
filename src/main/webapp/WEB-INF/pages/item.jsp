<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Items List</title>
    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<h2>Items List</h2>

<%--<c:if test="${not empty itemsList}">--%>

<ul>
    <table>
        <tr>
            <td>Name</td>
            <td>description</td>
            <td>color</td>
        </tr>
        <c:forEach items="${itemsList}" var="item">
            <%--<li>${item}</li>--%>
            <tr>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.color}</td>
            </tr>
        </c:forEach>
    </table>
</ul>

<%--</c:if>--%>
</body>
</html>