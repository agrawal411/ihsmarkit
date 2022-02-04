<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<div class="container">
 
    <div class="panel panel-primary">
        <div class="panel-heading">Update Trade</div>
        <div class="panel-body">
            <form:form modelAttribute="CurrencyPair" method="post" action="/update-market-rate">
                CurrencyPair : <form:select path="currencyPairName" class="form-control" >
                                    <form:options items="${CurrencyPairs}" itemValue="currencyPairName" itemLabel="currencyPairName"/>
                               </form:select>    
                Rate : <form:input path="rate" type="text" class="form-control" />
                <button type="submit">Submit</button>
            </form:form>
 
        </div>
    </div>
</div>
</html>