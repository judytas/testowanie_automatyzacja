package pl.caridina.selenium.uj.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CustomDriverFactory {

    private CustomFile customFile;

    public CustomDriverFactory() {
        customFile = new CustomFile();
    }

    public WebDriver getConfiguredDriver(String browserType, long implicitlyWait, boolean windowMaximize) {
        WebDriver driver;
        if (browserType.equalsIgnoreCase(BaseProperties.CHROME_BROWSER_TYPE)) {

            System.setProperty("webdriver.chrome.driver", customFile.getResourceFilePathString(BaseProperties.CHROME_DRIVER_FILE_NAME));
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase(BaseProperties.FIREFOX_BROWSER_TYPE)) {

            System.setProperty("webdriver.gecko.driver", customFile.getResourceFilePathString(BaseProperties.FIREFOX_DRIVER_FILE_NAME));
            driver = new FirefoxDriver();
        } else {

            System.setProperty("webdriver.chrome.driver", customFile.getResourceFilePathString(BaseProperties.CHROME_DRIVER_FILE_NAME));
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        if (windowMaximize) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}