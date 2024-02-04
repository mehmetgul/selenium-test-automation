package com.herokuapp.theinternet.interactingwithwebelements.dropdowns;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DeltaDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.delta.com/");
        Thread.sleep(1000);
        WebElement passengerDropDown = driver.findElement(By.xpath("//span[@id='passengers-val']"));
        passengerDropDown.click();
        Thread.sleep(500);
        List<WebElement> numberOfPassengers = driver.findElements(By.xpath("//ul[@id='passengers-desc']/li"));
        for(WebElement element : numberOfPassengers){
            System.out.println("element.getText() = " + element.getText());
            if(element.getText().equals("7 Passengers")){
                element.click();
                break;
            }
        }

        WebElement clickDeparture= driver.findElement(By.xpath("//a[@id='fromAirportName']//span[@class='airport-code d-block']"));
        clickDeparture.click();
        WebElement sendDepartureCity= driver.findElement(By.xpath("//input[@id='search_input']"));
        sendDepartureCity.sendKeys("IST");
        Thread.sleep(500);
//        List<WebElement> cityList = driver.findElements(By.xpath("//div[@class='search-results d-none pl-1 d-block']/ul/li"));
//        for(WebElement element : cityList){
//            if(element.getText().contains("Sabiha")){
//                element.click();
//            }
//        }
//        sendDepartureCity.sendKeys(Keys.DOWN);
//        Thread.sleep(1000);
//        sendDepartureCity.sendKeys(Keys.DOWN);
//        Thread.sleep(1000);
//        sendDepartureCity.sendKeys(Keys.DOWN);
//        Thread.sleep(1000);
       // sendDepartureCity.sendKeys(Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String str = " return document.getElementById('search_input').value";

        String value="";
        int counter=0;
        while (!value.equals("SAW")){
            sendDepartureCity.sendKeys(Keys.DOWN);
            Thread.sleep(1000);
            value= (String) js.executeScript(str);
            if(counter>10)
                throw new RuntimeException();
            counter++;
        }
        sendDepartureCity.sendKeys(Keys.ENTER);



    }
}
