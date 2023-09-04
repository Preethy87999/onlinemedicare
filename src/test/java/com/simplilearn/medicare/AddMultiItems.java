package com.simplilearn.medicare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddMultiItems {

WebDriver driver = null;
	
	By pagenav = By.cssSelector("a[href='/medicare/show/all/products']");
	By item1 = By.cssSelector("a[href='/medicare/show/2/product']");
	By addcart = By.cssSelector(".btn.btn-success");
	By continuebtn = By.cssSelector(".btn.btn-warning");
	By item2 = By.xpath("(//a[@class='btn btn-success'])[3]");
	By btnSuccess = By.xpath("(//a[@class='btn btn-success'])[1]");
	
	public  AddMultiItems(WebDriver driver) {
		this.driver = driver;
	}
	
	public void multiProducts() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(pagenav).click();
		Thread.sleep(2000);
		driver.findElement(item1).click();
		Thread.sleep(2000);
		driver.findElement(addcart).click();
		Thread.sleep(1000);
		driver.findElement(continuebtn).click();
		Thread.sleep(1000);
		driver.findElement(item2).click();
	}
}
