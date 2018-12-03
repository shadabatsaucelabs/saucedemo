package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsLoginPage {

    
    
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='LOGIN']")
    private WebElement loginButton; 

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/";

    public static SwagLabsLoginPage visitPage(WebDriver driver) {
    	SwagLabsLoginPage page = new SwagLabsLoginPage(driver);
        page.visitPage();
        return page;
    }

    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    
    
    public SwagLabsInventoryPage enterCredentials(String username, String password) throws InterruptedException {
    	//Thread.sleep(5000);
    	usernameTextBox.sendKeys(username);
    	//Thread.sleep(1000);
    	passwordTextBox.sendKeys(password);
        loginButton.click();
        return PageFactory.initElements(driver, SwagLabsInventoryPage.class);
    }
    
    public String verifyLoginPage() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(loginButton));
    	//System.out.println("Value is: "+loginButton.getText());
        return loginButton.getText();
    }

}
