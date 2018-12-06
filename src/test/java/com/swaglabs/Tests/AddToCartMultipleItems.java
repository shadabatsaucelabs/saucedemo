package com.swaglabs.Tests;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.Pages.LoginPage;
import com.swaglabs.Pages.SwagLabsCartPage;
import com.swaglabs.Pages.SwagLabsInventoryPage;


import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shadab Siddiqui on 11/21/18.
 */

public class AddToCartMultipleItems extends TestBase {

    /**
     * Runs a simple test verifying Sign In.
     *
     * @throws InvalidElementStateException
     * @throws InterruptedException 
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void AddToCartMultipleItemsTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	    driver.manage().window().maximize();

        this.annotate("Visiting Swag Labs Login page...");
        LoginPage page = LoginPage.visitPage(driver);
        
        this.annotate("Greet Sign In To Swag Labs Page...");
        SwagLabsInventoryPage inventory = page.enterCredentials("standard_user", "secret_sauce");
         
        this.annotate("View Product Inventory...");
        AssertJUnit.assertTrue(inventory.viewInventory().contains("Products"));
         
        this.annotate("Add To Cart Backpack...");
        inventory.clickAddToCartBackpack();
        
        this.annotate("Add To Cart Bolt Tshirt...");
        inventory.clickAddToCartBoltTshirt();  
        
        this.annotate("Add To Cart Onesie...");
        inventory.clickAddToCartOnesie();
        
        this.annotate("Go To Cart...");
        SwagLabsCartPage cart = inventory.goToCart();
         
        this.annotate("Verify Backpack In Cart...");
        AssertJUnit.assertTrue(cart.verifyBackpackinCart().contains("Sauce Labs Backpack"));
        
        this.annotate("Verify Bolt T-shirt In Cart...");
        AssertJUnit.assertTrue(cart.verifyBoltTshirtinCart().contains("Sauce Labs Bolt T-Shirt"));
        
        this.annotate("Verify Onesie In Cart...");
        AssertJUnit.assertTrue(cart.verifyOnesieinCart().contains("Sauce Labs Onesie"));
        
           
    }

}