package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static pages.HomePage.click_reksadana;
import static pages.HomePage.search_reksadana;
import static pages.ProfilePage.click_profile;
import static utility.BrowserDriver.driver;

public class ProfilePage {
    @When("User is trying to logout")
    public static void user_is_trying_to_logout() throws InterruptedException {
        click_profile();
    }

    @Then("User shown logged out state")
    public static void user_shown_logged_out_state() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-testid='nonlogin-login-btn']")).isDisplayed();
    }
}
