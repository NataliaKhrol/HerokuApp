import io.netty.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
    }

    @Test
    public void dynamicControls() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.cssSelector("[type=checkbox]")).size();
        assertEquals(numberOfElements, 0, "������� ������������ �� ��������");


    }
}
   /* boolean checkbox = driver.findElement(By.cssSelector("[type=checkbox]")).is();
    assertTrue(checkbox, "Something went wrong");
        driver.findElement(By.cssSelector("[disabled='']"));*/