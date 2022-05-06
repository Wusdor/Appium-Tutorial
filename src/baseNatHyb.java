import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseNatHyb {

	public static AndroidDriver<AndroidElement> capabilities (String device) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
	
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		switch (device) {
			
			case ("emulator"):
				
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Wusdor");
				break;
				
			case ("real"):
				
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //if you want to set real Android device simply apply this line of code
				break;
		}
		
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome"); //capability for the Mobile browser
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10); // How long (in seconds) will Appium wait for a new command from the client before assuming the client quit and ending the session
		
		driver = new AndroidDriver<>(new URL("http://192.168.0.105:4723/wd/hub"), cap); // 10.1.0.118 - work PC; 10.1.0.117 - mac in the office; 192.168.0.107 - work PC (home); 192.168.0.105 - mac (home)
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}

}
