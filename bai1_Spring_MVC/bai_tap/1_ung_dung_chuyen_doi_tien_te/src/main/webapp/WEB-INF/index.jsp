<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 10/26/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="/convert" method="post">
    <label for="rate">Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="23000" id="rate" readonly/><br/>
    <label for="usd">USD: </label><br/>
    <input type="number" min="0" name="usd" id="usd" placeholder="0"/><br/>
    <input type="submit" id="submit" value="convert"/>
  </form>
  </body>
</html>
