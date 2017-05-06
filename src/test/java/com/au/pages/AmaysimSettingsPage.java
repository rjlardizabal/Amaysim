package com.au.pages;

import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

public class AmaysimSettingsPage {
	private static WebDriver driver;
	
	
	

	//Edit NickName
    @FindBy(id = "edit_settings_phone_label")
    private WebElement link_EditNickname;
    
    @FindBy(id = "my_amaysim2_setting_phone_label")
    private WebElement txtbox_EditSIMNickName;
    
    @FindBy(xpath = ".//*[@id='edit_settings_sim_nickname']/div[3]/div/input")
    private WebElement btn_SaveNickName;
    
    @FindBy(xpath = ".//*[@id='settings_sim_nickname']/div/div[1]/div/div[2]")
    private WebElement lbl_NickName;
    
    //Edit PIN
    @FindBy(id = "edit_settings_recharge_pin")
    private WebElement link_EditRechargePin;
    
    @FindBy(id = "my_amaysim2_setting_topup_pw")   
    private WebElement txtbox_EditRechargePin;
    
    @FindBy(xpath = "//form[@id='edit_settings_topup_password']/div[3]/div/input")
    private WebElement btn_SavePin;
    
    @FindBy(xpath = ".//*[@id='settings_recharge_pin']/div/div/div[1]/div/div[2]")
    private WebElement lbl_PIN;

    
    @FindBy(id = "edit_settings_call_forwarding")
    private WebElement link_EditCallForwarding;

    
    @FindBy(id = "edit_settings_premium_sms_limit")
    private WebElement link_EditPremiumSMSLimit;

    
    @FindBy(id = "edit_settings_auto_recharge")
    private WebElement link_EditAutorecharge;
    
    @FindBy(xpath=".//*[contains(@id,'edit_setting_caller_id_out')]/div[2]/label")
    private WebElement chkbox_CallerID;
    
    @FindBy(xpath=".//*[contains(@id,'edit_setting_caller_waiting')]/div[2]/label")
    private WebElement chkbox_CallWaiting;
    
    @FindBy(xpath=".//*[contains(@id,'edit_setting_voice_mail')]/div[2]/label")
    private WebElement chkbox_VoiceMail;
    
    @FindBy(xpath=".//*[contains(@id,'edit_setting_intl_roaming')]/div[2]/label")
    private WebElement chkbox_InternationalRoaming;
    
    @FindBy(xpath=".//*[contains(@id,'edit_setting_usage_alert')]/div[2]/label")
    private WebElement chkbox_UsageAlerts;
    
    @FindBy(css = ".form_info_popup.reveal-modal.padding-none.open")
    private WebElement popup_Info;
    
    @FindBy(className = "close-reveal-modal")
    private WebElement close_Popup;
    
    @FindBy(css="div.reveal-modal-bg")
    private WebElement bg_Ajax;
    
    @FindBy(id="confirm_popup_yes")
    private WebElement btn_popupYes;
    
    @FindBy(css=".confirm_popup_confirm")
    private WebElement btn_confirmPopup;
    
    @FindBy(id="edit_settings_call_forwarding")
    private WebElement link_EditCallFowarding;
    
    @FindBy(id="my_amaysim2_setting_call_divert_number")
    private WebElement txtbox_ForwardCallsto;
    
    @FindBy(css=".button-green-action.small-12.medium-7.medium-offset-1.large-offset-2.columns")
    private WebElement btn_SaveCallFoward;


	
	public AmaysimSettingsPage(WebDriver driver){
		this.driver = driver;
		
		
		
	}
	
	public void EditSimNickName(String NewNickName) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(link_EditNickname));
		link_EditNickname.click();
		wait.until(ExpectedConditions.visibilityOf(txtbox_EditSIMNickName));
		txtbox_EditSIMNickName.clear();
		txtbox_EditSIMNickName.sendKeys(NewNickName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='edit_settings_sim_nickname']/div[3]/div/input")));
		Thread.sleep(5000);
		btn_SaveNickName.click();
		WaitForSpinner();
		
		
	}
	
	public void EditPIN(String NewPin) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.elementToBeClickable(link_EditRechargePin));
		link_EditRechargePin.click();
		

		txtbox_EditRechargePin.clear();
		txtbox_EditRechargePin.sendKeys(NewPin);
		wait.until(ExpectedConditions.elementToBeClickable(btn_SavePin));
		
		Thread.sleep(5000);
		btn_SavePin.click();
		WaitForSpinner();
	
		
		
	}
	
	public String getSimNickName(){
		return lbl_NickName.getText();
	}
	
	public String getPin(){
		return lbl_PIN.getText();
	}
	
	public void WaitForSpinner(){
		WebDriverWait wait = new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		
	}
	
	public void SelectCallerID() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);

		//wait.until(ExpectedConditions.visibilityOf(chkbox_CallerID));
		Thread.sleep(5000);
		System.out.println(chkbox_CallerID.isSelected());
		chkbox_CallerID.click();
		WaitForSpinner();
	
		
	}
	
	public void SelectCallWaiting() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(chkbox_CallWaiting));
		chkbox_CallWaiting.click();
		WaitForSpinner();
		
		
	}
	
	public void SelectVoiceMail() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);

		//wait.until(ExpectedConditions.visibilityOf(chkbox_CallerID));
		Thread.sleep(5000);
		chkbox_VoiceMail.click();
		WaitForSpinner();
	}
	
	public void SelectUsageAlerts() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);

		//wait.until(ExpectedConditions.visibilityOf(chkbox_CallerID));
		Thread.sleep(5000);
		chkbox_UsageAlerts.click();
		WaitForSpinner();
		
	}
	
	public void SelectInternationalRoaming() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);

		//wait.until(ExpectedConditions.visibilityOf(chkbox_CallerID));
		Thread.sleep(5000);
		chkbox_InternationalRoaming.click();
		WaitForSpinner();
		
	}
	
	public void ClosePopUp(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		bg_Ajax.click();
		WaitForSpinner();
		
		
	}
	
	public String getPopUpMessage(){
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(popup_Info));
		
	
		
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		
		return popup_Info.getText();	
	}
	
	public void ClickYesConfirmPopUp(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(btn_popupYes));
		btn_popupYes.click();
		WaitForSpinner();
	}
	
	public void ClickConfirmPopUp(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(btn_confirmPopup));
		btn_confirmPopup.click();
		WaitForSpinner();
	}
	
	public void EditForwarding(String forwardingCallsTo){
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(link_EditCallForwarding));
		link_EditCallForwarding.click();
		this.ClickConfirmPopUp();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(txtbox_ForwardCallsto));
		txtbox_ForwardCallsto.clear();
		txtbox_ForwardCallsto.sendKeys(forwardingCallsTo);
		btn_SaveCallFoward.click();
		
		
		
	}

}
