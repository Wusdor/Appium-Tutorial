import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;

public class ecommerce_tc_3 extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("emulator");

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"Argentina\").instance(0))")); //perform this if
		// upper one fails
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
				+ "new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size(); // only finds the
																										// visible
																										// elements

		for (int i = 0; i < count; i++) {
			
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				
				break;
				
			}

		}
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals(lastpageText, "Jordan 6 Rings");

	}

}
