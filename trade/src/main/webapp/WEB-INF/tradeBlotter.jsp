<!DOCTYPE html>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script src="js/jquery-1.11.0.min.js"></script>
<script language="javascript"> 

function access(){ 
   alert("method called"); 
   var status = ${trade.status};
   if(status == 'CANCELLED'){
       document.getElementById('modifyLink').display = none;
       document.getElementById('CancelLink').display = none;
   }
   else{
	   document.getElementById('modifyLink').display = block;
       document.getElementById('CancelLink').display = block;
   }
} 

</script>
</head>

<body onLoad="javascript:access()">
 <div class="container">
  <header>
   <h1>Trade blotter</h1>
  </header>
  <div>
  	<form:form modelAttribute="searchTrade" method="post" action="/search-trade">
                CounterParty : <form:input path="counterParty" type="text" class="form-control" />
                CurrencyPair : <form:select path="currencyPair" class="form-control" >
                					 <form:option  item="select" value="select" itemLabel="select"/>
                                    <form:options items="${currencyPairs}" itemValue="currencyPairName" itemLabel="currencyPairName"/>
                               </form:select>   
               <%--  Value Date : <form:input path="valueDate" type="text" id="datepicker"  class="form-control" /> --%>
                <button type="submit">Search</button>
            </form:form>
  </div>
  <div>
  </div>
  <c:if test="${userRole == 'admin'}">
	  <div align="right">
	  	<td><a id="upateMarketRate" href="<c:url value="/update-rate" />" >Edit Market Rate</a></td>
	  </div>
  </c:if>
  <div class="starter-template">
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>CounterParty</th>
     <th>CurrencyPair</th>
     <th>Rate</th>
     <th>Side</th>
     <th>Notional</th>
     <th>Value Date</th>
     <th>Market Rate</th>
     <th>Profit/Loss</th>
     <th>Status</th>
     <th>CancelDate</th>
     <th>CancelledBy</th>
    </tr>
    <c:forEach var="trade" items="${trades}">
     <tr>
      <td>${trade.counterParty}</td>
     <td>${trade.currencyPair}</td>
     <td>${trade.rate}</td>
     <td>${trade.side}</td>
     <td>${trade.notional}</td>
     <td>${trade.valueDate}</td>
     <td>${trade.marketRate}</td>
     <c:if test="${trade.status == 'ACTIVE'}">
     <td>${trade.profitLoss}</td>
     </c:if>
     <c:if test="${trade.status == 'CANCELLED'}">
     <td></td>
     </c:if>
      <td>${trade.status}</td>
      <td>${trade.cancelDate}</td>
      <td>${trade.userCancelled}</td>
      <!-- <td><a href="/">Modify</a></td> -->
      <c:if test="${trade.status == 'ACTIVE'}">
	      <td><a id="modifyLink" href="<c:url value="/update-trade/${trade.tradeId}" />" >Modify</a></td>
	      <!-- <td><button type="submit" id="">cancel</button></td> -->
	      <td><a id="CancelLink" href="<c:url value="/cancel-trade/${trade.tradeId}" />" >Cancel</a></td>
      </c:if>
     </tr>
    </c:forEach> 
   </table>
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>