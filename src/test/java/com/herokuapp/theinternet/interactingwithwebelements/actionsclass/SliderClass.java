package com.herokuapp.theinternet.interactingwithwebelements.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");
        driver.switchTo().frame(0);
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
//        Actions actions = new Actions(driver);
//        actions
//                .moveToElement(slider)
//                .clickAndHold()
//                .moveByOffset(200,0)
//                .release()
//                .perform();

        for(int i =0; i<=100;i++){
            moveSliderWithJs(driver,slider,i);
            Thread.sleep(100);
        }

    }
    public static void  moveSliderWithJs(WebDriver driver, WebElement sliderLocator,int positionPercentage){
        String script ="arguments[0].style.left='"+positionPercentage+"%';";
        ((JavascriptExecutor)driver).executeScript(script,sliderLocator);

        String scripTriggerEvent= "var event = new Event('change'); arguments[0].dispatchEvent(event);";
        ((JavascriptExecutor)driver).executeScript(scripTriggerEvent,sliderLocator);
    }
}
