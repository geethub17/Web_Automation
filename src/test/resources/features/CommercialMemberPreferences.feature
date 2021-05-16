Feature: Commercial member preferences

  @updatePreferences
  Scenario Outline: Update and validate the member information and staying healthy plans in member preference tab
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then update the Explanation of Benefits (EOBs) section with "<mail>" or "<email>" and validate in preference tab
    Then navigate to EOB preference history search screen
    And validate the updated details "<contactChannel>", "<contactValue>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>" and "<updatedDate>" in prefernce history search screen
    Then click on back to member information page in preference history page
    Then click on preference tab in member information page
    Then update the Status Updates (Optional) section with "<email>" or "<text>" and validate in preference tab
    Then navigate to status update preference history search screen
    And validate the updated details "<contactChannel>", "<contactValue>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>" and "<updatedDate>" in prefernce history search screen
    Then click on back to member information page in preference history page
    Then click on preference tab in member information page
    Then update the preventative care reminders section with "<mail>" or "<phone>" and validate in preference tab
    Then navigate to preventative care preference history search screen
    And validate the updated details "<contactChannel>", "<contactValue>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>" and "<updatedDate>" in prefernce history search screen
    Then click on back to member information page in preference history page
    Then click on preference tab in member information page
    Then update the health and wellness information section with "<email>" or "<text>" and validate in preference tab
    Then navigate to health and wellness information preference history search screen
    And validate the updated details "<contactChannel>", "<contactValue>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>" and "<updatedDate>" in prefernce history search screen
    Then click on back to member information page in preference history page
    Then click on preference tab in member information page
    And click on clear selection and see email and text options are deselected in status update section

    Examples: 
      | test_id | sheetName                      |
      |       8 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |       9 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @updateAllPreferencesWellnessPrograms
  Scenario Outline: Update and validate all the preference options under Health and Wellness Programs and Discounts (Optional) section
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then update the health and wellness programs section with "<email>", "<mail>" , "<phone>" and "<text	>" and validate the details in preference history page

    Examples: 
      | test_id | sheetName                      |
      |      10 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |      11 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @updateLanguage
  Scenario Outline: Validate language update, reset and error messages in member preference tab
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    And select the "<spokenLanguage>" and "<writtenLanguage>" in member preference tab
    Then click on reset button in member preference tab
    And validate the language options are reset to old options
    Then click on submit in member preference tab
    And validate the "<errorMessage>" in member preference tab
    And select the "<spokenLanguage>" and "<writtenLanguage>" in member preference tab
    Then click on submit in member preference tab
    And validate the updated language preferences in member preference tab.

    Examples: 
      | test_id | sheetName                      |
      |      12 | Cmrcl_Mbr_Text_Mail_Email_Pref |
