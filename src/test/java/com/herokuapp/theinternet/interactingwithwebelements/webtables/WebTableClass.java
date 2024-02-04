package com.herokuapp.theinternet.interactingwithwebelements.webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableClass {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']/tbody/tr/td[4]"));
        int total=0;
        for(WebElement element : rows){
            System.out.println("element.getText() = " + element.getText());
            int amount = Integer.parseInt(element.getText());
            total += amount;
        }
        System.out.println("total = " + total);

        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> herokuTable= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        for(WebElement element : herokuTable){
            System.out.println("element.getText() = " + element.getText());
            element.click();
            Thread.sleep(1000);
        }
        List<WebElement> webSiteLinks = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[5]"));
        for(WebElement element : webSiteLinks){
            System.out.println("element.getText() = " + element.getText());

            ((JavascriptExecutor)driver).executeScript("window.open('"+element.getText()+"','_blank')");
            Thread.sleep(1000);
        }
        driver.quit();
    }


}
