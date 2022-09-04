import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.cssSelector("[type=checkbox]")).size();
        assertEquals(numberOfElements, 0, "Ёлемент присутствует на странице");
        boolean isDisabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertFalse(isDisabled, "The input is enabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait waitTheSecond = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitTheSecond.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),\"It's enabled!\")]")));
        boolean isEnabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertTrue(isEnabled, "The input is Disabled");
    }

    // ƒима сорри, ¬се что ниже - в учебных цел€х, дл€ лучшего понимани€ и закреплени€
    public static void main(String[] args) {

        System.out.println("//p[contains(text(),'It\'s enabled!')]");
        System.out.println("hello");
        try {
            Thread.sleep(5000);

        } catch (Exception ex) {
            //  ignore
        }
        System.out.println("Natalya");
    }

    @Test
    public void pashaTeachesMe() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
        WebElement el = driver.findElement(By.id("message"));
       waitElementDisplayed(el);


        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.cssSelector("[type=checkbox]")).size();
        assertEquals(numberOfElements, 0, "Ёлемент присутствует на странице");
        boolean isDisabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertFalse(isDisabled, "The input is enabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait waitTheSecond = new WebDriverWait(driver, Duration.ofSeconds(20));
//       waitTheSecond.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'It's enabled!')]")));
        //waitTheSecond.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),\"It's enabled!\")]")));
        waitElementDisplayedByLocator(driver, By.xpath("//p[contains(text(),\"It's enabled!\")]"));

        boolean isEnabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertTrue(isEnabled, "The input is Disabled");
    }

    private void spim100() {
        try {
            Thread.sleep(1000);

        } catch (Exception ex) {
            //  ignore
        }

    }
    private void waitElementDisplayed(WebElement element){
        while (true) {
            if (element.isDisplayed()) {
                break;
            } else {
                spim100();
            }
        }

    }
    private void waitElementDisplayedByLocator(WebDriver driver, By locator){
        int a = 0;
        while (true) {
            List<WebElement> els = driver.findElements(locator);

            if (!els.isEmpty() && els.get(0).isDisplayed()) {
                break;

            } else {
                a++;
                System.out.println(a);
                spim100();
            }
        }
    }
}

