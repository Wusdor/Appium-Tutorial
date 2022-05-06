package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//All the objects belonging to one page will be defined in one java class

public class HomePage {

	// Call the driver object from testcase to PageObject file; concatenate driver

	public HomePage(AppiumDriver<AndroidElement> driver) { // Constructor; AppiumDriver and AndroidDriver both runs in a
															// similar fashion

		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // AppiumFieldDecorator this gives you
																			// compatibility to run across Android and
																			// IOS

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']") // annotation for Android application, for
																			// defining element locator for further use
	public WebElement preferences;

}
