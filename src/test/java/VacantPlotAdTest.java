import org.example.Models.RealEstateAruodas;
import org.example.Models.VacantPlotAruodas;
import org.example.HelperAruodasLoad;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VacantPlotAdTest {

    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        HelperAruodasLoad.aruodasDriverInit();
        driver = RealEstateAruodas.driver;
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    @Test
    public void vacantPlotFillAdPositiveTest() {
        VacantPlotAruodas newAd = new VacantPlotAruodas("Viln","Viln","Bajor","Jakšto",
                "Daug žemės, akmenys nurinkti.","Plot.jpg","","","5000",
                "68925789","anz_lopatto@gmail.com","256","5698-2589-4896","20",
                "Sklypas soduose,Miškų ūkio","Be pastatų,Domina keitimas");
        newAd.fillAd();
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"planChooseFooter\"]/div/div/div[2]")).getText(), "Iš viso:");
    }
}
