import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {
    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement element = driver.findElement(By.tagName("p"));
        String val = element.getAttribute("innerText");
        assertEquals(val, "This example demonstrates a typo being introduced. It does it randomly on each" +
                        " page load. Sometimes you'll see a typo, other times you won,t.", "Not the same");
    }
}
