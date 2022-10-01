package org.example.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    protected static Logger logger;

    public BasePage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(this.driver, 10, 500);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickElement(By by) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollPage(By by) {
        Actions actions = new Actions(driver);
        WebElement element = findElement(by);
        actions.moveToElement(element).perform();
    }

    public void sendKeys(By by, CharSequence text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(text);
    }

    public void goToUrl(String url) {

        driver.get(url);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void hoverElementByIndex(By by, int i) {
        Actions actions = new Actions(driver);
        WebElement element = findElements(by).get(i);
        actions.moveToElement(element).build().perform();
    }
    public void randomClick(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Random random = new Random();
        List<WebElement> products = findElements(by);
        int number = 0;
        number = random.nextInt(products.size());
        try {
            products.get(number).click();
        } catch (Exception e) {

            executor.executeScript("arguments[0].click();", products.get(number));
        }
    }

    public Boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

}

