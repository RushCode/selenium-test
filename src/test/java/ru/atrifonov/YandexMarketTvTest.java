package ru.atrifonov;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YandexMarketTvTest extends BaseTest {

    private CharSequence tvName;

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
    public void ElektroTvPage() {
        driver.findElement(By.cssSelector("[data-reactid=\"36\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ElektroTvAdvSearchPage() {
        driver.findElement(By.linkText("Все фильтры")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchFromPrice() {
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys("20000");
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchSamsung() {
        driver.findElement(By.cssSelector("[for=\"glf-7893318-153061\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchLg() {
        driver.findElement(By.cssSelector("[for=\"glf-7893318-153074\"]")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ApplySearch() {
        driver.findElement(By.linkText("Показать подходящие")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ResultSearch() {
        setTvName(driver.findElement(By.cssSelector(
                "body > div > div:nth-child(6) > div.layout.layout_type_search.i-bem > div.layout__col.i-bem.layout__col_search-results_normal > div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited > div > div.n-snippet-list.n-snippet-list_type_vertical.metrika.b-zone.b-spy-init.i-bem.metrika_js_inited.snippet-list_js_inited.b-spy-init_js_inited.b-zone_js_inited > div:nth-child(1) > div.n-snippet-card2__part.n-snippet-card2__part_type_center > div.n-snippet-card2__header.n-snippet-card2__header_has_rating > div.n-snippet-card2__title > a"
        )).getText());
    }

    @Test(groups = {"yandexElectroMarket"})
    public void SearchTvName() {
        driver.findElement(By.id("header-search")).sendKeys(tvName);
    }

    @Test(groups = {"yandexElectroMarket"})
    public void ApplyGlobalSearch() {
        driver.findElement(By.className("search2__button")).click();
    }

    @Test(groups = {"yandexElectroMarket"})
    public void GlobalSearchTitleName() {
        assertEquals(tvName, driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/h1")).getText());
    }

    private void setTvName(CharSequence tvName) {
        this.tvName = tvName;
    }
}
