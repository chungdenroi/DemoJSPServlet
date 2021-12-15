<%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/15/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Payment</title>
</head>
<body>
<center>
    <h1>Add Product</h1>
    <form action="add" method="post">
        <table border="1" style="text-align: center">
            <tr>
                <td>Customer Number: </td>
                <td> <input type="text"  name="customerNumber" required> </td>
            </tr>
            <tr>
                <td>Check Number: </td>
                <td><input type="text"   name="checkNumber"  required></td>
            </tr>
            <tr>
                <td>Payment Date: </td>
                <td><input type="text" name="paymentDate" ></td>
            </tr>
            <tr>
                <td>Amount: </td>
                <td><input type="text" name="amount" ></td>
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
