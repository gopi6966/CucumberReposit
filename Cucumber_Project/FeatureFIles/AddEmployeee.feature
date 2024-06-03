Feature: 
  As a Admin i want to add new Employee

  Scenario Outline: 
    Verify employee creation with multiple data

    Given user navigates url in a browser
    When user logs in username as "Admin" and password as "Qedge123!@#"
    When user clicks login button
    When user click pim and clicks add button
    When user enter firstname "<Fname>"
    When user enter middlename "<Mname>"
    When user enter lastname "<Lname>"
    When user capture employee id before adding
    When user click save button
    When user capture employee id After adding
    Then user validates employee id
    Then user close browser

    Examples: 
      | Fname     | Mname     | Lname    |
      | Akhilesh1 | Selenium1 | Testing1 |
      | Akhilesh2 | Selenium2 | Testing2 |
      | Akhilesh3 | Selenium3 | Testing3 |
      | Akhilesh4 | Selenium4 | Testing4 |
      | Akhilesh5 | Selenium5 | Testing5 |
      | Akhilesh6 | Selenium6 | Testing6 |
