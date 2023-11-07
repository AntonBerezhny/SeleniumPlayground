package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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
}
