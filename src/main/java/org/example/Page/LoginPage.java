package org.example.Page;

import org.apache.log4j.Logger;
import org.example.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void enterUserInfo() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/test/resources/userInfo.csv"));
        sc.useDelimiter(",");
        String[] array=new String[2];
        array[0]=sc.nextLine();
        String mail = array[0];

        array[1]=sc.nextLine();
        String password=array[1];

        sendKeys(By.cssSelector("input[name='Email']"),mail);
        sendKeys(By.cssSelector("input[name='Password']"),password);
    }

    public void loginButtonExist(){
        isDisplayed(By.cssSelector("button[class='n-button large block text-center -primary ']"));
    }

    public  void clickLogo(){

        clickElement(By.cssSelector("a[class='headerCheckout__logo']"));
    }


}
