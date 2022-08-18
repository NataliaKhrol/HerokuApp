import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest{

    @Test
    public void sortableDataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
      //  driver.findElement(By.id("table1"));
        String personalData;
        personalData = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        assertEquals(personalData, "Smith", "The data in the table cell doesn't match");

        personalData = driver.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        assertEquals(personalData, "jsmith@gmail.com", "The data in the table cell doesn't match");

        personalData = driver.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        assertEquals(personalData, "Frank", "The data in the table cell doesn't match");

        personalData = driver.findElement(By.xpath("//table//tr[2]//td[4]")).getText();
        assertEquals(personalData, "$51.00", "The data in the table cell doesn't match");
    }
    }

