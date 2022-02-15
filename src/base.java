import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities () throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
	
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Wusdor");
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		driver = new AndroidDriver<>(new URL("http://10.1.0.118:4723/wd/hub"), cap);
		
		return driver;

	}

}
