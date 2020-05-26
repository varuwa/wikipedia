package com.wikipedia.mobile.tests;

import org.testng.annotations.Test;

public class ArticlesTests extends TestBase {

    @Test
    public void addArticleToFavoriteAndDelete(){
        app.getArticles().searchArticle();
        app.getArticles().chooseSearchedArticle();
        app.getArticles().clickOnAddToFavorite();
        app.getArticles().createReadingList();


    }
}
