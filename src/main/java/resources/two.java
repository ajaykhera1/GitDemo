package resources;


import org.testng.annotations.Test;
import org.testng.annotations.Test;



import org.testng.annotations.Test;



import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import XpathPages.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tesst.BaseCapability;

public class two extends BaseCapability {

	@Test
	public void test1() throws Exception {
		// TODO Auto-generated method stub
	service=StartServer();
	emulator();
	Thread.sleep(15000);
	
		AndroidDriver<AndroidElement> driver=capability2("App");
		MenuPage p= new MenuPage(driver);
		p.preference().click();
		//Thread.sleep(5000);
	
		
	}
	
	@BeforeTest
	public void killservices() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(15000);
	}

}
