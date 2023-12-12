package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends ParentPage{
    @FindBy(xpath = ".//span[@class='oxd-text oxd-text--span' and text()[contains(.,'Records Found')]]")
    private WebElement filterResultTitle;
    @FindBy(xpath = ".//*[contains(text(), 'User Role')]//..//..//div[contains(text(), 'Select')]")
    private WebElement userRoleDD;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/web/index.php/admin/viewSystemUsers";
    }

    public AdminPage checkIsRedirectedToAdminPage() {
        checkURL();
        Assert.assertTrue("Admin page is not opened", isElementDisplayed(filterResultTitle));
        return this;
    }

    public AdminPage selectValueInDDByUI(String ddValue) {
        selectTextInDDByUI(userRoleDD, ddValue);
        return this;
    }
}
