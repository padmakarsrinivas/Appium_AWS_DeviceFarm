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
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndoridNativeAWSTest {
  public static AndroidDriver<?> mobiledriver;

  @AndroidFindBy(accessibility = "New note")
  public MobileElement newNote;

  @AndroidFindBy(id = "com.example.android.notepad:id/note")
  public MobileElement typeNote;

  @AndroidFindBy(accessibility = "Save")
  public MobileElement saveNote;

  @AndroidFindBy(id = "android:id/text1")
  public MobileElement firstListNote;

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
  public void addNotes() {
    newNote.click();
    typeNote.sendKeys("New Note from test !!!!!");
    saveNote.click();
    String noteName = firstListNote.getText();
    Assert.assertEquals(noteName, "New Note from test", "Name Mismatch");
  }
}
