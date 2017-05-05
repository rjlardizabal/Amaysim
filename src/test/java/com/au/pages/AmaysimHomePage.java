package com.au.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmaysimHomePage {
	
	private WebDriver driver;
	WebDriverWait wait;

	
	
	@FindBy(xpath=".//*[@id='welcome_popup']/a")
	private WebElement btn_ClosePopup;
	
	@FindBy(linkText ="Settings")
	private WebElement link_Settings;
	
	@FindBy(xpath=".//*[@id='outer_wrap']/div[2]/div[1]/div[contains(text(),'settings')]")
	private WebElement header_Settings;
	
    public AmaysimHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }
    
    public void GoToManageSettings(){
    	driver.get("https://www.amaysim.com.au/my-account/my-amaysim/settings");
    	
    }
    
    public void CloseActivateSim(){
    	wait.until(ExpectedConditions.elementToBeClickable(btn_ClosePopup));
    	btn_ClosePopup.click();
    }
    
    public AmaysimSettingsPage GoToManageSettingsPage(){
    	wait.until(ExpectedConditions.elementToBeClickable(link_Settings));
    	link_Settings.click();
    	wait.until(ExpectedConditions.visibilityOf(header_Settings));
    	return PageFactory.initElements(driver, AmaysimSettingsPage.class);
    	
    }

}
