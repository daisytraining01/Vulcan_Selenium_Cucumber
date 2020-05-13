@FullSuite, @Regression, @Desalin
Feature: balance trasaction should be done successfully
  To Check application is allowing user to perform blance transfer between two account
	
	@smokeTest
  Scenario Outline: To Verify the Login with Valid Credentials
    Given User Launched "<URL>" in Browser
    And Application base page is displayed with Login Username and Password Fields
    When User enters Username : "<username>" , Password : "<password>"
    And Clicks on the submit button
    Then User Verifies the application is logged in successfully
    
    Examples: 
      | URL                                        | username | password   |
      | http://elastic.rapidtestpro.com:8086/index | labuser  | labuser@01 |

	
  Scenario Outline: To Verify balance transfer one account to another account
    Given User can navigate to home page
    And click on transfer tab
    And click on the between account under transfer tab
    And application balance transfer page is displayed with transfer from and transfer to and transfer ammount fields
    When User enters transfer to  : "<transferX>" , transfer from : "<transferY>", transfer ammount: "<balanceXY>"
    And Clicks on the submit button
    Then User Verifies the transaction is done  successfully
    Then user should on home page 
    And click on view accountdetails

    

    Examples: 
      | transferX | transferY | balanceXY |
      | Primary   | Savings   |      1000 |

        
