<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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



<c:if test="${!empty listItems}">
    <h2>Items List</h2>
    <table>
        <tr>
            <td width="60">Name</td>
            <td width="200">description</td>
            <td width="60">color</td>
        </tr>
        <c:forEach items="${listItems}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.color}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Add a Book</h2>

<c:url var="addAction" value="/items/add"/>

<form:form action="${addAction}" commandName="item">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="id"/>
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="color">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="color"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">

                <c:if test="${empty item.name}">
                    <input type="submit"
                           value="<spring:message text="Add Item"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>