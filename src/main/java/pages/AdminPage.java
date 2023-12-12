package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends ParentPage{
    @FindBy(xpath = ".//span[@class='oxd-text oxd-text--span' and text()[contains(.,'Records Found')]]")
    private WebElement filterResultTitle;
    @FindBy(xpath = ".//*[contains(text(), 'User Role')]//..//..//div[contains(text(), 'Select')]")
    private WebElement userRoleDD;
    @FindBy(xpath = ".//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement searchButton;

    @FindBy(xpath = ".//*[@class='oxd-table-body']/div/div[@class='oxd-table-row oxd-table-row--with-border']/div[@role='cell'][3]")
    private List<WebElement> userRoleCellValue;
    @FindBy(xpath = ".//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement resetButton;

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

    public AdminPage clickTheSearchButton() {
        clickOnElement(searchButton);
        return this;
    }


    public AdminPage checkSearchResultTableContainsEnteredValue(String userRole) {
        for (WebElement element: userRoleCellValue)
            if (element.getText().contains(userRole)){
                logger.info("cell contains " + userRole);
            }else {
                Assert.fail("cell doesn't contain " + userRole);
            }

        return this;
    }

    public AdminPage clickTheResetButton() {
        clickOnElement(resetButton);
        return this;
    }
}
