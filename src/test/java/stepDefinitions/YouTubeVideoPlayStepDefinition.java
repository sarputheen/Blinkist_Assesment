package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookList;
import pageObjects.YouTubeVideoPlay;

public class YouTubeVideoPlayStepDefinition {

	@Then("I pause the video")
	public void i_pause_the_video() {
		YouTubeVideoPlay.pauseVideo();
	}

	@Then("I turn off the auto play")
	public void i_turn_off_the_auto_play() {
		YouTubeVideoPlay.autoPlayOff();
	}

	@Then("I turn on the auto play")
	public void i_turn_on_the_auto_play() {
		YouTubeVideoPlay.autoPlayOn();
	}

	@Then("I play the video")
	public void i_play_the_video() {
		YouTubeVideoPlay.playVideo();
	}

	@Then("I go to next video")
	public void i_go_to_next_video() {
		YouTubeVideoPlay.playNextVideo();
	}

	@Then("I come to previous video")
	public void i_come_to_previous_video() {
		YouTubeVideoPlay.playPreviousVideo();
	}
}
