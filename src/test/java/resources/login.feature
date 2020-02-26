Feature:Login

  Scenario Outline: LoginCases

    When user is on HomePage
    When user click Login button
    And user enter email "<email>" and enter  password "<password>"
    And click GirisYap button
    Then user click Tab Buttons and user check images loaded


    Examples:
      | email                 | password     |
      | tugcekurt06@gmail.com | password1234 |
