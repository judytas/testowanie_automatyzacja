package pl.caridina.selenium.uj.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement productThumbnail;

    @FindBy(xpath = "//html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//html/body/div/div[1]/header/div/div/div/div/div[1]/div[2]/div/div[1]/a")
    private WebElement shoppingBasket;

    public SearchResultsPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public boolean isSearchResultDisplayed() {
        return isElementDisplayed(productThumbnail);
    }

    public SearchResultsPage clickAddToBasketButton() {
        clickElement(addToBasketButton);
        return this;
    }

    public SearchResultsPage hoverOnProductThumbnail() {
        hoverOverElement(productThumbnail);
        clickElement(addToBasketButton);
        return this;
    }

    public ShoppingBasketPage openShoppingBasketPage() {
        clickElement(shoppingBasket);
        return new ShoppingBasketPage(driver, logger);
    }
}
