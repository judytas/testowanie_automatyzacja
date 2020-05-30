package pl.caridina.selenium.uj.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pl.caridina.selenium.uj.utils.BaseProperties;
import pl.caridina.selenium.uj.utils.CustomDriverFactory;

public abstract class AbstractTest {
    protected static WebDriver driver;
    protected Logger logger;

    @Parameters({"browserType", "implicitlyWait", "windowMaximize"})
    @BeforeSuite
    public void setUp(String browserType, String implicitlyWait, String windowMaximize) {


        driver = new CustomDriverFactory().getConfiguredDriver(
                browserType,
                Long.parseLong(implicitlyWait),
                windowMaximize.equalsIgnoreCase("true")
        );
        driver.get(BaseProperties.BASE_URL);
    }

    @BeforeClass
    public void setUpClass() {
        logger = LogManager.getLogger(this.getClass().getName());
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();

    }
}
