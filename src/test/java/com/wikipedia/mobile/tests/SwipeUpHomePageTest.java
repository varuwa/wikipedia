package com.wikipedia.mobile.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SwipeUpHomePageTest extends TestBase {

    @Test
    public void testHomePageSwipeUp(){
    app.getArticles().swipeUp(By.xpath("//*[@resource-id='org.wikipedia:id/fragment_feed_feed']"));

    }

    @Test
    public void testHomePageSwipeUpScreen(){
        app.getArticles().swipeUpElement();

    }
}
