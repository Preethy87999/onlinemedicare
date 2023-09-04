package com.simplilearn.medicare;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddItems {
	WebDriver driver = null;
	
	By pagenav = By.cssSelector("a[href='/medicare/show/all/products']");
	By singleitem = By.cssSelector("a[href='/medicare/show/1/product']");
	By btnSuccess = By.xpath("(//a[@class='btn btn-success'])[1]");
	By cartaccess = By.id("dropdownMenu1");
	By cart = By.id("cart");
	
	public  AddItems(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addSingleItem() {
		driver.findElement(pagenav).click();
	}
	
	public void btnforadd() {
		driver.findElement(btnSuccess).sendKeys(Keys.RETURN);
	}
	
	public void cartpage() {
		driver.findElement(cartaccess).click();
		driver.findElement(cart).click();
	}
}
