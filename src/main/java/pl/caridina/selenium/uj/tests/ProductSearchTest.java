package pl.caridina.selenium.uj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.caridina.selenium.uj.pages.MainPage;


public class ProductSearchTest extends AbstractTest {

    @Test
    public void successProductSearchTest() {
        Assert.assertTrue(
                new MainPage(driver, logger)
                        .fillSearchForm("tropical")
                        .submitSearchForm()
                        .isSearchResultDisplayed()
        );
    }
}
