Feature: Government member contact information

  @Regression @GovernmentMember @Smoke
  Scenario Outline: Validate the member and email details in government member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then validate the member details "<firstName>" , "<lastName>" , "<dob>", "<seqNumber>", "<groupNumber>" , "<sourceSystem>", "<preferredEmail>", "<preferredMailingAddress>", "<preferredTelephone>" and "<preferredText>" in member contact information page
    And validate the email details "<type>", "<manualConfirmation>", "<emailAddress>", "<updatedBy>", "<updatedDateTimeStamp>", "<sourceChannel>", "<sourceOrigin>" in government member email section in member contact information page
    Then navigate to government email history page
    And search for the specific dates "<fromDate>", "<endDate>" in government email history page
    And verify the email details in government email history page

    Examples: 
      | test_id | sheetName                 |
      |       1 | GovtMemberContactInfEmail |

  @Regression @GovernmentMember @Update
  Scenario Outline: Update the email address in government member contact information page and verify in government email history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And enter the new "<emailAddress>" and click on reset and verify in government member contact information page
    And update and validate the "<emailAddress>" in government member contact information page
    Then navigate to government email history page
    And verify the updated email details in government email history page
    Then click on back to member information page in government email history page

    Examples: 
      | test_id | sheetName                 |
      |       2 | GovtMemberContactInfEmail |

  @Regression @GovernmentMember
  Scenario Outline: Validate the member phone number details in government member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And verify the phone number details "<phoneNumber>", "<value1>", "<value2>", "<updatedBy>", "<updatedDate>" in government member contact information page
    Then navigate to government phone history page
    And search for the specific dates "<fromDate>", "<endDate>" in phone history page
    And verify the existing details "<telephoneNumber>", "<sales>", "<nonSales>", "<updatedBy>", "<updatedDate>" in government member phone history page 

    Examples: 
      | test_id | sheetName                 |
      |       1 | GovtMemberContactInfPhone |

  @Regression @GovernmentMember @Update
  Scenario Outline: Update the mobile preferences in government member contact information page and verify in phone history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And update and validate the phone number non-sales preference with "<value1>" and "<value2>" details in government member contact information page
    And if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled in government member contact information page
    Then navigate to government phone history page
    And verify the updated details in phone history table through government member information page

    Examples: 
      | test_id | sheetName                 |
      |       2 | GovtMemberContactInfPhone |
      |       3 | GovtMemberContactInfPhone |

  @Regression @GovernmentMember
  Scenario Outline: Validate the member text number details in government member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And validate the member text number details "<preferred>", "<phoneNumber>", "<sourceChannel>",  "<sourceOrigin>", "<updatedBy>", "<updatedDate>"  in government member contact information page

    Examples: 
      | test_id | sheetName                     |
      |       1 | Govt_Mbr_Text_Mail_Email_Pref |
