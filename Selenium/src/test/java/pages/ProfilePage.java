package pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static pages.HomePage.click_reksadana;
import static pages.HomePage.search_reksadana;
import static utility.BrowserDriver.driver;

public class ProfilePage {
    public static String profile = "//div[contains(@class, 'tabbar-profile-switch-account-tooltip-wrapper')]";
    public static String btnLogOut = "//div[contains(@class, 'LogoutButton__ListProfileItem')]";

    public static void click_profile() throws InterruptedException {
        driver.findElement(By.xpath(profile)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnLogOut);
        driver.findElement(By.xpath(btnLogOut)).click();
        Thread.sleep(500);
    }
}
