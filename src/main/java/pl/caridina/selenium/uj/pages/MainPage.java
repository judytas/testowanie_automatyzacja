package pl.caridina.selenium.uj.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//html/body/div/div[1]/header/div/div/div/div/div[1]/div[2]/div/div[1]/a")
    private WebElement shoppingBasket;

    @FindBy(xpath = "//html/body/div/div[1]/header/div/div/div/div/div[3]/form/button")
    private WebElement searchButton;

    @FindBy(xpath = "//html/body/div/div[1]/header/div/div/div/div/div[3]/form/input[4]")
    private WebElement searchInput;


    public MainPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public boolean isMainPageDisplayed() {
        return isElementDisplayed(shoppingBasket);
    }

    public ShoppingBasketPage openShoppingBasketPage() {
        clickElement(shoppingBasket);
        return new ShoppingBasketPage(driver, logger);
    }

    public MainPage fillSearchForm(String searchInputValue) {
        fillElement(searchInput, searchInputValue);
        return this;
    }

    public SearchResultsPage submitSearchForm() {
        clickElement(searchButton);
        return new SearchResultsPage(driver, logger);
    }
}

