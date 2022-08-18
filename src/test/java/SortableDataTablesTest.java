import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest{

    @Test
    public void sortableDataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        String personalData;
        WebElement table = driver.findElement(By.id("table1"));
        personalData = table.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        assertEquals(personalData, "Smith", "The data in the table cell doesn't match");

        personalData = table.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        assertEquals(personalData, "jsmith@gmail.com", "The data in the table cell doesn't match");

        personalData = table.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        assertEquals(personalData, "Frank", "The data in the table cell doesn't match");

        personalData = table.findElement(By.xpath("//table//tr[2]//td[4]")).getText();
        assertEquals(personalData, "$51.00", "The data in the table cell doesn't match");

        WebElement table2 = driver.findElement(By.id("table2"));
        personalData = table2.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
        assertEquals(personalData, "John", "The data in the table cell doesn't match");
    }
    }

