<%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/14/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <style type="text/css">
        a{list-style-type: none;text-decoration: none;color: white}
        .btn{float: left}
        button{
            border: none;width: 75px;height: 38px;box-shadow: 2px 2px 5px #8888;border-radius: 5px;color: white !important;
        }
    </style>
</head>
<body>
    <center >
        <fieldset>
            <h1>Dashboard</h1>
            <table cellpadding="10px">
                <tr>
                    <td class="btn"><a href="productlines"><button style="background-color: royalblue">Products</button></a></td>
                    <td class="btn"><a href="payments"><button style="background-color: red">Payments</button></a></td>
                </tr>
            </table>
        </fieldset>
    </center>
</body>
</html>
