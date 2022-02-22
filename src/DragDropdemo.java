import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragDropdemo extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		TouchAction<?> t = new TouchAction<>(driver);
		
		//longpress(source)/move(destination)/release
		
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		
		//t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform(); //use when you need to perform multiple actions
		t.longPress(element(source)).moveTo(element(destination)).release().perform(); //use only when you don't need to perform any other actions like "duration", "position" etc.

	}

}
