package com.herokuapp.theinternet.interactingwithwebelements.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class IframeTestClassNestedEnhanced {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dezlearn.com/nested-iframes-example/");

        List<Integer> iAmNotARobotList= findElementsInFrames(driver,By.xpath("//button[@id='u_5_5']"));
        System.out.println("iAmNotARobotList = " + iAmNotARobotList);
        if(iAmNotARobotList.size() ==1){
            driver.switchTo().frame(iAmNotARobotList.get(0));
            WebElement iAmNotARobot= driver.findElement(By.xpath("//button[@id='u_5_5']"));
            iAmNotARobot.click();
        } else if (iAmNotARobotList.size() >1) { //[0,2,1]
            for(int index : iAmNotARobotList){
                driver.switchTo().frame(index);
            }
            WebElement iAmNotARobot= driver.findElement(By.xpath("//button[@id='u_5_5']"));
            iAmNotARobot.click();
        }else {
            System.out.println("Not a root iframe found");
        }
        if(isInFrame(driver)){
            driver.switchTo().defaultContent();
        }
        Thread.sleep(1000);
        List<Integer> verifyButtonList =  findElementsInFrames(driver,By.xpath("//button[@id='u_5_6']"));
        System.out.println("verifyButtonList = " + verifyButtonList);
        if(verifyButtonList.size()==1){
            driver.switchTo().frame(verifyButtonList.get(0));
            WebElement verifyButton = driver.findElement(By.xpath("//button[@id='u_5_6']"));
            verifyButton.click();
        } else if (verifyButtonList.size()>1) {
            for(int index: verifyButtonList){
                driver.switchTo().frame(index);
            }
            WebElement verifyButton = driver.findElement(By.xpath("//button[@id='u_5_6']"));
            verifyButton.click();
        }else {
            System.out.println("Frame didn't find");
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
