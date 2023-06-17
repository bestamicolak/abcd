#(Image Base Approach)
#I used "Sikuli" image base approach for automation of the test
#I added a method to the utilities. I interact with the web Element by using their images
#Because there is a "Canvas" in the "DOM" structure which does not let me interact with the Web Element
#(IMORTANT) Pls do not move the mouse or do not change the test screen while testing. Otherwise "Sikuli" gives error
Feature: University of Exeter Web Page
  @smoke
  Scenario: Happy path
    Given user types the web link as "https://m.exeter.ac.uk/"
    When the user clicks on privacy policy
    And user comes back to previous tab and clicks on accept button and clicks on accept terms and conditions
    And user clicks on data Data Protection and Privacy Policy
    And user clicks the back button
    And user clicks on accept terms and continue check box and clicks on University of Exeter email button
    And user clicks on AzureAD button
    Then user verifies the "Sign in" title







