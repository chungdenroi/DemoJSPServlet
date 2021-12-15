<%@ page import="model.Payment" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/14/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Management</title>
    <style>
        button{
            border: none;width: 75px;height: 38px;box-shadow: 2px 2px 5px #8888;border-radius: 5px;color: white !important;
        }
    </style>
</head>
<body>
<header style="width: 100%;text-align: right;padding-right: 30px;">
    <a href="payments/add.jsp" style="text-decoration: none;list-style-type: none"><button style="background-color: #41ce64">Add</button></a>
</header>
<h1 align="center">Payment Management</h1>
<table border="1">
    <tr>
        <th>Customer Number</th>
        <th>Check Number</th>
        <th>Payment Date</th>
        <th>Amount</th>
        <th>Action</th>
    </tr>
    <%
        try {
            ArrayList<Payment> listPayment = (ArrayList<Payment>) request.getAttribute("listPayment");
            if(listPayment.isEmpty()) {
                System.out.println("NULL");
            } else {
                for (Payment payment : listPayment) {%>
    <tr>
        <td><%=payment.getCustomerNumber()%></td>
        <td><%=payment.getCheckNumber()%></td>
        <td><%=payment.getPaymentDate()%></td>
        <td><%=payment.getAmount()%></td>
        <td width="12%">
            <a href="payments/edit.jsp?customerNumber=<%=payment.getCustomerNumber()%>&checkNumber=<%=payment.getCheckNumber()%>"><button style="background-color: royalblue">Edit</button></a>
            <a href="payments/delete?customerNumber=<%=payment.getCustomerNumber()%>&checkNumber=<%=payment.getCheckNumber()%>" ><button onclick="return confirm('Are you sure?')" style="background-color: red">Delete</button></a>
        </td>
    </tr>
    <%}}
    } catch (NullPointerException e){
        System.out.println(e.getMessage());
    }%>

</table>
</body>
</html>

