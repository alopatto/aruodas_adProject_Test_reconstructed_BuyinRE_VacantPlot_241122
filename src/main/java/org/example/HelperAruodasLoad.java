package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperAruodasLoad {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void aruodasDriverInit() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver = HelperAruodasLoad.driver;
        BuyingRE.driver = driver;
        BuyingRE.wait = wait;
    }

    public static String fPhoneNoRandom() {
        String symbols = "12345678901234567890";
        String randomNo = "";

        int nameInputLength = 8;

        for (int i = 0; i < nameInputLength; i++) {
            randomNo += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return randomNo;
    }
}
