Feature: Book List Feature Testing
Description: This feature will test the E2E functionality of Book List.

@automated @booklist01 @booklist
Scenario: As a user, I want to verify the Book list screen UI
	Given I am in the Book List screen
	When I verify the "Blinkist Code Challenge" header text
	Then I verify the "YouTube" link text
	Then I verify the book list count
	
	

@automated @booklist02  @booklist
Scenario Outline: As a user, I want to verify the Book details
	Given I am in the Book List screen
	When I verify the  book "<bookName>"
	Then I verify the author "<authorName>"
	
		Examples:
    	| bookName 						| authorName 				| 
    	|    Eat, Move, Sleep	|   Tom Rath 				|
   
		
@automated @booklist03  @booklist
Scenario Outline: As a user, I want to verify the other functionalities of book list
	Given I am in the Book List screen
	When I verify the book image
	Then I verify the alert message with book "<bookName>"
	Then I verify the book with long name and its author
	
	
		Examples:
    	| bookName 						 	 | 
    	|	Eat, Move, Sleep			 |