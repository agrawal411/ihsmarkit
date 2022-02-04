# ihsmarkit # Trade Application

Two applications and start 1 activemq server
a. Trade
b.TradeBlotter
Steps to run Trade Application
1. Open TradeApplication.java
2. right click on trade application in project explorer , select run--> run as java application
 
To run TradeBlotter Apllication
1. open TradeBlotterApplication.java
2. right click Anywhere on that class area and run as --> java app
 
Download active mq 5.16.3 and go to its bin folder then win64 folder -> click on Wrapper.exe 
 
login URL
http://localhost:8082/login

Normal User login :  username - test,  password - test
Admin user login :   username - ankit, password - ankit

TRADE CAPTURE Database URL :http://localhost:8082/h2-console/
jdbc url=jdbc:h2:mem:testdb
password=password
 
TRADE BLOTTER Database URL :http://localhost:8083/h2-console	
jdbc url=jdbc:h2:mem:tradeblotter
password=password
