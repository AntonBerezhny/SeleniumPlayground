package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    @FindBy(xpath = ".//input[@placeholder='Username' and @name='username']")
    private WebElement inputUserName; //variable with webelement type created

    @FindBy(xpath = ".//input[@placeholder='Password' and @name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver); //sending/setting webDriver to Parent page
    }

    public void openLoginPage(){
        try {
            webDriver.get("https://opensource-demo.orangehrmlive.com/");
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Can't open login Page" + e);
            Assert.fail("Can't open login Page" + e);//if Java comes to this step, the test stops and marked as failed
        }
    }

    public void enterUserNameIntoInputLogin(String userName) {
        enterTextIntoElement(inputUserName,userName);
    }

    public void enterPasswordIntoInputPassword(String password) {
        enterTextIntoElement(inputPassword, password);
    }

    public void clickOnLoginButton() {
       clickOnElement(buttonLogin);
    }
}
