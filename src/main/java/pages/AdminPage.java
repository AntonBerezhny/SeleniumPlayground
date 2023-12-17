package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AdminPage extends ParentPage{
    @FindBy(xpath = ".//span[@class='oxd-text oxd-text--span' and text()[contains(.,'Records Found')]]")
    private WebElement filterResultTitle;

    @FindBy(xpath = ".//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space') and descendant::label[text()='User Role']]//div[contains(text(), 'Select')]")
    private WebElement userRoleDD;
    //xpath = ".//*[contains(text(), 'User Role')]//..//..//div[contains(text(), 'Select')]"
    // "//div[contains(@class,'oxd-grid-item') and *//label[text()='User Role']]//div[@class='oxd-select-text-input']"

    @FindBy(css = ".oxd-table-body>.oxd-table-card>.oxd-table-row>.oxd-table-cell:nth-of-type(3)")
    private List<WebElement> userRoleCellValue;
    // ".//*[@class='oxd-table-body']/div/div[@class='oxd-table-row oxd-table-row--with-border']/div[@role='cell'][3]")

    @FindBy(xpath = ".//button[text()=' Reset ']")
    private WebElement resetButton;
    @FindBy(xpath = ".//button[text()=' Search ']")
    private WebElement searchButton;

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
        waitSpinnerToHide();
        for (WebElement element: userRoleCellValue)
            if (element.getText().equals(userRole)){
                logger.info("cell contains " + userRole);
            }else {
                logger.info(element.getText());
                Assert.fail("cell doesn't contain " + userRole);
            }

        return this;
    }

    public AdminPage clickTheResetButton() {
        clickOnElement(resetButton);
        return this;
    }
}
