package pages;

import org.openqa.selenium.By;

import static utility.BrowserDriver.driver;

public class ReksadanaPage {
    public static String btnBuy = "//button[@data-testid='product-detail-buy-button']";
    public static String btnSIP = "//button[contains(@class, 'AutoRutinButton')]";

    public static void assert_selected(String text) {
        driver.findElement(By.xpath("//div[text()="+ text +"]")).click();
    }
}
