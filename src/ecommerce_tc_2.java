import java.net.MalformedURLException;

import org.testng.Assert;

//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("emulator");

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name"); // name
																											// attribute
																											// for toast
																											// messages
																											// will have
																											// a content

		System.out.println(toastMessage);
		
		Assert.assertEquals(toastMessage, "Please enter your name"); //Actual validation

	}

}
