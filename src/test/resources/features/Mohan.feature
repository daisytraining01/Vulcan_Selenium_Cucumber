@FullSuite, @Mohan
Feature: Datatable Verification
  To Check after every transaction that the correct account has been transfered

  @smokeTest, @Regression
  Scenario Outline: To veriy the last transaction
    Given User is loggedin to the application with the  "<url>" , "<username>" and "<password>" in Browser
    And A fund transer of rs "<amount>" has been done betweeb the same account
    When The user opens the statement page
    And The Statement is sorted for the last Done transaction
    Then User verifies that the last transaction "<amount>"
    And Logs out of the application

    Examples: 
      | url                                        | username | password   | amount |
      | http://elastic.rapidtestpro.com:8086/index | labuser  | labuser@01 |     15 |

  @Regression
  Scenario Outline: To verify statement that the correct value has been reduced / added, from / to the account
    Given User is loggedin to the application with the  "<url>" , "<username>" and "<password>" in Browser
    When The user opens the statement page
    And The Statement is sorted for the last Done transaction
    Then User verifies last transaction amount and the balance
    And Logs out of the application

    Examples: 
      | url                                        | username | password   |
      | http://elastic.rapidtestpro.com:8086/index | labuser  | labuser@01 |
