Feature: To Someone else
  To Check application is allowing user to transfer amount to someone else account

  @smokeTest, @Regression
  Scenario Outline: To Verify transfer of amount to another account
    Given User Launched "<url>" in Browser
    When User enters Username : "<username>" , Password : "<password>"
    And Clicks on the submit button
    Then User Verifies the application is logged in successfully
    And User clicks on To some Else tab under Transfer menu
    And Application base page is displayed with the fields Recipient details, Account Type, Amount field
    When User selects the  Receipient, Account Type , enters "<Amount>"
    And Clicks on Transter button
    Then Amount should be debited from the Account

    Examples: 
      | url                                        | username | password   | Amount |
      | http://elastic.rapidtestpro.com:8086/index | labuser  | labuser@01 |     50 |
