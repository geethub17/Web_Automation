Feature: Phone search history

  @Regression @PhoneSearchHistory @Update
  Scenario Outline: Valiate the latest updated details in phone history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    And update and validate the phone number non-sales preference with "<value1>" and "<value2>" details
    Then navigate to phone history screen
    Then verify the updated details in phone history table

    Examples: 
      | test_id | sheetName          |
      |       1 | PhoneSearchHistory |
      |       2 | PhoneSearchHistory |
      |       3 | PhoneSearchHistory |
      |       4 | PhoneSearchHistory |
      |       5 | PhoneSearchHistory |
      |       6 | PhoneSearchHistory |

  @Regression @PhoneSearchHistory @Smoke
  Scenario Outline: Validate the sorting order in phone history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    Then navigate to phone history screen
    And search for history between "<from date>" and "<end date>" to validate search history
    And validate the sorting options in history table

    Examples: 
      | test_id | sheetName          |
      |       7 | PhoneSearchHistory |

  @Regression @PhoneSearchHistory @Alert
  Scenario Outline: Search previous 3 months button validation
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    Then navigate to phone history screen
    Then click on search three months pervious button and validate the results or "*No Records found" message
    Then navigate back to phone search results screen

    Examples: 
      | test_id | sheetName          |
      |       8 | PhoneSearchHistory |

  @Regression @PhoneSearchHistory @Alert
  Scenario Outline: Error messages validation in phone history search screen.
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    Then navigate to phone history screen
    And serach with "<from date>" and "<end date>" then validate the "<error message>"

    Examples: 
      | test_id | sheetName          |
      |       9 | PhoneSearchHistory |
      |      10 | PhoneSearchHistory |
      |      11 | PhoneSearchHistory |
      |      12 | PhoneSearchHistory |
