package com.herokuapp.theinternet.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShot
{
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		WebElement email=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement loginButton=driver.findElement(By.id("loginBtn"));
		WebElement forgetPassword=driver.findElement(By.linkText("Forgot my password"));
		email.sendKeys("john");
		password.sendKeys("12345");


		takeElementsScreenshot(email,"email1");
		takeElementsScreenshot(password,"password1");
		takeElementsScreenshot(loginButton,"loginmethod1");
		takeElementsScreenshot(forgetPassword,"forgetpassword");

	}

	public static void takeElementsScreenshot(WebElement element,String filename)throws IOException{

		TakesScreenshot srcShot=  ((TakesScreenshot)element);

		File srcFile= srcShot.getScreenshotAs(OutputType.FILE);
		System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/target/test-output/" + filename + "page.png"));

	}



}
