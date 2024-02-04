package com.herokuapp.theinternet.interactingwithwebelements.radiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://designsystem.digital.gov/components/radio-buttons/");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='radio-buttons-preview-content']/fieldset[1]/div"));
        for (WebElement element:radioButtons) {
            WebElement isRadioButtonEnabled = element.findElement(By.xpath("input"));
            if(isRadioButtonEnabled.isEnabled()){
                element.click();
            }else{
                System.out.println("Element "+element.getText()+ " is disabled");
                System.out.printf("Element %s is disabled", element.getText());
            }
        }

    }
}
