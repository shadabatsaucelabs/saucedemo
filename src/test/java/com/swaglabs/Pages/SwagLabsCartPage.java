package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsCartPage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement backpackLabel;     

    public WebDriver driver;
    

    public SwagLabsCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    

    public String checkBackpackinCart() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(backpackLabel));
    	//System.out.println(productInventory.getText());
        return backpackLabel.getText();
    }
    
    

  
}
