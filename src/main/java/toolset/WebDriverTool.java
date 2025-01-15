package toolset;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTool {

    private static final String BASE_URL = "https://magento.softwaretestingboard.com";
    public static WebDriver driver;

    private WebDriverTool() {
        throw new IllegalStateException("Utility class");
    }

    public static void setDriver(String url) {

        driver = new ChromeDriver();
        driver.get(BASE_URL + url);
        driver.manage().deleteAllCookies();
    }

    /**
     * Deletes all cookies from the browser
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
