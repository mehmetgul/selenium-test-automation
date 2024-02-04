package com.herokuapp.theinternet.interactingwithwebelements.elementpresent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ElementIsPresent {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//button[normalize-space()='Add Element']"));
        // addElement.click();
        List<WebElement> deleteButton = driver.findElements(By.xpath("//button[normalize-space()='Delete']"));
        if (!deleteButton.isEmpty()) {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.get(0).isDisplayed());
        } else {
            System.out.println("Element is not available");
        }

        if (deleteButton.size() > 0) {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.get(0).isDisplayed());
        } else {
            System.out.println("Element is not available");
        }
        int retries = 0, maxRetries = 3;

        while (retries < maxRetries) {
            try {
                WebElement deleteButton1 = driver.findElement(By.id("//button[normalize-space()='Delete']"));
                System.out.println("deleteButton1.isDisplayed() = " + deleteButton1.isDisplayed());
            } catch (Exception e) {
                Thread.sleep(1000); // sleep for 1 second
                System.out.println("Retry #: "+retries);
            }
            retries++;
        }


    }
}
