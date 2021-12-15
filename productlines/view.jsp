<%@ page import="control.ProductLineDA" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductLine" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/13/2021
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Line Management</title>
    <style>
        button{
            border: none;width: 75px;height: 38px;box-shadow: 2px 2px 5px #8888;border-radius: 5px;color: white !important;
        }
    </style>
</head>
<body>
<header style="width: 100%;text-align: right;padding-right: 30px;">
    <a href="productlines/add.jsp" style="text-decoration: none;list-style-type: none"><button style="background-color: #41ce64">Add</button></a>
</header>
<h1 align="center">Product Line Management</h1>
<table border="1">
    <tr>
        <th>PL</th>
        <th>Text</th>
        <th>HTML</th>
        <th>Action</th>
    </tr>
    <%
        try {
            ArrayList<ProductLine> listProduct = (ArrayList<ProductLine>) request.getAttribute("listProduct");
            if(listProduct.isEmpty()) {
                System.out.println("NULL");
            } else {
                for (ProductLine productLine : listProduct) {%>
                    <tr>
                        <td><%=productLine.getProductLine()%></td>
                        <td><%=productLine.getTextDescription()%></td>
                        <td><%=productLine.getHtmlDescription()%></td>
                        <td width="12%">
                            <a href="productlines/edit.jsp?productLine=<%=productLine.getProductLine()%>"><button style="background-color: royalblue">Edit</button></a>
                            <a href="productlines/delete?productLineDelete=<%=productLine.getProductLine()%>" ><button onclick="return confirm('Are you sure?')" style="background-color: red">Delete</button></a>
                        </td>
                    </tr>

                    <% System.out.println("ProductLine: " + productLine.getProductLine() + "Text Des: "+ productLine.getTextDescription() + ", HTML Des : "+ productLine.getHtmlDescription());
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }%>

</table>
</body>
</html>
