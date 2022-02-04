<%@ include file="common/header.jspf"%>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
 rel="stylesheet">
 <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <!-- <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> -->
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
         $(function() {
            $( "#datepicker" ).datepicker(
                    {
                        showOn: "both",
                        buttonImage:"static/images/calender.jpg",
                        buttonImageOnly: true,
                        minDate: new Date()
                    });
         });
      </script>
</head>
<div class="container">
 
    <div class="panel panel-primary">
        <div class="panel-heading">Update Trade</div>
        <div class="panel-body">
        <font color="red">${message}</font>
            <form:form modelAttribute="tradeBlotter" method="post" action="/update-trade-capture">
                CounterParty : <form:input path="counterParty" type="text" class="form-control" />
                CurrencyPair : <form:select path="currencyPair" class="form-control" >
                                    <form:options items="${currencyPairs}" itemValue="currencyPairName" itemLabel="currencyPairName"/>
                               </form:select>    
                Rate : <form:input path="rate" type="text" class="form-control"  />
                Side : <form:select path="side" class="form-control" >
                            <form:options items="${sides}" itemValue="name" itemLabel="name"/>
                       </form:select>
                Notional : <form:input path="notional" type="text" id="notional" onblur="validateNumericData()" class="form-control" />
                Value Date : <form:input path="valueDate" type="text" id="datepicker"  class="form-control" />
                <form:hidden path="tradeId"/>
                <form:hidden path="userId"/>
                <form:hidden path="status"/>
                <button type="submit">Submit</button>
            </form:form>
 
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
</html>