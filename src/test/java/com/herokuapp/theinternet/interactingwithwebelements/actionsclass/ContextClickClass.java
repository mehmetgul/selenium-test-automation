package com.herokuapp.theinternet.interactingwithwebelements.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions
                .contextClick(rightClickButton)
                .keyDown(Keys.DOWN)
                .keyDown(Keys.DOWN)
                .keyDown(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        actions
                .contextClick(rightClickButton)
                .keyDown(Keys.DOWN)
                .keyDown(Keys.DOWN)
                .keyDown(Keys.DOWN)
                .build()
                .perform();
        driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"))
                .click();
    }
}
