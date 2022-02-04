<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${errorMessage}</font>
    <form method="post">
        CounterParty : <input type="text" name="name" />
        CurrencyPair : <input type="text" name="CurrencyPair" /> 
        Rate : <input type="text" name="Rate" />
        Side : <input type="text" name="Side" />
        Notional : <input type="text" name="Notional" />
        Value date : <input type="text" name="date" />
        <input type="submit" />
    </form>
</body>
</html>