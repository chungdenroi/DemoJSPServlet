<%@ page import="control.ProductLineDA" %>
<%@ page import="model.ProductLine" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/13/2021
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <style>
        button{
            border: none;width: 75px;height: 38px;box-shadow: 2px 2px 5px #8888;border-radius: 5px;color: white !important;
        }
    </style>
</head>
<body>
    <h1 align="center">Edit Product Line</h1>
    <center>
        <%
            String pline = request.getParameter("productLine");
            ProductLineDA productLineDA = new ProductLineDA();
        %>
        <form action="edit" method="post">
            <table border="1" style="text-align: center">
                <tr>
                    <td>Product Line: </td>
                    <td> <input type="text" value="<%=productLineDA.selectProductLine(pline).getProductLine()%>" name="productline" readonly> </td>
                </tr>
                <tr>
                    <td>Text description: </td>
                    <td><input type="text" value="<%=productLineDA.selectProductLine(pline).getTextDescription()%>"  name="textdescription"  ></td>
                </tr>
                <tr>
                    <td>HTML description: </td>
                    <td><input type="text" value="<%=productLineDA.selectProductLine(pline).getHtmlDescription()%>" name="htmldescription" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="reset" value="Reset" ></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
