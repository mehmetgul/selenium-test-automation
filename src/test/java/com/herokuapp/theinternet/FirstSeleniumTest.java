package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Use
 * CTRL + ATL + L  => Windows
 * COMMAND + OPTION +L => MAC
 */

/**
 * Create a Java Class
 * Create a main method
 * Setup Chrome Driver
 * Go to https://the-internet.herokuapp.com
 * Get the title and print it in console
 * Get the current url and print it in console
 */
public class FirstSeleniumTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
    }
}
