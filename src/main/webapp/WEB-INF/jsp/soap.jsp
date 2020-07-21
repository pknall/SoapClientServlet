<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="message" scope="request" class="java.lang.String" />
<jsp:useBean id="referenceName" scope="request" class="java.lang.String" />
<jsp:useBean id="value" scope="request" class="java.lang.String" />
<jsp:useBean id="username" scope="request" class="java.lang.String" />
<jsp:useBean id="password" scope="request" class="java.lang.String" />

<html>
<head>
    <title>Soap Test Form</title>
</head>
<body>
<h1>Soap Fields</h1>

<form action="soap">
    <table>
        <tr><td>Reference Name:</td><td><input type="text" name="referenceName" value="<%=referenceName%>" size="100" /></td></tr>
        <tr><td>Value:</td><td><input type="text" name="value" value="<%=value%>" size="100"/></td></tr>
        <tr><td>Username:</td><td><input type="text" name="username" value="<%=username%>" size="25"/></td></tr>
        <tr><td>Password:</td><td><input type="text" name="password" value="<%=password%>" size="25" /></td></tr>
        <tr><td><input type="submit" value="Submit" /></td><td><input type="reset" value="Reset" /></td></tr>
    </table>
</form>

<%=message%>
</body>
</html>
