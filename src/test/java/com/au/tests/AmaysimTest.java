package com.au.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.au.pages.AmaysimHomePage;
import com.au.pages.AmaysimLoginPage;
import com.au.pages.AmaysimSettingsPage;

public class AmaysimTest {
	 AmaysimLoginPage loginpage;
	 AmaysimHomePage homepage;
	 AmaysimSettingsPage settingspage;
	
	public WebDriver driver;	
	
	
  @Test(priority=1)
  public void VerifyLogIn() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  loginpage = new AmaysimLoginPage(driver);
	  
	  
	  homepage = loginpage.LogIn("0468827174", "theHoff34");	  
	  homepage.CloseActivateSim();
	  
	  settingspage = homepage.GoToManageSettingsPage();
	  
  }
  
  @Test(priority=2, enabled=true)
  public void validateSetNickName() throws Exception{
	  
	  settingspage.EditSimNickName("newNickName");
	  Assert.assertEquals(settingspage.getSimNickName(),"newNickName");
	  
  }
  
  @Test(priority=3, enabled=true)
  public void validateEditPIN() throws Exception{
	  settingspage.EditPIN("4567");
	  Assert.assertEquals(settingspage.getPin(), "4567");
	  
  }
  
  @Test(priority=4, enabled=true)
  public void VerifyselectCallerID() throws Exception{
	  settingspage.SelectCallerID();
	  String popupMessage = settingspage.getPopUpMessage();
	  Assert.assertTrue(popupMessage.contains("We have successfully updated your SIM settings."));
	  settingspage.ClosePopUp();
	  
  }
  
  @Test(priority=5, enabled=true)
  public void VerifyselectCallWaiting() throws Exception{
	  settingspage.SelectCallWaiting();
	 
	  	System.out.println(settingspage.getPopUpMessage()+"test5");
	 Assert.assertTrue(settingspage.getPopUpMessage().contains("We have successfully updated your SIM settings."));
	  
	  settingspage.ClosePopUp();
	  
  }
  
  @Test(priority=6, enabled=true)
  public void VerifyselectVoiceMail() throws Exception{
	  settingspage.SelectVoiceMail();
	  String popupMessage = settingspage.getPopUpMessage();
	 
	 Assert.assertTrue(popupMessage.contains("We have successfully updated your SIM settings."));
	  settingspage.ClosePopUp();
	  
  }
  
  @Test(priority=7, enabled=true)
  public void VerifySelectUsageAlerts() throws Exception{
	  settingspage.SelectUsageAlerts();
	  settingspage.ClickYesConfirmPopUp();
	  
	  String popupMessage = settingspage.getPopUpMessage();
		 
	 Assert.assertTrue(popupMessage.contains("We have successfully updated your SIM settings."));
	  
	  
	  settingspage.ClosePopUp();
	  
  }
  
  @Test(priority=8, enabled=true)
  public void VerifyselectInternationalRoaming() throws Exception{
	  settingspage.SelectInternationalRoaming();

	  
	  String popupMessage = settingspage.getPopUpMessage();
		 
	 Assert.assertTrue(popupMessage.contains("We have successfully updated your SIM settings."));
	  
	  
	  settingspage.ClosePopUp();
	  
  }
  
  
  @Test(priority=9, enabled=true)
  public void VerifyEnableCallForward(){
	  settingspage.EditForwarding("0412 345 678");
	  
  }
  
  	@AfterClass(enabled=true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
