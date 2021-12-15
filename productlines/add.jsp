<%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/15/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Lines</title>
</head>
<body>
    <center>
        <h1>Add Product</h1>
        <form action="add" method="post">
            <table border="1" style="text-align: center">
                <tr>
                    <td>Product Line: </td>
                    <td> <input type="text"  name="productline" required> </td>
                </tr>
                <tr>
                    <td>Text description: </td>
                    <td><input type="text"   name="textdescription"  ></td>
                </tr>
                <tr>
                    <td>HTML description: </td>
                    <td><input type="text" name="htmldescription" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add"></td>
                    <td><input type="reset" value="Reset" ></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
