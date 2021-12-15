<%@ page import="model.Payment" %>
<%@ page import="control.PaymentDA" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/15/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Payment</title>
    <style>
        button{
            border: none;width: 75px;height: 38px;box-shadow: 2px 2px 5px #8888;border-radius: 5px;color: white !important;
        }
    </style>
</head>
<body>
<h1 align="center">Edit Payment</h1>
<center>
    <%
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        String checkNumber = request.getParameter("checkNumber");
        PaymentDA paymentDA = new PaymentDA();
    %>
    <form action="edit" method="post">
        <table border="1" style="text-align: center">
            <tr>
                <td>Customer Number: </td>
                <td> <input type="text" value="<%=customerNumber%>" name="customerNumber" readonly> </td>
            </tr>
            <tr>
                <td>Check Number: </td>
                <td><input type="text" value="<%=checkNumber%>"  name="checkNumber"  readonly></td>
            </tr>
            <tr>
                <td>Payment Date: </td>
                <td><input type="text" value="<%=paymentDA.searchPayment(customerNumber,checkNumber).getPaymentDate()%>" name="paymentDate" ></td>
            </tr>
            <tr>
                <td>Amount: </td>
                <td><input type="text" value="<%=paymentDA.searchPayment(customerNumber,checkNumber).getAmount()%>" name="amount" ></td>
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
