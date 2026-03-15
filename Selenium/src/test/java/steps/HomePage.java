package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static pages.HomePage.*;


public class HomePage {
    @Given("User open Bibit homepage")
    public static void user_open_bibit_homepage() throws InterruptedException {
        open_bibit();
    }

    @When("User is searching for {string} reksadana")
    public static void user_is_searching_for_reksadana(String text) throws InterruptedException {
        click_reksadana();
        search_reksadana(text);
    }
}
