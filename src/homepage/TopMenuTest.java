package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com";


    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) throws InterruptedException {
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//li"));
        for (WebElement element1 : element) {
            if (element1.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                element1.click();
                break;
            }
        }

    }

    @Test
    public void verifyComputerPageNavigation() throws InterruptedException {
        selectMenu("Computers");
        verifyElements("Computers", By.partialLinkText("Computers"), "page not found");


    }

    @Test
    public void verifyElectronicsPageNavigation() throws InterruptedException {
        selectMenu("Electronics");
        verifyElements("Electronics", By.partialLinkText("Electronics"), "Page not found");
    }

    @Test
    public void verifyApparelPageNavigation() throws InterruptedException {
        selectMenu("Apparel");
        verifyElements("Apparel", By.partialLinkText("Apparel"), "page not found");


    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
