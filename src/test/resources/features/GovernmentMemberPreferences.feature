Feature: Commercial member preferences

  @Regression @GovernmentMember @Update
  Scenario Outline: Updated and validate the member information and staying healthy plans in member preference tab
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then click on preference tab in member information page
    Then update the Helpful information section with "<email>" or "<text>" and validate in preference tab
    Then navigate to helpful information preference history search screen
    And validate the updated details "<contactChannel>", "<contactValue>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>" and "<updatedDate>" in prefernce history search screen for government member
    Then click on back to member information page in preference history page for government member
    Then click on preference tab in member information page
    And click on clear selection in helpful selection and see email and text options are deselected in status update section

    Examples: 
      | test_id | sheetName                     |
      |       8 | Govt_Mbr_Text_Mail_Email_Pref |
      |       9 | Govt_Mbr_Text_Mail_Email_Pref |
