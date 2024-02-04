package com.herokuapp.theinternet.interactingwithwebelements.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOverClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        WebElement electronicsLink = driver.findElement(By.linkText("Electronics"));
        WebElement iphoneLink = driver.findElement(By.xpath("//a[normalize-space()='Apple iPhone']"));

        Actions actions =new Actions(driver);
        actions
                .moveToElement(electronicsLink)
                .build()
                .perform();
        Thread.sleep(500);
        iphoneLink.click();

    }
}
