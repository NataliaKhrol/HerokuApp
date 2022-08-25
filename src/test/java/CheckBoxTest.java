import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends BaseTest {
    @Test
    public void checkTest() {

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        boolean isSelected;
        isSelected = checkbox1.isSelected();
        assertFalse(isSelected, "The box is selected");
        checkbox1.click();
        isSelected = checkbox1.isSelected();
        assertTrue(isSelected, "The box is not selected");

        WebElement checkbox2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);
        isSelected = checkbox2.isSelected();
        assertTrue(isSelected, "The box is not selected");
        checkbox2.click();
        isSelected = checkbox2.isSelected();
        assertFalse(isSelected, "The box is selected");
    }
}
