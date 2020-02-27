Feature:LoginSystemScenarios
  @LoginTest
  Scenario Outline: SuccessLogin

    Given user is on HomePage
    When user click Login button
    And user enter email "<email>" and enter  password "<password>"
    And click GirisYap button
    Then check user is login with "<email>"
    And user click every each Tab Buttons and user check every each tabs images loaded






    Examples:
      | email                 | password     |filter|
      | seleniumautomation987123@gmail.com | password123 |Kategori|
