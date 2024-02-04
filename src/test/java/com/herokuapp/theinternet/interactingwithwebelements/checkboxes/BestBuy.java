package com.herokuapp.theinternet.interactingwithwebelements.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BestBuy {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bestbuy.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-search-input']"));
        searchBox.sendKeys("Laptop");
        WebElement searchButton = driver.findElement(By.xpath("//button[@title='submit search']"));
        searchButton.click();
        WebElement check64Gig = driver.findElement(By.xpath("//input[@id='systemmemoryram_facet-64-gigabytes-0']"));
        check64Gig.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//fieldset[@name='RAM']//li"));

        for(WebElement element:checkBoxes){
            System.out.println(element.getText());
            if(element.getText().contains("32 giga")
                    || element.getText().contains("18 giga")){
                element.findElement(By.xpath("input")).click();
            }
        }

        for(WebElement element:checkBoxes){
            boolean isSelected = element.findElement(By.xpath("input")).isSelected();
            if(isSelected){
                element.findElement(By.xpath("input")).click();
            }
        }

    }
}
