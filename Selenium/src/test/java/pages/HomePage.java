package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static utility.BrowserDriver.driver;

public class HomePage {
    public static String btnReksadana = "//a[@data-testid='hero-onboard-action-mutual_fund']";
    public static String tfSearchReksadana = "//div[p[text()='Cari reksa dana']]";
    public static String tfSearch = "//input[@class='custom-input-search']";

    public static void open_bibit() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://app.bibit.id/");
        Thread.sleep(2000);
    }

    public static void click_reksadana() {
        driver.findElement(By.xpath(btnReksadana)).click();
    }

    public static void search_reksadana(String name) throws InterruptedException {
        driver.findElement(By.xpath(tfSearchReksadana)).click();
        driver.findElement(By.xpath(tfSearch)).click();
        driver.findElement(By.xpath(tfSearch)).sendKeys(name);
        driver.findElement(By.xpath("\"//div[text()="+ name+ " " +"]\"")).click();
        Thread.sleep(2000);
    }

}
