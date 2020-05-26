package com.wikipedia.mobile.manager;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
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

    public void swipeToLeft(By locator){
        TouchAction action = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX() * 0.2);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY + lowerY)/2;

        action.press(PointOption.point(rightX, middleY)).moveTo(PointOption.point(leftX, middleY)).release().perform();
    }

    public void swipeToRight(By locator){
        TouchAction action = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX() * 0.2);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY + lowerY)/2;

        action.press(PointOption.point(leftX, middleY)).moveTo(PointOption.point(rightX, middleY)).release().perform();
    }

    public void swipeUp(){
        Dimension size = driver.manage().window().getSize();
        TouchAction action = new TouchAction(driver);

        int middleX = size.width/2;

        int startY = (int) (size.height*0.7);
        int stopY = (int) (size.height*0.2);

        action.press(PointOption.point(middleX, startY)).moveTo(PointOption.point(middleX, stopY)).release().perform();
    }

    public void waitForElementClickableAndClick(By locator, int timeOut) {
        new WebDriverWait (driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForElementLocatedAndType(By locator, String text, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean waitForElementsPresent(By locator, int timeout){
        List<WebElement> elements = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elements.size()>0;
    }

}