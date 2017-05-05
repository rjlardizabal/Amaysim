package com.au.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AmaysimLoginPage {
    private WebDriver driver;
    

    @FindBy(id = "username")
    private WebElement txtbox_EmailAddress;

    @FindBy(id = "password")
    private WebElement txtbox_Password;
    
    @FindBy(xpath = ".//*[@id='new_session']/input[4]")
    private WebElement btn_LoginButton;


    public AmaysimLoginPage(WebDriver driver){
        this.driver = driver;
      
        
        driver.get("https://accounts.amaysim.com.au/identity/login");
        
        PageFactory.initElements(driver, this);
        
    }

    public void EnterUserName(String username){
    	txtbox_EmailAddress.sendKeys(username);
    	
    }
    
    public void EnterPasword(String password){
    	txtbox_Password.sendKeys(password);
    	
    }
    
    public AmaysimHomePage LogIn(String Username, String Password)
    {
		WebDriverWait wait = new WebDriverWait(driver,20);

    	this.EnterUserName(Username);
    	this.EnterPasword(Password);
    	btn_LoginButton.click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome_popup")));
    	return PageFactory.initElements(driver, AmaysimHomePage.class);
    }
}
