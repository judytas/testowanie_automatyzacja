package pl.caridina.selenium.uj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.caridina.selenium.uj.pages.SearchResultsPage;
import pl.caridina.selenium.uj.pages.ShoppingBasketPage;

public class ShoppingBasketTest extends AbstractTest {

    @Test
    public void successAddProductToShoppingBasketTest() {
        Assert.assertTrue(
                new SearchResultsPage(driver, logger)
                        .hoverOnProductThumbnail()
                        .clickAddToBasketButton()
                        .openShoppingBasketPage()
                        .isProductDisplayedInBasket()
        );
    }

    @Test
    public void successDeleteProductFromShoppingBasketTest() {
        Assert.assertTrue(
                new ShoppingBasketPage(driver, logger)
                        .clickDeleteButton()
                        .isEmptyBasketMessageDisplayed()

        );
    }
}
