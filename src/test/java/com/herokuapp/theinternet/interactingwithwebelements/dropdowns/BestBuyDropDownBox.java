package com.herokuapp.theinternet.interactingwithwebelements.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BestBuyDropDownBox {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-search-input']"));
        searchBox.sendKeys("Laptop");
        WebElement searchButton = driver.findElement(By.xpath("//button[@title='submit search']"));
        searchButton.click();

        WebElement bestMatchDropDown = driver.findElement(By.xpath("//select[@id='sort-by-select']"));
        Select select = new Select(bestMatchDropDown);
        select.selectByValue("Customer-Rating");
        select.selectByIndex(5);
    }
}
