package com.mas.ObjectRepo;

import org.openqa.selenium.By;

public interface ObjectRepository {
	
	public static By radiobtn1 = By.xpath("(//input[@type='radio'])[1]");
	public static By textbox= By.xpath("(//input[@type='text'])[1]");
	public static By dropdown = By.xpath("//select[@id='dropdown-class-example']");
	public static By openwindow = By.cssSelector("button[id='openwindow']");
	public static By practiceLink = By.xpath("//a[contains(text(),'Practice')]");
	public static By Alert = By.cssSelector("#alertbtn");
	
	

}
