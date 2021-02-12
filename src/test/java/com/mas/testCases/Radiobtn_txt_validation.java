package com.mas.testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mas.ObjectRepo.ObjectRepository;
import com.mas.excelUtils.ExcelUtils;
import com.mas.resources.WebFunctionsBase;

public class Radiobtn_txt_validation implements ObjectRepository {
	
	WebFunctionsBase objWD = new WebFunctionsBase();
	ExcelUtils d = new ExcelUtils();
		
					
	@BeforeTest
	public void launchURL() throws IOException
	{
		objWD.getWebDriver();
		
	}
	
	@Test
	public void radiobtn() throws InterruptedException, IOException
	
	{
		List<String> data=d.getData("Radiobtn_txt_validation","Data");
		String text = data.get(1);
		
		objWD.click(radiobtn1);
		Thread.sleep(2000);
		objWD.Entertext(textbox, text);
		Thread.sleep(2000);
		objWD.dropdown(dropdown, 3);
		Thread.sleep(2000);
		objWD.click(Alert);
		objWD.AlertAccept();
		objWD.screenshot();
		objWD.click(openwindow);
		objWD.switchWindow();
		objWD.ExplicitWait(practiceLink, "VISIBILITY");
		objWD.click(practiceLink);
	
	
	}
	
	@AfterTest
	public void close()
	
	{
		objWD.close();
	}
	
	

		
}
