package org.example.Page;

import org.example.Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

public class HomePage extends BasePage {
    private String url="https://www.network.com.tr/";

    public HomePage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void navigateTo() {
        goToUrl(url);
        logger.info(url + "adresine gidilir");
    }

    public void checkUrl() {
        Assert.assertEquals(url, getUrl());
        logger.info("url kontrol edildi");

    }

    public void search(){
        sendKeys(By.cssSelector("input[name='searchKey']"),"ceket" + Keys.ENTER);
        logger.info("ceket arandi");
    }

    public void clickBasketLogo(){
        clickElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));
        logger.info("sepet logosuna tiklanir");
    }

    public void removeProduct(){
        clickElement(By.cssSelector("div[class='header__basketProductBtn header__basketModal -remove']"));
        logger.info("sepetten urun silinir");
    }

    public void confirmRemove(){
        clickElement(By.cssSelector("button[class='btn -black o-removeCartModal__button']"));
        logger.info("urunun silindigi dogrulandi");
    }

    public void checkBasketEmpty(){
        String emptyBasket=getText(By.cssSelector("span[class='header__emptyBasketText']"));
        Assert.assertEquals(emptyBasket, "Sepetiniz Henüz Boş");
        logger.info("sepetin bos oldugu kontrol edilir");
    }

    public void closePopUp(){
        clickElement(By.id("onetrust-accept-btn-handler"));
    }
}
