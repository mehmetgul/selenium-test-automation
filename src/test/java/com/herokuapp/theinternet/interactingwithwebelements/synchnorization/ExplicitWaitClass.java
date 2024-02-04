package com.herokuapp.theinternet.interactingwithwebelements.synchnorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExplicitWaitClass {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moodys.com/");
        WebElement element = driver.findElement(By.xpath("//button[@id=':r0:']"));
//        element.click();
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement xxx = wait.until(ExpectedConditions.visibilityOf(element));
//        xxx.click();
        WebElement xxx =waitForElementToBeVisible(driver,element,20);
        xxx.click();
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //GENERIC METHOD
    public <V> V waitForCondition(WebDriver driver, ExpectedCondition<V> condition, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(condition);
    }



}
