package pl.caridina.selenium.uj.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.caridina.selenium.uj.utils.BaseProperties;
import pl.caridina.selenium.uj.utils.CustomTestLog;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Logger logger;

    public AbstractPage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(this.driver, this);
    }

    protected void fillElement(WebElement element, String value) {
        // OPCJONALNIE - dodać oczekiwanie na element
        logger.info(CustomTestLog.getElementMessage(element, CustomTestLog.CLEAR_ACTION));
        element.clear();

        logger.info(CustomTestLog.getElementMessage(element, value, CustomTestLog.FILL_ACTION));
        element.sendKeys(value);
    }

    protected void hoverOverElement(WebElement element) {
        logger.info(CustomTestLog.getElementMessage(element, CustomTestLog.HOVER_OVER_ACTION));
        Actions builder = new Actions(driver);
        Actions hoverOnProductThumbnail = builder.moveToElement(element);
        hoverOnProductThumbnail.perform();
    }

    protected void clickElement(WebElement element) {
        // OPCJONALNIE - dodać oczekiwanie na element
        logger.info(CustomTestLog.getElementMessage(element, CustomTestLog.CLICK_ACTION));
        element.click();
    }

    protected boolean isElementDisplayed(WebElement element) {
        // OPCJONALNIE - dodać oczekiwanie na element
        logger.info(CustomTestLog.getElementMessage(element, CustomTestLog.IS_DISPLAYED_ACTION));
        return element.isDisplayed();
    }

    protected WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, BaseProperties.TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}


