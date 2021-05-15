Feature: Phone search

  @Regression @Smoke @PhoneSearch @Alert
  Scenario Outline: Perform a phone number search with invalid phone number
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    And validate the error message "Please enter a valid 10 - digit Phone Number" in phone search screen

    Examples: 
      | test_id | sheetName   |
      |       1 | PhoneSearch |
      |       2 | PhoneSearch |
      |       3 | PhoneSearch |

  Scenario Outline: Update and validate the phone number preferences
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    And update and validate the phone number non-sales preference with "<value1>" and "<value2>" details
    And if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled

    Examples: 
      | test_id | sheetName   |
      |       4 | PhoneSearch |
      |       5 | PhoneSearch |
      |       6 | PhoneSearch |
      |       7 | PhoneSearch |
      |       8 | PhoneSearch |
      |       9 | PhoneSearch |

  @PhoneSearch @Regression @Alert
  Scenario Outline: Unauthorized alert validation
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    And update the non-sales preference value from wrong number to "<value1>" if the last updated by is MARPLTN
    Then validate the unauthorized error message "User not authorized to update this phone number. Notice is being sent to the TCPA Compliance Help Desk for resolution."

    Examples: 
      | test_id | sheetName   |
      |      10 | PhoneSearch |
      |      11 | PhoneSearch |

  @PhoneSearch @Regression 
  Scenario Outline: Reset the parameters in phone search screen
    
        Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given enter the "<phone number>" and search for it
    And change the preferences of sales and non-sales values and then reset & verify the changes.

    Examples: 
      | test_id | sheetName   |
      |      12 | PhoneSearch |
