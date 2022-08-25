import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement element = driver.findElements(By.tagName("p")).get(1);
        String textOnPage = element.getAttribute("innerText");
        assertEquals(textOnPage, "Sometimes you'll see a typo, other times you won,t.",
                "The texts are not the same");
    }
}
