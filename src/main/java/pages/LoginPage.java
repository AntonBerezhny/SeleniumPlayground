package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement inputUserName; //variable with webelement type created

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver); //sending/setting webDriver to Parent page
    }

    @Override
    String getRelativeURL() { //implementation of abstract method
        return "/";
    }

    public void openLoginPage(){
        try {
            webDriver.get(base_url + getRelativeURL());
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

    public HomePage fillingLoginFormWithValidCreds() {
        openLoginPage();
        enterUserNameIntoInputLogin(TestData.VALID_LOGIN);
        enterPasswordIntoInputPassword(TestData.VALID_PASSWORD);
        clickOnLoginButton();
        return new HomePage(webDriver);
    }
}
