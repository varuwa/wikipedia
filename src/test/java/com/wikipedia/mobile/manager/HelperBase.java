package com.wikipedia.mobile.manager;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        new WebDriverWait (driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void type(By locator, String text) {
        if(text != null){
            waitForElementLocatedAndClick(locator, 30);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }


    public void swipeElementToLeft(By locator){

        TouchAction touch = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX()*0.2); //left point
        int rightX = (int) ((leftX + element.getSize().getWidth())*0.8); //right point

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY + lowerY)/2;

        touch.press(PointOption.point(rightX, middleY)).waitAction().moveTo(PointOption.point(leftX, middleY)).release().perform();
    }

    public void swipeUp(By locator){
        TouchAction touch = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = element.getLocation().getX(); //left point
        int rightX = leftX + element.getSize().getWidth(); //right point
        int middleX = (leftX + rightX)/2;

        int upperY = (int) (element.getLocation().getY()*0.2);
        int lowerY = (int) ((upperY + element.getSize().getHeight())*0.8);

        touch.press(PointOption.point(middleX, lowerY)).waitAction().moveTo(PointOption.point(middleX, upperY)).release().perform();
    }

    public void swipeUpElement(){
        TouchAction touch = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int middleX = size.width / 2;

       int lowerY = (int) (size.height * 0.8);

       int upperY = (int) (size.height * 0.2);

        touch.press(PointOption.point(middleX, lowerY)).waitAction().moveTo(PointOption.point(middleX, upperY)).release().perform();

    }


    public void waitForElementClickableAndClick(By locator, int timeOut) {
        new WebDriverWait (driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForElementLocatedAndType(By locator, String text, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    public boolean waitForElementsPresent(By locator, int timeout){
        List<WebElement> elements = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elements.size()>0;
    }

    private void waitForElementAndType(By locator, int timeout, String text) {
        waitForElementAndClick(locator, timeout);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void waitForElementAndClick(By locator, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }



}
