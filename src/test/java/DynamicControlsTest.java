import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
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
        assertEquals(numberOfElements, 0, "Элемент присутствует на странице");
        boolean isDisabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertFalse(isDisabled, "The input is enabled");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement((By.xpath("//form/p[@id='message']")))));
        boolean isEnabled = driver.findElement(By.cssSelector("[type=text]")).isEnabled();
        assertTrue(isEnabled, "The input is Disabled");
    }
}
