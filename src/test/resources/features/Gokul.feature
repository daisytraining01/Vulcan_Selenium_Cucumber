@FullSuite 
Feature: Tech_Fish_Bank Applicatin schedule appointment 

@smokeTest, @Regression
Scenario Outline: To Verify user can schedule appaintment 
	Given user launched "<url>" in browser 
	Then user should login with valid "<userName>","<password>" and clickon submit button on login page 
	And user should click on appointment button 
	Then application base page is displayed with pick a date and time,location and notes on the page 
	When user select date and time "<location>" and "<notes>" in appointment page 
	And user clicks on the submit scheduling button and confirm appointment 
	Then user should logout the application
	
	Examples: 
		| url                                    | userName|password| location   |notes|
		| http://elastic.rapidtestpro.com:8086/index | labuser    | labuser@01 |Turku|Appointment|
		

