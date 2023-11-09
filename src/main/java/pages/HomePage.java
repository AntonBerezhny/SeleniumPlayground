package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//input[@placeholder='Search']")
    private WebElement searchInputField;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSearchInputFieldDisplayed(){
        try {
            return searchInputField.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver); //in this method we create an object needed
        loginPage.fillingLoginFormWithValidCreds();
        checkIsRedirectedToHomePage();
        return this;
    }

    public HomePage checkIsRedirectedToHomePage() {
        Assert.assertTrue("HomePage was not opened", isSearchInputFieldDisplayed()); //if isSear...false test will be stopped
        return this;
    }
}
