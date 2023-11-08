package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage{

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
        try {
            WebElement inputUsername =
                    webDriver.findElement(By.xpath(".//input[@placeholder='Username' and @name='username']")); //variable with webelement type created
            inputUsername.clear();
            inputUsername.sendKeys(userName);
            logger.info("Username was inputted");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void enterPasswordIntoInputPassword(String password) {
        try {
            WebElement inputPassword = webDriver.findElement(By.xpath(".//input[@placeholder='Password' and @name='password']"));
            inputPassword.clear();
            inputPassword.sendKeys(password);
            logger.info("Password was inputted");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void clickOnLoginButton() {
        try {
            WebElement loginButton = webDriver.findElement(By.xpath(".//button[@type='submit']"));
            loginButton.click();
            logger.info("Login button was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
}
