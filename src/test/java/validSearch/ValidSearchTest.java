package validSearch;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ValidSearchTest extends BaseTest {

    @Test
    public void validSearch(){
        loginPage.openLoginPage();
        loginPage.enterUserNameIntoInputLogin("Admin");
        loginPage.enterPasswordIntoInputPassword("admin123");
        loginPage.clickOnLoginButton();

        Assert.assertTrue("Search input field is not displayed", homePage.isSearchInputFieldDisplayed());


    }
}
