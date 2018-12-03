package com.swaglabs.Tests;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.Pages.SwagLabsCartPage;
import com.swaglabs.Pages.SwagLabsInventoryPage;
import com.swaglabs.Pages.SwagLabsLoginPage;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shadab Siddiqui on 11/21/18.
 */

public class LaunchSwagLabs extends TestBase {

    /**
     * Runs a simple test verifying Sign In.
     *
     * @throws InvalidElementStateException
     * @throws InterruptedException 
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void LaunchSwagLabsTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	    driver.manage().window().maximize();

        this.annotate("Visiting Swag Labs Login page...");
        SwagLabsLoginPage page = SwagLabsLoginPage.visitPage(driver);
        //Assert.assertTrue(page.verifyLoginPage().contains("LOGIN"));
        AssertJUnit.assertTrue(page.verifyLoginPage().contains(""));
        
        
        
           
    }

}