package steps;

import io.cucumber.java.en.Then;

import static pages.HomePage.click_reksadana;
import static pages.HomePage.search_reksadana;
import static pages.ReksadanaPage.assert_selected;

public class ReksadanaPage {
    @Then("User shown the expected {string} reksadana")
    public static void user_shown_the_expected_reksadana(String text) throws InterruptedException {
        assert_selected(text);
    }
}
