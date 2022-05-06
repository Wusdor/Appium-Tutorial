import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class basics extends baseNatHyb {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("real");

		HomePage home = new HomePage(driver); // Constructor of the class will be invoked after you create object for
												// the class; constructor can be defined with arguments; if you did not
												// provide a constructor it invokes a default one

		Preferences preferences = new Preferences(driver);
		
		home.preferences.click(); // you can call objects or variables of the class with class object
		
		// driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		preferences.preferenceDependecies.click();
		
		
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		
		preferences.widgetButtons.get(1).click();
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
