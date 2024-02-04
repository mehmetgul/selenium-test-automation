package com.herokuapp.theinternet.interactingwithwebelements.bonuscodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTest {
    static WebDriver driver;

    /**
     * Aim of this test to click the mic button and skipping/disabling the
     * Allow mic alert and clicking the button
     */
    public static void main(String[] args) {

        //setting up chrome driver and using fake mic to override the system.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        driver = new ChromeDriver(options);

        driver.get("https://www.vidyard.com/mic-test/");

        WebElement mic = driver.findElement(By.xpath("//div[@class='col']/button"));
        mic.click();
        driver.close();

    }
}
