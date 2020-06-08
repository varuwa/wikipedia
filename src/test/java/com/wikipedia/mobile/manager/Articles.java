package com.wikipedia.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Articles extends HelperBase {
    public Articles(AppiumDriver driver) {
        super(driver);
    }


    public void searchArticle(String text) {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/search_container']"));
        type(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"), text);

    }

    public void chooseSearchedArticle() {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
    }

    public void clickOnAddToFavorite() {
        click(By.xpath("//*[@content-desc='Add this article to a reading list']"));
    }


    public void createReadingList(String text) {
        click(By.id("org.wikipedia:id/onboarding_button"));
        type(By.id("org.wikipedia:id/text_input"), text);
        click(By.id("android:id/button1"));
        click(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void goToFavorites(){
        click(By.xpath("//*[@content-desc='My lists']"));
        click(By.xpath("//*[@resource-id='org.wikipedia:id/item_title']"));
    }


    public void deleteArticleBySwipeToLeft() {
        swipeElementToLeft(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']"));
    }



    public boolean checkArticlePresent() {
        return isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']"));
    }

    public String getArticleName() {
        return driver.findElement(By
                .xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']")).getText();
    }



}
