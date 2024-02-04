package com.herokuapp.theinternet.webelementmethods;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethodsTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement hideButtonXpath = driver.findElement(By.xpath("//*[@id=\"hide-textbox\"]"));
        WebElement hideButtonById = driver.findElement(By.id("hide-textbox"));

        //hideButtonXpath.click();
        hideButtonById.click();

        WebElement showButtonById = driver.findElement(By.id("show-textbox"));
        showButtonById.click();
        
        String classValue = showButtonById.getAttribute("class");
        System.out.println("classValue = " + classValue);
        String valueValue = showButtonById.getAttribute("value");
        System.out.println("valueValue = " + valueValue);

        driver.quit();
    }
}
