package ru.atrifonov;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YandexMarketHeadphonesTest extends BaseTest {

    private CharSequence headphone;

    @Test(groups = {"yandexElectroMarket"})
    public void YandexPage() {
        driver.get("https://yandex.ru/");
    }

    @Test(groups = {"yandexElectroMarket"})
    public void YandexMarketPage() {
        driver.findElement(By.cssSelector("[data-id='market']")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ElektroPage() {
        driver.findElement(By.cssSelector("[data-department=\"Электроника\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void HeadphonesPage() {
        driver.findElement(By.cssSelector("[data-reactid=\"25\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void HeadphonesAdvSearchPage() {
        driver.findElement(By.linkText("Все фильтры")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchFromPrice() {
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys("5000");
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchBeats() {
        driver.findElement(By.cssSelector("[for=\"glf-7893318-8455647\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ApplySearch() {
        driver.findElement(By.linkText("Показать подходящие")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ResultSearch() {
        setHeadphoneName(driver.findElement(
                By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[3]/div[2]/a")
        ).getText());
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchTvName() {
        driver.findElement(By.id("header-search")).sendKeys(headphone);
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ApplyGlobalSearch() {
        driver.findElement(By.className("search2__button")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void GlobalSearchTitleName() {
        assertEquals(headphone, driver.findElement(
                By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/h1")
        ).getText());
    }

    private void setHeadphoneName(CharSequence headphone) {
        this.headphone = headphone;
    }
}
