import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


import io.appium.java_client.TouchAction;
//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_4 extends baseNatHyb {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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
		
		int countAdd = driver.findElementsByXPath("//*[@text='ADD TO CART']").size();
		
		for (int i=0; i<countAdd; i++) {
			
			driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
			
		}
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		//Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
		
		int countPrice = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum = 0;
		
		for (int i=0; i<countPrice; i++) {
			
			String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amountValue = getAmount(amount);
			sum = sum + amountValue;
		}
		
		System.out.println("Sum of products: " + sum);
		
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		
		double totalValue = getAmount(total);
		
		System.out.println("Total value of products: " + totalValue);
		
		Assert.assertEquals(totalValue, sum);
		
		//Mobile gestures
		
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		
		TouchAction<?> t = new TouchAction<>(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}
	
	public static double getAmount(String value) {
		
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		
		return amountValue;
	}
}
