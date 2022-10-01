package org.example.Page;

import org.example.Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }


    public void compareSize(){
        WebElement element=findElements(By.cssSelector("span[class='cartItem__attrValue']")).get(0);
        String basketSize=element.getText();
        Assert.assertEquals(basketSize, ProductPage.productSize);
        logger.info("beden karsilastirildi");
    }
    public void comparePrice(){
        String basketPrice=getText(By.cssSelector("span[class='cartItem__price -sale']"));
        Assert.assertEquals(basketPrice, ProductPage.productPrice);
        logger.info("fiyat karsilastirildi");
    }

    public Boolean compareSale(){
        String discountPrice = getText(By.cssSelector("span[class='cartItem__price -sale']")).substring(0,4);
        double newPrice = Double.parseDouble(discountPrice);

        String nonDiscountPrice = getText(By.cssSelector("span[class='cartItem__price -old -labelPrice']")).substring(0,4);
        double oldPrice = Double.parseDouble(nonDiscountPrice);

        if (oldPrice > newPrice){
            return true;
        }
         else {
             return false;
        }

    }

    public void proceed(){
        clickElement(By.cssSelector("button[class='continueButton n-button large block text-center -primary']"));
        logger.info("devam edildi");
    }
}
