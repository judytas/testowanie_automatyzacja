package pl.caridina.selenium.uj.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBasketPage extends AbstractPage {

    @FindBy(xpath = "//html/body/div/div[2]/div/div[3]/div[2]/div[2]/table/tbody/tr/td[7]/div/a")
    private WebElement deleteButton;

    @FindBy(xpath = "//html/body/div/div[2]/div/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/p/a")
    private WebElement productName;

    private By emptyBasketMessageXpath = By.xpath("//html/body/div/div[2]/div/div[3]/div[2]/p");

    public ShoppingBasketPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public ShoppingBasketPage clickDeleteButton() {
        clickElement(deleteButton);
        return this;
    }

    public boolean isProductDisplayedInBasket() {
        return isElementDisplayed(productName);
    }

    public boolean isEmptyBasketMessageDisplayed() {
        WebElement emptyBasketMessage = waitForElement(emptyBasketMessageXpath);
        return isElementDisplayed(emptyBasketMessage);
    }

}
