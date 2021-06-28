Feature: Member search

  @Regression @MemberSearch @Smoke
  Scenario Outline: Search the member by using wildcard search
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the first name "<firstNameType>" and last name "<lastNameType>" value from dropdown
    Then search for the member by using "<firstName>" , "<lastName>" , "<dob>", "<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    And click on search in member search page
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"

    Examples: 
      | test_id | sheetName    |
      |       1 | MemberSearch |
      |       2 | MemberSearch |
      |       3 | MemberSearch |
      |       4 | MemberSearch |

  @Regression @MemberSearch @Smoke
  Scenario Outline: Search the member by using subscriber id
      
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    And click on search in member search page

    Examples: 
      | test_id | sheetName    |
      |       5 | MemberSearch |
      |       6 | MemberSearch |
      |       7 | MemberSearch |
      |       8 | MemberSearch |

  @Regression @MemberSearch
  Scenario Outline: Validate the sorting order in member search results table
      
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    And click on search in member search page
    And validate the sorting order in member search results table

    Examples: 
      | test_id | sheetName    |
      |       9 | MemberSearch |

  @Regression @MemberSearch @Alert
  Scenario: Validate the error messages for member name search
    
    Login to the application

    Given Navigate to member search page
    And click on search in member search page
    And validate the error message "First Name - This field is required." in member search page
    And validate the error message "First Name - Length must be between 3 and 15 characters long." in member search page
    And validate the error message "Last Name - This field is required." in member search page
    And validate the error message "Last Name - Length must be between 3 and 15 characters long." in member search page

  @Regression @MemberSearch @Alert
  Scenario: Validate the error messages for member name search
    
    Login to the application

    Given Navigate to member search page
    And select search by subscriber id option
    And click on search in member search page
    And validate the error message "Subscriber ID - This field is required." in member search page
