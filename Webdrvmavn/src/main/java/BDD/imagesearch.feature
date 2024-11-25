Feature: Google image search
@GoogleImageLink
Scenario: User navigates to Google image page successfully
Given user is on google home
When user clicks image hyperlink
Then user navigates to Google image page

@GoogleImageSearch
Scenario: User searches on Google image successfully
Given user enter search word
|Phoenix|
When user clicks enter
Then user navigates to search result page