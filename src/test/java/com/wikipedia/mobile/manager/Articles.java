package com.wikipedia.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Articles extends HelperBase {
    public Articles(AppiumDriver driver) {
        super(driver);
    }


    public void searchArticle() {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/search_container']"));
        type(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"), "Petra");

    }

    public void chooseSearchedArticle() {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
    }

    public void clickOnAddToFavorite() {
        click(By.xpath("//*[@content-desc='Add this article to a reading list']"));
    }


    public void createReadingList() {
        click(By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button'"));
        type(By.xpath("//*[@resource-id='org.wikipedia:id/text_input'"), "Jordan");
        click(By.xpath("//*[@resource-id='android:id/button1'"));
        click(By.xpath("//*[@content-desc='Navigate up']"));
    }
}
