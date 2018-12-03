package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsInventoryPage {

    @FindBy(xpath = "//div[@class='product_label']")
    private WebElement productInventory;  

    @FindBy(xpath = "//div//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    private WebElement addToCartBackpackButton;
    
    @FindBy(xpath = "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    private WebElement cartIcon;
    
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutLink; 
    
    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    private WebElement menuButton; 
    
  
  

    public WebDriver driver;
    

    public SwagLabsInventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    

    public String viewInventory() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(productInventory));
    	//System.out.println(productInventory.getText());
        return productInventory.getText();
    }
    
    public void clickAddToCartBackpack() {
    	
    	addToCartBackpackButton.click();
  	    
    }
    
    public SwagLabsCartPage goToCart() {
    	
    	cartIcon.click();
    	    	
  	    return PageFactory.initElements(driver, SwagLabsCartPage.class);
  	    
    }
    
    public void clickMenuButton() {
    	
    	menuButton.click();
  	    
    }
    
    public void clickLogout() {
    	
    	logoutLink.click();
  	    
    }

  
}
