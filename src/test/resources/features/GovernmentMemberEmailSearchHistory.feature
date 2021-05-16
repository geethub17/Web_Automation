Feature: Email search history

  @Regression @GovernmentMember @Smoke
  Scenario Outline: Validate the sorting order in government email history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to government email history page
    And search for the specific dates "<fromDate>", "<endDate>" in government email history page
    And validate the sorting options in government email history table

    Examples: 
      | test_id | sheetName                      |
      |       2 | Govt_Mbr_Text_Mail_Email_Pref |

  @Regression @GovernmentMember 
  Scenario Outline: Search previous 1 year button validation in government email history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to government email history page
    Then click on search pervious six months button and validate the results or "* No Records found" message in government email history page
    Then click on back to member information page in government email history page

    Examples: 
      | test_id | sheetName                      |
      |       3 | Govt_Mbr_Text_Mail_Email_Pref |

  @Regression @GovernmentMember @Alert
  Scenario Outline: Error messages validation in government email history search screen.
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to government email history page
    And serach with "<from date>" and "<end date>" then validate the "<error message>" in government email history page

    Examples: 
      | test_id | sheetName                      |
      |       4 | Govt_Mbr_Text_Mail_Email_Pref |
      |       5 | Govt_Mbr_Text_Mail_Email_Pref |
      |       6 | Govt_Mbr_Text_Mail_Email_Pref |
      |       7 | Govt_Mbr_Text_Mail_Email_Pref |
