<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<html>
<head>
 <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<!--       <script src = "https://code.jquery.com/jquery-1.10.2.js"></script> -->
      <!-- <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> -->
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
         $(function() {
            $( "#datepicker" ).datepicker(
                    {
                    	format: 'dd/mm/yyyy',
                        showOn: "both",
                        buttonImage:"static/images/calender.jpg",
                        buttonImageOnly: true,
                        minDate: new Date()
                    });
         });
 </script>
 
 <script type="text/javascript">
	$(function(){
		$("#counterParty").autocomplete({
			source: "counter-party",
			minLength:2
		});
	});	
 
</script>
      
</head>
<div class="container">
 
    <div class="panel panel-primary">
        <div class="panel-heading">Trade Capture</div>
        <div class="panel-body">
        <font color="red">${message}</font>
            <form:form modelAttribute="tradeCapture" method="post" action="/trade-capture">
                CounterParty : <form:input path="counterParty" type="text" class="form-control" id="counterParty"/>
                <div id="showList"></div>
                CurrencyPair : <form:select path="currencyPair" class="form-control" >
                                    <form:options items="${currencyPairs}" itemValue="currencyPairName" itemLabel="currencyPairName"/>
                               </form:select>    
                Rate : <form:input path="rate" type="text" class="form-control"  />
                Side : <form:select path="side" class="form-control" >
                            <form:options items="${sides}" itemValue="name" itemLabel="name"/>
                       </form:select>
                Notional : <form:input path="notional" type="text" id="notional" onblur="validateNumericData()" class="form-control" />
                Value Date : <form:input path="valueDate" type="text" id="datepicker"  class="form-control" />
                <button type="submit">Submit</button>
            </form:form>
 
            <!-- <form method="post">
     <div>CounterParty : <input type="text" name="name" class="form-control" /></div> 
       <div> CurrencyPair : <input type="text" name="CurrencyPair"  class="form-control"  /> </div> 
     <div>  Rate : <input type="text" name="Rate"  class="form-control" /></div> 
     <div> Side : <input type="text" name="Side"  class="form-control" /></div>  
     <div> Notional : <input type="text" name="Notional" class="form-control"  /></div>  
     <div> Value date : <input type="text" name="date" class="form-control"  /></div>  
        <input type="submit"  />
   </form>  -->
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
</html>