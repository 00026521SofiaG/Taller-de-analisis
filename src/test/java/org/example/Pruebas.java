package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Pruebas {

    public WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickBuscarenGoogle(){
        WebElement buscarbtnGoo;
        buscarbtnGoo = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
        buscarbtnGoo.click();
    }

    public void logIn(){
        WebElement loginUserName;
        WebElement passwordUser;
        WebElement btnLogin;
        loginUserName = driver.findElement(By.cssSelector("#user-name"));
        loginUserName.sendKeys("standard_user");
        passwordUser = driver.findElement(By.cssSelector("#password"));
        passwordUser.sendKeys("secret_sauce");
        btnLogin = driver.findElement(By.cssSelector("#login-button"));
        btnLogin.click();
    }

    public void addToCart(){
        WebElement addbtn;
        WebElement addbtn2;
        addbtn= driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addbtn.click();
        addbtn2= driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        addbtn2.click();
    }

    public void shoppingCart(){
        WebElement cart;
        WebElement remove;
        cart = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        cart.click();
        remove = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        remove.click();

    }

    public void checkout(){
        WebElement checkout;
        checkout =driver.findElement(By.cssSelector("#checkout"));
        checkout.click();
    }

    @Test
    public void test(){
        setUp();
        //clickBuscarenGoogle();
        logIn();
        addToCart();
        shoppingCart();
    checkout();
        //driver.quit();
    }
}

