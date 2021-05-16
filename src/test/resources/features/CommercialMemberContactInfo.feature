Feature: Commercial member contact information

  @Regression @CommercialMember @Smoke
  Scenario Outline: Validate the member and email details in commercial member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    Then validate the member details "<firstName>" , "<lastName>" , "<dob>", "<seqNumber>", "<groupNumber>" , "<sourceSystem>", "<preferredEmail>", "<preferredMailingAddress>", "<preferredTelephone>" and "<preferredText>" in member contact information page
    And validate the email details "<preferredValue>", "<emailAddress>", "<emailStatus>", "<sourceChannel>", "<sourceOrigin>", "<updatedBy>", "<updatedDateTimeStamp>" in member email section in member contact information page
    Then navigate to email history page
    And search for the specific dates "<fromDate>", "<endDate>" in email history page
    And verify the email details in email history page

    Examples: 
      | test_id | sheetName                       |
      |       1 | CommercialMemberContactInfEmail |

  @Regression @CommercialMember @Update
  Scenario Outline: Update the email address in commercial member contact information page and verify in email history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And enter the new "<emailAddress>" and click on reset and verify in member contact information page
    And update and validate the "<emailAddress>" in member contact information page
    Then navigate to email history page
    And verify the updated email details in email history page
    Then click on back to member information page in email history page

    Examples: 
      | test_id | sheetName                       |
      |       2 | CommercialMemberContactInfEmail |

  @Regression @CommercialMember
  Scenario Outline: Validate the member phone number details in commercial member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And verify the phone number details "<phoneType>",  "<preferred>", "<phoneNumber>", "<value1>", "<value2>", "<updatedBy>", "<updatedDate>", "<sourceChannel>" in member contact information page
    Then navigate to phone history page
    And search for the specific dates "<fromDate>", "<endDate>" in phone history page
    And verify the existing details "<telephoneNumber>", "<sales>", "<nonSales>", "<updatedBy>", "<updatedDate>" in phone history page

    Examples: 
      | test_id | sheetName                       |
      |       1 | CommercialMemberContactInfPhone |

  @Regression @CommercialMember @Update
  Scenario Outline: Update the mobile preferences in commercial member contact information page and verify in phone history page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And update and validate the phone number non-sales preference with "<value1>" and "<value2>" details in member contact information page
    And if the non-sales value is consent then the reconfirm checkbox should be enabled else disabled in member contact information page
    Then navigate to phone history page
    And verify the updated details in phone history table through member information page

    Examples: 
      | test_id | sheetName                       |
      |       2 | CommercialMemberContactInfPhone |
      |       3 | CommercialMemberContactInfPhone |

  @Regression @CommercialMember
  Scenario Outline: Validate the member text number details and member mailing address details in commercial member contact information page
    
    Login to the application

    Given get data from datasheet with "<test_id>" and "<sheetName>"
    Given Navigate to member search page
    And select the search by subscriber id option then search for the member by using "<subscriberId>" , "<seqNumber>" , "<dob>","<memberState>", "<groupNumber>" and select the "<sourceSystem>"
    Then click on member last name based on "<seqNumber>", "<firstName>", "<lastName>", "<dob>"
    And validate the member text number details "<preferred>", "<phoneNumber>", "<sourceChannel>",  "<sourceOrigin>", "<updatedBy>", "<updatedDate>"  in member contact information page
    And validate the member mailing address details "<preferred>", "<mailingAddress>", "<sourceChannel>",  "<sourceOrigin>", "<updatedBy>", "<updatedDate>"in member contact information page

    Examples: 
      | test_id | sheetName                      |
      |       1 | Cmrcl_Mbr_Text_Mail_Email_Pref |
