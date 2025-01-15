package toolset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static toolset.WebDriverTool.driver;

public class Actions {

    private static final int TIMEOUT_SECONDS = 10;

    private Actions() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Waits for element to be clickable before interacting
     */
    private static WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void fillField(String elementID, String text) {
        WebElement element = waitForElement(By.id(elementID));
        element.sendKeys(text);
    }

    public static void clickField(String elementXpath) {
        WebElement element = waitForElement(By.xpath(elementXpath));
        element.click();
    }

    /**
     * Verifies if specified text is present in the page
     * @param expectedText text to verify on the page
     * @throws IllegalStateException if text is not found within timeout period
     */
    public static void verifyResults(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
        try {
            boolean isTextPresent = wait.until(driver -> driver.getPageSource().contains(expectedText));
            if (!isTextPresent) {
                throw new IllegalStateException(
                    String.format("Expected text '%s' was not found on the page", expectedText));
            }
        } catch (Exception e) {
            throw new IllegalStateException(
                String.format("Failed to verify text '%s' on the page: %s", expectedText, e.getMessage()));
        }
    }
}