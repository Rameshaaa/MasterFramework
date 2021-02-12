package com.mas.testCases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.mas.resources.MobileFunctionsBase;

public class MobileWebApp {
	
	MobileFunctionsBase objMF = new MobileFunctionsBase();
	
	@Test
	public void mobileLanuch()
	
	{
		try {
			objMF.LaunchMobileWebApp("Android", "rameshemulator", "Chrome");
			objMF.getURL("https://facebook.com/");
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}

}
