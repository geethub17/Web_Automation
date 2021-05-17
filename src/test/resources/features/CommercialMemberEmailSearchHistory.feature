Feature: Commercial member email search history

  @Regression @CommercialMember @Smoke
  Scenario Outline: Validate the sorting order in email history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to email history page
    And search for history between "<from date>" and "<end date>" to validate email search history
    And validate the sorting options in email history table

    Examples: 
      | test_id | sheetName                      |
      |       2 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @Regression @CommercialMember @Alert
  Scenario Outline: Search previous 1 year button validation
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to email history page
    Then click on search pervious one year button and validate the results or "* No Records found" message
    Then click on back to member information page in email history page

    Examples: 
      | test_id | sheetName                      |
      |       3 | Cmrcl_Mbr_Text_Mail_Email_Pref |

  @Regression @CommercialMember @Alert
  Scenario Outline: Error messages validation in email history search screen.
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then navigate to email history page
    And serach with "<from date>" and "<end date>" then validate the "<error message>" in email history page

    Examples: 
      | test_id | sheetName                      |
      |       4 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |       5 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |       6 | Cmrcl_Mbr_Text_Mail_Email_Pref |
      |       7 | Cmrcl_Mbr_Text_Mail_Email_Pref |
