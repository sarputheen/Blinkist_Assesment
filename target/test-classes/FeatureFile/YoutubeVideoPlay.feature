Feature: Youtube video play Feature Testing
Description: This feature will test the E2E functionality of Youtube video play.

@automated @youtube01 @youtube
Scenario: As a user, I want to test Youtube video play feature
	Given I am in the Book List screen
	When I go to the You Tube
	Then I pause the video
	Then I turn off the auto play
	Then I turn on the auto play
	Then I play the video
	Then I go to next video
	Then I come to previous video