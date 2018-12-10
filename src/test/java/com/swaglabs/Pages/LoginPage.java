package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    
    
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='LOGIN']")
    private WebElement loginButton; 
    
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement lockedOutMessage; 
    
  

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/";

    public static LoginPage visitPage(WebDriver driver) {
    	LoginPage page = new LoginPage(driver);
        page.visitPage();
        return page;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    
    
    public InventoryPage enterCredentials(String username, String password) throws InterruptedException {
    	//Thread.sleep(1000);
    	usernameTextBox.sendKeys(username);
    	//Thread.sleep(1000);
    	passwordTextBox.sendKeys(password);
    	//Thread.sleep(4000);
        loginButton.click();
        return PageFactory.initElements(driver, InventoryPage.class);
    }
    
    public boolean verifyLoginPage() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(loginButton));
    	//System.out.println("Value is: "+loginButton.getText());
        return true;
    }
    
    public String verifyLockedOutMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(lockedOutMessage));
    	//System.out.println(lockedOutMessage.getText());
        return lockedOutMessage.getText();
    }

}
