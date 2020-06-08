package com.wikipedia.mobile.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    Articles articles;



    public void init() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "QA23_Nexus5");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");

        capabilities.setCapability("app", "C:/Users/varuw/Documents/GitHub/wikipedia/apk/org.wikipedia.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        articles = new Articles(driver);

    }

    public void stop() {
        driver.quit();
    }

    public Articles getArticles() {
        return articles;
    }

}
