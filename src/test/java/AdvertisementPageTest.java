import org.example.BuyingRE;
import org.example.HelperAruodasLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvertisementPageTest {
    public static WebDriver driver;

    @Test
    public void aruodasPageLoadTest() {
        //System.out.println("Hello World!");
    }

    @Test
    public void positiveBuyingRETest() throws InterruptedException {
        BuyingRE newAd = new BuyingRE("Vilnius", "Vilniaus", "Pilaitė", "Almino",
                "Garažai/vietos", "Garažiukas naujos statybos.", "GarageForThePurchasing.jpg",
                "https://www.youtube.com/watch?v=vmzZ1dUApvU&ab_channel=DooPiano", "",
                "30000", "65872956", "anz_lopato@gmail.com");
        newAd.fillBuyingREAd();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"planChooseFooter\"]/div/div/div[2]")).getText(),"Iš viso:");
    }

    @BeforeClass
    public void beforeClass() {
        HelperAruodasLoad.aruodasDriverInit();
        driver = HelperAruodasLoad.driver;
        acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void acceptCookies() {
        driver.get("https://www.aruodas.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/a")).click();
    }
}
