package ru.gb.tests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstTest {
    @Test
    public void CheckEmptyEmail() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:deviceName", "Pixel");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:app", "C:\\Users\\Vidok1215\\Downloads\\Android-NativeDemoApp-0.2.1.apk");
        capabilities.setCapability( "appium:automationName", "UiAutomator2");

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


        Thread.sleep(2000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);
        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();
        Thread.sleep(2000);
        MobileElement errorText = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorText.getText(),"Please enter a valid email address");

        driver.quit();


    }
}
