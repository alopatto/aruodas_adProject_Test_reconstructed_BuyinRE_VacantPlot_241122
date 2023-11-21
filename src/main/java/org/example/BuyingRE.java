package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class BuyingRE {

    public String region;
    public String settlement;
    public String microdistrict;
    public String street;
    public String objectType;
    public String description;
    public String photos;
    public String youtubeLink;
    public String threeDTour;
    public String priceFromEur;
    public String phoneNo;
    public String email;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BuyingRE(String region, String settlement, String microdistrict, String street, String objectType,
                    String description, String photos, String youtubeLink, String threeDTour,
                    String priceFromEur, String phoneNo, String email) {
        this.region = region;
        this.settlement = settlement;
        this.microdistrict = microdistrict;
        this.street = street;
        this.objectType = objectType.toLowerCase();
        this.description = description;
        this.photos = photos;
        this.youtubeLink = youtubeLink;
        this.threeDTour = threeDTour;
        this.priceFromEur = priceFromEur;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public void fillBuyingREAd() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/ul/li[7]")).click();
        photoToBeAdded();
        setLocation();
        setObjectType();
        mustToBeFilledFields();
        additionalFields();
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[1]/div/div/label/span")).click();
        driver.findElement(By.id("submitFormButton")).click();
    }

    public void photoToBeAdded() {
        File resourceFile = new File("imagesToBeDownloaded/" + this.photos);
        System.out.println(resourceFile.getAbsolutePath());
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(resourceFile.getAbsolutePath());
    }

    public void setLocation() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[1]/input")).sendKeys(this.region);
        threadSleep();
        driver.findElement(By.xpath("//*[@id=\"regionDropdown\"]/li[1]/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"district\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"districts_461\"]/li[1]/input")).sendKeys(this.settlement);
        threadSleep();
        driver.findElement(By.xpath("//*[@id=\"districts_461\"]/li[1]/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[1]/input")).sendKeys(this.microdistrict);
        threadSleep();
        driver.findElement(By.xpath("//*[@id=\"quartals_1\"]/li[1]/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(this.street);
        threadSleep();
        driver.findElement(By.xpath("//*[@id=\"streets_1\"]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    public void setObjectType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        List<WebElement> objectTypes = driver.findElement(By.className("dropdown-input-values")).findElements(By.tagName("li"));
        for (WebElement objectType : objectTypes) {
            if (objectType.getText().toLowerCase().equals(this.objectType)) {
                objectType.click();
                break;
            }
        }
    }

    public void mustToBeFilledFields() {
        driver.findElement(By.id("priceField")).sendKeys(this.priceFromEur);
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[1]/input")).sendKeys(this.phoneNo);
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/span[1]/input")).sendKeys(this.email);
    }

    public void additionalFields() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[13]/div/div[1]/textarea")).sendKeys(this.description);
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[1]/input")).sendKeys((this.youtubeLink));
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/span[1]/input")).sendKeys(this.threeDTour);
    }

    public void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }


}
