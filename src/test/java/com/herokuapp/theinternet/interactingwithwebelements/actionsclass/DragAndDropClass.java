package com.herokuapp.theinternet.interactingwithwebelements.actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragAndDropClass {
    public static void main(String[] args) {
        Map<String,String> countryCapitalsMap = new HashMap<>(){{
            put("Rome","Italy");
            put("Oslo","Norway");
            put("Seoul","South Korea");
            put("Washington","United States");
            put("Madrid","Spain");
            put("Copenhagen","Denmark");
            put("Stockholm","Sweden");
        }};

        WebDriver driver = new ChromeDriver();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");

        List<WebElement> capitalCities= driver.findElements(By.xpath("(//div[@id='capitals'])[1]//div[contains(@id,'box')]"));
        List<WebElement> countries = driver.findElements(By.xpath("//div[@id='countries']//div[contains(@id,'box')]"));
        Actions actions = new Actions(driver);
        for (WebElement capital: capitalCities){
            System.out.println("capitals = " + capital.getText());
            String country = countryCapitalsMap.get(capital.getText());
            System.out.println("country = " + country);
            for(WebElement element : countries){
                if(element.getText().equals(country)){
                    actions
                            .clickAndHold(capital)
                            .moveToElement(element)
                            .release()
                            .build()
                            .perform();
                }

            }

        }

    }
}
