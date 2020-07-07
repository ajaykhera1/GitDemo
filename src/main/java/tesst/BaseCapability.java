package tesst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseCapability  {
	
	public static AndroidDriver<AndroidElement> driver;
	
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService StartServer()
		{
		boolean flag=checkIfServerIsRunnning(4723);
		
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}

public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

public static void emulator() throws IOException
{
	//C:\Users\Ajay\eclipse-workspace\AppiumFramework\src\main\resources\StartEmulator.bat
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\StartEmulator.bat");
	
}

public static void getscreenshot(String s) throws IOException
{
	System.out.println("screenshot begin");
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

File target= new File("C:\\Users\\Ajay\\eclipse-workspace\\AppiumFramework\\screenshot.png");
	FileUtils.copyFile(scrFile, target);
	System.out.println("screenshot end");
}

	public static  AndroidDriver<AndroidElement> capability2(String App) throws Exception 
	{
	
		
		
FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
Properties prop= new Properties();
prop.load(fis);
File f= new File("src");
File Application=new File(f,(String) prop.get(App));
DesiredCapabilities cap= new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("DEVICE_NAME"));
cap.setCapability(MobileCapabilityType.APP, Application.getAbsolutePath());
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);

URL U=new URL("http://127.0.0.1:4723/wd/hub");
AndroidDriver<AndroidElement> driver= new AndroidDriver<AndroidElement>(U,cap);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

//C:\Users\Ajay\eclipse-workspace\AppiumFramework\src\main\java\Global.properties
	}
}

