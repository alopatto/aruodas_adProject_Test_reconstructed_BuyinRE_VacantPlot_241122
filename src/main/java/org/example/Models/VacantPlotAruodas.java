package org.example.Models;

import org.openqa.selenium.By;

public class VacantPlotAruodas extends RealEstateAruodas {

    public String adressNo;
    public String numberRC;
    public String aArea;
    public String purpose;
    public String detailsDescription;

    public VacantPlotAruodas(String region, String settlement, String microdistrict, String street, String description,
                             String photos, String youtubeLink, String threeDTour, String priceFromEur, String phoneNo,
                             String email, String adressNo, String numberRC, String aArea, String purpose, String detailsDescription) {
        super(region, settlement, microdistrict, street, description, photos, youtubeLink, threeDTour, priceFromEur, phoneNo, email);

        this.adressNo = adressNo;
        this.numberRC = numberRC;
        this.aArea = aArea;
        this.purpose = purpose;
        this.detailsDescription = detailsDescription;
    }

    @Override
    public void fillAd() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        super.fillAd();
        setAdressNo();
        setNumberRC();
        setArea();
        choosePurpose();
        chooseDetailsDescription();
        //driver.findElement(By.xpath("//*[@id=\"submitFormButton\"]")).click();
    }

    public void setAdressNo() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.adressNo);
    }

    public void setNumberRC() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.numberRC);
    }

    public void setArea() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.aArea);
    }

    public void choosePurpose() {
        String[] purposes = this.purpose.split(",");

        for (int i = 0; i < purposes.length; i++) {

            switch (purposes[i]) {
                case "Namų valda":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "Sklypas soduose":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "Sandėliavimo":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[7]/label")).click();
                    break;
                case "Kita":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[10]/label")).click();
                    break;
                case "Daugiabučių statyba":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "Miškų ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label")).click();
                    break;
                case "Komercinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[8]/label")).click();
                    break;
                case "Žemės ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "Pramonės":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[6]/label")).click();
                    break;
                case "Rekreacinė":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[9]/label")).click();
                    break;
            }
        }
    }

    public void chooseDetailsDescription() {
        driver.findElement(By.id("showMoreFields")).click();

        String[] details = this.detailsDescription.split(",");
        fThreadSleep(2000);

        for (int i = 0; i < details.length; i++) {

            switch (details[i]) {
                case "Elektra":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[1]/label")).click();
                    break;
                case "Kraštinis sklypas":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[4]/label")).click();
                    break;
                case "Geodeziniai matavimai":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[7]/label")).click();
                    break;
                case "Dujos":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[2]/label")).click();
                    break;
                case "Greta miško":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[5]/label")).click();
                    break;
                case "Su pakrante":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[8]/label")).click();
                    break;
                case "Vanduo":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[3]/label")).click();
                    break;
                case "Be pastatų":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[6]/label")).click();
                    break;
                case "Asfaltuotas privažiavimas":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[20]/div/div[9]/label")).click();
                    break;
                case "Domina keitimas":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div/div/div/label")).click();
                    break;
                case "Varžytinės/aukcionas":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/div/div/div/label")).click();
                    break;
            }
        }
    }

    public static void fThreadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
