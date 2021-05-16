Feature: Preference search history

  @Regression @PreferenceHistory @Smoke
  Scenario Outline: Validate the sorting order in preference history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then navigate to EOB preference history search screen
    And search for history between "<from date>" and "<end date>" to validate preference search history
    And validate the sorting options in preference history table

    Examples: 
      | test_id | sheetName                      |
      |      13 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @Regression @PreferenceHistory 
  Scenario Outline: Search previous 1 year button validation
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then navigate to EOB preference history search screen
    Then click on search pervious one year button and validate the results or "No Records found for the input criteria" message in preference history page
    Then click on back to member information page in preference history page

    Examples: 
      | test_id | sheetName                      |
      |      14 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @Regression @PreferenceHistory @Alert
  Scenario Outline: Error messages validation in preference history search screen.
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then navigate to EOB preference history search screen
    And serach with "<from date>" and "<end date>" then validate the "<error message>" in preference history page

    Examples: 
      | test_id | sheetName                      |
     # |      15 | Cmrcl_Mbr_Text_Mail_Email_Pref |
    #  |      16 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |      17 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |      18 | Cmrcl_Mbr_Text_Mail_Email_Pref |
