package stepDefinitions;

import java.net.MalformedURLException;

import driverInit.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookList;
import pageObjects.YouTubeVideoPlay;

public class BookListStepDefinition {

	@Given("I Launch the app")
	public void i_launch() throws MalformedURLException {
		DriverInitialization.driverInit();
	}
	
	@And("I am in the Book List screen")
	public void i_am_in_the_Book_List_screen() {
		BookList.verifyHomeScreen();
	}

	@When("I verify the {string} header text")
	public void i_verify_the_header_text(String string) {
		BookList.verifyHeaderText(string);
	}

	@Then("I verify the {string} link text")
	public void i_verify_the_link_text(String string) {
		BookList.verifyLinkText(string);
	}

	@Then("I verify the book list count")
	public void i_verify_the_book_list_count() {
		BookList.verifyBookCount();
	}

	@When("I verify the  book {string}")
	public void i_verify_the_book(String book) {
		BookList.verifyBookName(book);

	}

	@Then("I verify the author {string}")
	public void i_verify_the_author(String author) {
		BookList.verifyAuthorName(author);
	}

	@Then("I verify the alert message with book {string}")
	public void i_verify_the_alert_message_with_book(String book) {
		BookList.verifyAlertText(book);
	}

	@Then("I verify the book with long name and its author")
	public void i_verify_the_book_with_long_name_and_its_author() {
		BookList.getTheLongestBookName();
	}

	@When("I verify the book image")
	public void i_verify_the_book_image() {
		BookList.verifyBooImage();
	}

	@When("I go to the You Tube")
	public void i_go_to_the_You_Tube() {
		BookList.gotToYouTube();
	}
	
	@Then("I quit the app")
	public void i_quit() {
		DriverInitialization.teardown();
	}

}
