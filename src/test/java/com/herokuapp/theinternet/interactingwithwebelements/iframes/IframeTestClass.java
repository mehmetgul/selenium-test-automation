package com.herokuapp.theinternet.interactingwithwebelements.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTestClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/recaptcha/api2/demo");
        driver.switchTo().frame(0);
        WebElement iAmNotARobot= driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        iAmNotARobot.click();
        if(isInFrame(driver)){
            driver.switchTo().defaultContent();
        }
        Thread.sleep(1000);
        driver.switchTo().frame(2);
        WebElement verifyButton = driver.findElement(By.xpath("//button[@id='recaptcha-verify-button']"));
        verifyButton.click();
    }

    public static boolean isInFrame(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean isInFrame = (boolean) executor.executeScript("return window.top !== window.self;");
        return  isInFrame;
    }

    /**
     * Nested Degilse
     * 0. frame 1. frame 2. frane [1]
     *
     * Nested Frame
     * 1. frame e , Sonra 3. frame git, 1. frame [1,3,1]
     */
}
