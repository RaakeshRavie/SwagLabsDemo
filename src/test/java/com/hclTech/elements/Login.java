package com.hclTech.elements;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Login {
    WebDriver driver;
 
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(name = "user-name")
    WebElement userName;
 
    @FindBy(name = "password")
    WebElement password;
 
    @FindBy(name = "login-button")
    WebElement loginButton;
 
    public void loginToApp(String uname, String pwd) {
        userName.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
    }
}