package AppiumAWSTest.AppiumSample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AndoridNativeAWSTest {
  public static AndroidDriver<?> mobiledriver;

  @AndroidFindBy(id = "com.android.calculator2:id/digit_2")
  @iOSFindBy(id ="2")
  public MobileElement digit2;

  @AndroidFindBy(id = "com.android.calculator2:id/digit_8")
  @iOSFindBy(id ="2")
  public MobileElement digit8;

  @BeforeTest
  public void beforeTest( ) throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest
  public void afterTest( ) {
    mobiledriver.quit();
  }

  @Test
  public void launchApp() {

    digit2.click();
    mobiledriver.findElementByAccessibilityId("add").click();
    digit8.click();
    mobiledriver.findElementByAccessibilityId("equals").click();
    String results=mobiledriver.findElementById("Result").getText();
    Assert.assertEquals(results, "10", "Result Mismatch");
    //    mobiledriver.findElementByAccessibilityId("New note").click();
    //    mobiledriver.findElementById("com.example.android.notepad:id/note").sendKeys("New Note from test");
    //    mobiledriver.findElementByAccessibilityId("Save").click();
    //    String noteName = mobiledriver.findElementById("android:id/text1").getText();
    //    Assert.assertEquals(noteName, "New Note from test", "Name Mismatch");
  }
}
