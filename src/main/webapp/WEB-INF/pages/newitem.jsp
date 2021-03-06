<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Item</title>
    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<h2>Add Item</h2>

<%--<c:if test="${not empty itemsList}">--%>

<form:form method="POST" action="/addItem">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><form:label path="size">size</form:label></td>
            <td><form:input path="size"/></td>
        </tr>

        <tr>
            <td><form:label path="color">color</form:label></td>
            <td><form:input path="color"/></td>
        </tr>
        <tr>
            <td><form:label path="price">price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<%--</c:if>--%>
</body>
</html>