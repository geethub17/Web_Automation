Feature: Phone number scrub

  @PhoneNumberScrub @Update
  Scenario Outline: create a scrub file
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to phone number scrub page
    And click on add scrub file button
    And select header details by using "<Scrub file type>" , "<Anthem call type>" and program name
    Then upload the "<Document>"
    And click on submit in create scrub file page
    Then verify the success message "File Upload Successful." in scrubbing status page
    And verify the latest record details in scrubbing status page

    Examples: 
      | test_id | sheetName        |
      |       1 | PhoneNumberScrub |
      |       2 | PhoneNumberScrub |
      |       3 | PhoneNumberScrub |

  @Regression @PhoneNumberScrub @Smoke @Alert
  Scenario Outline: Alert messages validation while trying to create scrub file without attaching document and program type
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to phone number scrub page
    And click on add scrub file button
    And select header details by using "<Scrub file type>" , "<Anthem call type>" and program name
    And click on submit in create scrub file page
    Then validate the error message "Please select the file to upload"
    And click on reset button in create scrub file page
    And click on submit in create scrub file page
    Then validate the error message "This field may not be blank"
    And click on cancel button in create scrub file page and verify user navigated back to scrubbing status page

    Examples: 
      | test_id | sheetName        |
      |       1 | PhoneNumberScrub |
      |       2 | PhoneNumberScrub |
      |       3 | PhoneNumberScrub |

  @Regression @PhoneNumberScrub
  Scenario: Verify the sorting order in scrubbing status page
    
    Login to the application

    Given Navigate to phone number scrub page
    And verify the sorting order in scrubbing status page
