package ru.atrifonov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeGroups("yandexElectroMarket")
    protected WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "/path/to/you/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    @AfterGroups(groups = {"yandexElectroMarket"})
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
