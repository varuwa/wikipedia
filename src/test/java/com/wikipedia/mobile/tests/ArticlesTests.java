package com.wikipedia.mobile.tests;

import org.testng.annotations.Test;

public class ArticlesTests extends TestBase {

    @Test
    public void testAddArticleToFavorites(){
        app.getArticles().searchArticle("Petra");
        app.getArticles().chooseSearchedArticle();
        app.getArticles().clickOnAddToFavorite();
        app.getArticles().createReadingList("Jordan");
        app.getArticles().goToFavorites();
        app.getArticles().checkArticlePresent();
    }

    @Test
    public void testDeleteFromFavorites(){
        if(!app.getArticles().checkArticlePresent()){
            app.getArticles().goToFavorites();
            app.getArticles().checkArticlePresent();
        }
        if(app.getArticles().checkArticlePresent()) {
            app.getArticles().deleteArticleBySwipeToLeft();
        }
        //CheckListIsEmpty
    }

}
