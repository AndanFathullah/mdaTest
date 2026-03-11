package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoApp {
    static AppiumDriver driver;

    @Given("User navigates to app")
    public void user_navigates_to_app() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capab = new DesiredCapabilities();

        capab.setCapability("appium:deviceName","AOSP on IA Emulator");
        capab.setCapability("appium:udid","emulator-5554");
        capab.setCapability("appium:platformName","Android");
        capab.setCapability("appium:platformVersion","9");
        capab.setCapability("appium:automationName","uiAutomator2");
        capab.setCapability("appium:appPackage","com.saucelabs.mydemoapp.android");
        capab.setCapability("appium:resetKeyboard",true);
        capab.setCapability("appium:unicodeKeyboard",true);

        URL url = new URL("http://127.0.0.1:4723/");

        driver = new AppiumDriver(url, capab);

        Thread.sleep(5000);
    }

    @When("user login to their account")
    public void user_login_to_their_account() throws InterruptedException {
        driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"View menu\"]")).click();

        driver.findElement(new By.ByXPath("//android.widget.TextView[@content-desc=\"Login Menu Item\"]")).click();
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/nameET")).sendKeys("bod@example.com");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/passwordET")).sendKeys("10203040");
        driver.findElement(new AppiumBy.ByAccessibilityId("Tap to login with given credentials")).click();
        Thread.sleep(5000);
    }

    @When("user purchase a product")
    public void user_purchase_a_product() throws InterruptedException {
        driver.findElement(new By.ByXPath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]")).click();

        driver.findElement(new AppiumBy.ByAccessibilityId("Blue color")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" +
                        "new UiSelector().textContains(\"Add to cart\").instance(0))"
        )).isDisplayed();
        driver.findElement(new AppiumBy.ByAccessibilityId("Increase item quantity")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Tap to add product to cart")).click();

        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/cartIV")).click();

        driver.findElement(new AppiumBy.ByAccessibilityId("Confirms products for checkout")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" +
                        "new UiSelector().textContains(\"To Payment\").instance(0))"
        )).isDisplayed();

        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/fullNameET")).sendKeys("Rebecca Winter");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/address1ET")).sendKeys("Jakarta Raya");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/cityET")).sendKeys("Jakarta");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/zipET")).sendKeys("26152");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/countryET")).sendKeys("Konoha");

        driver.findElement(new AppiumBy.ByAccessibilityId("Saves user info for checkout")).click();

        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/nameET")).sendKeys("Rebecca Winter");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/cardNumberET")).sendKeys("2312321232123123");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/expirationDateET")).sendKeys("0155");
        driver.findElement(new By.ById("com.saucelabs.mydemoapp.android:id/securityCodeET")).sendKeys("123");

        driver.findElement(new AppiumBy.ByAccessibilityId("Saves payment info and launches screen to review checkout data")).click();

        driver.findElement(new AppiumBy.ByAccessibilityId("Completes the process of checkout")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" +
                        "new UiSelector().textContains(\"Checkout Complete\").instance(0))"
        )).isDisplayed();

        Thread.sleep(5000);
    }

    @When("user sort name product descending")
    public void user_sort_name_product_descending() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("Shows current sorting order and displays available sorting options")).click();
        driver.findElement(new By.ByXPath("//android.widget.TextView[@text=\"Name - Descending\"]")).click();
        Thread.sleep(5000);
    }

    @When("user sort price product ascending")
    public void user_sort_price_product_ascending() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("Shows current sorting order and displays available sorting options")).click();
        driver.findElement(new By.ByXPath("//android.widget.TextView[@text=\"Price - Ascending\"]")).click();
        Thread.sleep(5000);
    }

    @Then("user see result as expected")
    public void user_see_result_as_expected() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Then("user success purchase")
    public void user_success_purchase() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("View menu")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Logout Menu Item")).isDisplayed();
        Thread.sleep(5000);
    }

    @Then("user logged in to their account")
    public void user_logged_in_to_their_account() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAccessibilityId("View menu")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Logout Menu Item")).isDisplayed();
        driver.findElement(new By.ByXPath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Catalog\"]")).click();

        Thread.sleep(5000);
    }


}
