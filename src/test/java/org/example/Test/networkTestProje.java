package org.example.Test;

import org.example.Page.BasketPage;
import org.example.Page.HomePage;
import org.example.Page.LoginPage;
import org.example.Page.ProductPage;
import org.example.base.BaseTest;
import org.junit.Test;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class networkTestProje extends BaseTest {
     final static  Logger logger = Logger.getLogger(networkTestProje.class.getName());

    @Test
    public void networkSeleniumTest() throws InterruptedException, FileNotFoundException {
        HomePage homePage = new HomePage(driver, logger);
        ProductPage productPage = new ProductPage(driver, logger);
        BasketPage basketPage = new BasketPage(driver, logger);
        LoginPage loginPage=new LoginPage(driver,logger);

        homePage.navigateTo();
        homePage.closePopUp();
        homePage.checkUrl();
        homePage.search();
        productPage.scrollAndClick();
        productPage.checkSecondPageUrl();
        productPage.hoverOnProduct();
        productPage.selectRandomProduct();
        productPage.getPrice();
        productPage.getSize();
        productPage.goToBasket();
        basketPage.comparePrice();
        basketPage.compareSize();
        basketPage.compareSale();
        basketPage.proceed();
        loginPage.enterUserInfo();
        loginPage.loginButtonExist();
        loginPage.clickLogo();
        homePage.clickBasketLogo();
        homePage.removeProduct();
        homePage.confirmRemove();
        homePage.clickBasketLogo();
        homePage.checkBasketEmpty();

    }
}
