package com.herokuapp.theinternet.interactingwithwebelements.flowmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlowMethodsTest {
    public static void main(String[] args) {

        FlowMethodsTest flowMethodsTest =new FlowMethodsTest();
        //Setup Driver
        WebDriver driver = new ChromeDriver();
        //Open the website
        driver.get("https://the-internet.herokuapp.com/");
        //Get Title
        String title = driver.getTitle();
        System.out.println("title = " + title);
        //Get Current Url
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        //Get Page Source
        String pageSource= driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        //Navigate Methods
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        waitFor(500);
        driver.navigate().forward();
        waitFor(500);
        driver.navigate().refresh();
        navigateTo(driver,"https://www.amazon.com");
        getCurrentPAgeTitle(driver);

        //driver.close();
        driver.quit();
        //quitflowMethodsTest.closeDriver(driver);

    }

    public static void  navigateTo(WebDriver driver, String url){
        driver.get(url);
    }
    public static void getCurrentPAgeTitle(WebDriver driver){
        driver.getTitle();
    }

    public static void getCurrentPageSource(WebDriver driver){
        driver.getPageSource();
    }
    public static void getCurrentPAgeUrl(WebDriver driver){
        driver.getCurrentUrl();
    }
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public void closeDriver(WebDriver driver){
        driver.close();
    }
    public static void quiteDriver(WebDriver driver){
        driver.quit();
    }



    public static void waitFor(long milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
