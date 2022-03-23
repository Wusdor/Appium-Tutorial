import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.TouchAction;
//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ecommerce_tc_5 extends baseNatHyb {

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

		for (int i = 0; i < countAdd; i++) {

			driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

		}

		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

		WebDriverWait wait = new WebDriverWait(driver, 2);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));

		// Mobile gestures

		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

		TouchAction<?> t = new TouchAction<>(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(7000);
		
		Set<String> contexts = driver.getContextHandles();
		
		for (String contextName : contexts) {
			
			System.out.println(contextName);
			
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore"); //switch to specific WebView
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP"); //switch back to mobile application

	}
}
