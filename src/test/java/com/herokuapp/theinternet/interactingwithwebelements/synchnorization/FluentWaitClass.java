package com.herokuapp.theinternet.interactingwithwebelements.synchnorization;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitClass {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/java/com/herokuapp/theinternet/interactingwithwebelements/synchnorization/fluent.html");
        WebElement button = driver.findElement(By.id("btnClick"));
        button.click();
        WebElement messageText = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println("messageText.getText() = " + messageText.getText());
        String text = waitForElementWithFluentWait(driver,messageText,30,1 ).getText();
        System.out.println("text = " + text);
    }

    public static WebElement waitForElementWithFluentWait(WebDriver driver, WebElement element, long timeout, long pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
