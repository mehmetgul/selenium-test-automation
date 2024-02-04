package com.herokuapp.theinternet.interactingwithwebelements.multiplewindows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultipleWindowHandles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String parenWindow = driver.getWindowHandle();
        System.out.println("parenWindow = " + parenWindow);
        List<WebElement> urlList = driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul/li/a"));
        scrollTo(driver, urlList.get(0));
        Actions actions = new Actions(driver);
        for (WebElement element : urlList) {
            actions
                    .moveToElement(element)
                    .keyDown(Keys.SHIFT)
                    .click()
                    .build()
                    .perform();
        }

        Set<String> windows = driver.getWindowHandles();
        System.out.println("windows = " + windows);
        Iterator<String> windowsIterator = windows.iterator();
        String parent = windowsIterator.next();
        System.out.println("parent = " + parent);

        while (windowsIterator.hasNext()) {
            String child = windowsIterator.next();
            driver.switchTo().window(child);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            System.out.println("driver.getWindowHandles() = " + driver.getWindowHandle());
            driver.close();
            Set<String> windows1 = driver.getWindowHandles();
            System.out.println("windows1 = " + windows1);
            driver.switchTo().window(parenWindow);
            driver.get("https://google.com");
        }



        //Alternate way of switching among tabs
//        List<String> list = new ArrayList<>(windows);
//        System.out.println("list = " + list);
//        for (int i =1; i<list.size();i++) {
//            String child = list.get(i);
//            driver.switchTo().window(child);
//            System.out.println("driver.getTitle() = " + driver.getTitle());
//            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
//            System.out.println("driver.getWindowHandles() = " + driver.getWindowHandle());
//            driver.close();
//        }

    }

    public static void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
