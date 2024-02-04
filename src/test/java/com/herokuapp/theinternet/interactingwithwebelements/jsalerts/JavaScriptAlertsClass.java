package com.herokuapp.theinternet.interactingwithwebelements.jsalerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.util.Properties;

public class JavaScriptAlertsClass {
    public static void main(String[] args) throws InterruptedException, FindFailed {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton=driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']"));
        WebElement confirmAlertButton=driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']"));
        WebElement promptAlertButton=driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));

        alertButton.click();
        String alertText= driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        confirmAlertButton.click();
        String confirm =driver.switchTo().alert().getText();
        System.out.println("confirm = " + confirm);
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        promptAlertButton.click();
        String promptText =driver.switchTo().alert().getText();
        System.out.println("promptText = " + promptText);
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("This is Testing");
        driver.switchTo().alert().sendKeys("This is Testing1");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }
}
