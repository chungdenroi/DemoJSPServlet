<%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/15/2021
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product Line Management</title>
</head>
<body>
    <center>
        <h1 align="center">Product Line Management JSTL</h1>
        <table border="1">
            <tr>
                <th>PL</th>
                <th>Text</th>
                <th>HTML</th>
                <th>Action</th>
            </tr>
            <c:forEach var="productLine" items="${listPayment}">
                <tr>
                    <td>${productLine.getProductLine()}</td>
                    <td>${productLine.getTextDescription()}</td>
                    <td><${productLine.getHtmlDescription()}</td>
                    <td width="12%">
                        <a href="productlines/edit.jsp?productLine=<${productLine.getProductLine()}"><button style="background-color: royalblue">Edit</button></a>
                        <a href="productlines/delete?productLineDelete=${productLine.getProductLine()}" ><button onclick="return confirm('Are you sure?')" style="background-color: red">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
