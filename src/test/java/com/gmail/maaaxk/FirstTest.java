package com.gmail.maaaxk;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by max on 02.05.17.
 */
public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/max/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://mail.ukr.net/desktop/login");
    }

    @Test
    public void userLogin(){
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("maaax.k");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("TestPass123");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("maaax.k@ukr.net", mailUser);
    }

    @AfterClass
    public static void tearDown(){
        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        driver.quit();
    }

}
