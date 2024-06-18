Feature: Login feature

@test
Scenario: Login scenario with valid credentails - Correct Username and Password
	When User enters username as "test-Username"
	When User enters password as "secret_sauce"
	When User click on the login button
	Then User should be on the homepage
	When User clicks on menuButton
	And  User clicks on logout button
	Then User should be on the homepage
	

 Scenario: Login with invalid user name
   When I enter username as "123test-Username"
   And I enter password as "secret_sauce" and click on login button
   Then login should fail with an error
   
 Scenario: Login with invalid password
  # When I enter username as "test-Username"
   #And I enter password as "123test-Username"
   #And I login
   #Then login should fail with an error
