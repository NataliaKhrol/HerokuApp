import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ContextMenuTest extends BaseTest {
    @Test
    public void rightClick() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot")))
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.dismiss();

    }

}
