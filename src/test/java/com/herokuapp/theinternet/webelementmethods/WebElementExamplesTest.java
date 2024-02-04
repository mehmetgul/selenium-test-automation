package com.herokuapp.theinternet.webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExamplesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://careers.moodys.com/");
//        WebElement searchBox = driver.findElement(By.id("cws_quickjobsearch_keywords"));
//        WebElement searchBox = driver.findElement(By.className("ui-autocomplete-input"));
        WebElement searchBox = driver.findElement(By.name("keyword"));
        searchBox.sendKeys("Test Automation");
        WebElement checkLinkText= driver.findElement(By.linkText("Terms of Use"));
        checkLinkText.click();
        WebElement checkPartialLinkText = driver.findElement(By.partialLinkText("ms of U"));
        checkPartialLinkText.click();





        //driver.quit();
    }
}
