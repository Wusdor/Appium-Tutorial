package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {

	public Preferences(AppiumDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement preferenceDependecies;
	
	@AndroidFindBy(className = "android.widget.Button") 
	public List<WebElement> widgetButtons; //use List class for plural elements

}