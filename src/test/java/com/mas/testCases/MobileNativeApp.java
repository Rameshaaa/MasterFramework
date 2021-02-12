package com.mas.testCases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.mas.resources.MobileFunctionsBase;

public class MobileNativeApp {
	
	MobileFunctionsBase objMF = new MobileFunctionsBase();
	
	@Test
	public void NativeApp() throws MalformedURLException
	{
		objMF.LaunchNativeApp("Android", "rameshemulator", "com.android.contacts", "com.android.contacts.activities.PeopleActivity");
		
	}
	

}
