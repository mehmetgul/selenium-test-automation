package com.herokuapp.theinternet.interactingwithwebelements.multiplewindows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultipleWindowsHandle {
    public static void main(String[] args) throws InterruptedException {
        //Setting up the driver and initialize the driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String parentId = driver.getWindowHandle();
        System.out.println("parentId = " + parentId);

        List<WebElement> urls=driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul/li/a"));
        //Scrolling to the element
        scrollToElement(driver,urls.get(0));

        Actions a = new Actions(driver);
        for(WebElement url:urls){
            //a.moveToElement(url).keyDown(Keys.CONTROL).click().build().perform(); //For windows users
            a.moveToElement(url).keyDown(Keys.COMMAND).click().build().perform();
        }
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        //Using iteration to switch between windows
        Iterator<String> window= allWindows.iterator();
        String parent = window.next();

        while (window.hasNext()){
            String child= window.next();
            driver.switchTo().window(child);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            Thread.sleep(1000);
            driver.close(); //For closing the current tab use driver.close()
        }
        driver.switchTo().window(parent);

        //Another way of iterating the windows
      /*  List<String> windows = new ArrayList<>(allWindows);
        for (int i = 1; i <windows.size() ; i++) {
            driver.switchTo().window(windows.get(i));
            System.out.println("driver.getTitle() = " + driver.getTitle());
             System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            Thread.sleep(1000);
        }*/
        Thread.sleep(5000);
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
