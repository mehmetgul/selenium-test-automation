package com.herokuapp.theinternet.interactingwithwebelements.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class IframeTestClassHeroku {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        List<Integer> iAmNotARobotList= findElementsInFrames(driver,By.xpath("//p[normalize-space()='Your content goes here.']"));
        System.out.println("iAmNotARobotList = " + iAmNotARobotList);
        if(iAmNotARobotList.size() ==1){
            driver.switchTo().frame(iAmNotARobotList.get(0));
            WebElement iAmNotARobot= driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
            iAmNotARobot.sendKeys("   Bu text I frame icine konmustur");
        } else if (iAmNotARobotList.size() >1) { //[0,2,1]
            for(int index : iAmNotARobotList){
                driver.switchTo().frame(index);
            }
            WebElement iAmNotARobot= driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
            iAmNotARobot.sendKeys("   Bu text I frame icine konmustur");
        }else {
            System.out.println("Not a root iframe found");
        }
        if(isInFrame(driver)){
            driver.switchTo().defaultContent();
        }

    }

    public static boolean isInFrame(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean isInFrame = (boolean) executor.executeScript("return window.top !== window.self;");
        return  isInFrame;
    }

    public static List<Integer>  findElementsInFrames(WebDriver driver, By by){
        List<Integer> framePath = new ArrayList<>();
        findElementsInFrameRecursive(driver,by,framePath);
        return framePath;

    }

    private static boolean findElementsInFrameRecursive(WebDriver driver, By by, List<Integer> framePath) {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < iframes.size(); i++) {
            driver.switchTo().frame(i);
            if(driver.findElements(by).size()>0){
                driver.switchTo().defaultContent();
                framePath.add(i);
                return true;
            }
            if(findElementsInFrameRecursive(driver, by,framePath)){
                framePath.add(0,i);
                return  true;
            }
            driver.switchTo().parentFrame();
        }
        if(framePath.isEmpty()){
            driver.switchTo().defaultContent();
        }
        return false;
    }

    /**
     * Nested Degilse
     * 0. frame 1. frame 2. frane [1]
     *
     * Nested Frame
     * 1. frame e , Sonra 3. frame git, 1. frame [1,3,1]
     */
}
