Feature: Consent or Do not call or Wrong number file page

  @Update @ConsentOrDncOrWn
  Scenario Outline: create a consent or do not call or wrong number file
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to consent or do not call or wrong number  page
    And click on add consent or do not call or wrong number file button
    And select header details by using "<Anthem call type>", "<Data type>" and "<Source name>"
    Then upload the "<Document>" in create a consent or do not call or wrong number file page
    And click on submit in create consent or do not call or wrong number file  page
    Then verify the message "File Upload Successful." in create a consent or do not call or wrong number file page
    And verify the latest record details in consent or do not call or wrong number file status page

    Examples: 
      | test_id | sheetName        |
      |       1 | ConsentOrDncOrWn |
      |       2 | ConsentOrDncOrWn |
      |       3 | ConsentOrDncOrWn |
      |       4 | ConsentOrDncOrWn |
      |       5 | ConsentOrDncOrWn |

  @Regression @Alert @ConsentOrDncOrWn @Alert
  Scenario Outline: Alert messages validation while trying to create consent or do not call or wrong number file without attaching document and not selecting header details
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to consent or do not call or wrong number  page
    And click on add consent or do not call or wrong number file button
    And click on submit in create consent or do not call or wrong number file  page
    Then validate the error message "This field may not be blank" in create consent or do not call or wrong number file page
    And click on reset button in create consent or do not call or wrong number file page
    And select header details by using "<Anthem call type>", "<Data type>" and "<Source name>"
    And click on submit in create consent or do not call or wrong number file  page
    Then validate the error message "Please select the file to upload" in create consent or do not call or wrong number file page
    And click on cancel button in create consent or do not call or wrong number file page and verify user navigated back to consent or do not call or wrong number file page

    Examples: 
      | test_id | sheetName        |
      |       6 | ConsentOrDncOrWn |
      |       7 | ConsentOrDncOrWn |
      |       8 | ConsentOrDncOrWn |
      |       9 | ConsentOrDncOrWn |
      |      10 | ConsentOrDncOrWn |

  @Regression @ConsentOrDncOrWn
  Scenario: Verify the sorting order in consent or do not call or wrong number file status page
    
    Login to the application

    Given Navigate to consent or do not call or wrong number  page
    And verify the sorting order in consent or do not call or wrong number file status page

  @Regression @ConsentOrDncOrWn @Alert
  Scenario Outline: create a consent or do not call or wrong number file with more than  20000 phone numbers
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to consent or do not call or wrong number  page
    And click on add consent or do not call or wrong number file button
    And select header details by using "<Anthem call type>", "<Data type>" and "<Source name>"
    Then upload the "<Document>" in create a consent or do not call or wrong number file page
    And click on submit in create consent or do not call or wrong number file  page
    Then verify the message "Please select the file to upload" in create a consent or do not call or wrong number file page

    Examples: 
      | test_id | sheetName        |
      |      11 | ConsentOrDncOrWn |
      |      12 | ConsentOrDncOrWn |
      |      13 | ConsentOrDncOrWn |
      |      14 | ConsentOrDncOrWn |
      |      15 | ConsentOrDncOrWn |
