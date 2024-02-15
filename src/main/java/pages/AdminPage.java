package pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminPage extends ParentPage{
    @FindBy(xpath = ".//span[@class='oxd-text oxd-text--span' and text()[contains(.,'Found')]]")
    private WebElement filterResultTitle;

    @FindBy(xpath = ".//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space') and descendant::label[text()='User Role']]//div[contains(text(), 'Select')]")
    private WebElement userRoleDD;
    //xpath = ".//*[contains(text(), 'User Role')]//..//..//div[contains(text(), 'Select')]"
    // "//div[contains(@class,'oxd-grid-item') and *//label[text()='User Role']]//div[@class='oxd-select-text-input']"

    @FindBy(css = ".oxd-table-body>.oxd-table-card>.oxd-table-row>.oxd-table-cell:nth-of-type(3)")
    private List<WebElement> userRoleCellValue;
    // ".//*[@class='oxd-table-body']/div/div[@class='oxd-table-row oxd-table-row--with-border']/div[@role='cell'][3]")

    private static final String usernameCellString = ".oxd-table-body>.oxd-table-card>.oxd-table-row>.oxd-table-cell:nth-of-type(2)";

    @FindBy(css = usernameCellString)
    private List<WebElement> usernameCellValue;

    @FindBy(xpath = ".//button[text()=' Reset ']")
    private WebElement resetButton;
    @FindBy(xpath = ".//button[text()=' Search ']")
    private WebElement searchButton;
    @FindBy(xpath = ".//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Username']//i[@class='oxd-icon bi-sort-alpha-down oxd-icon-button__icon oxd-table-header-sort-icon']")
    private WebElement usernameSortingDD;//changed to ..DDTest as the class changes upon filtering

    @FindBy(xpath = ".//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Username']/div[@class='oxd-table-header-sort']")
    private WebElement usernameSortingDDTest;

//    @FindBy(xpath = ".//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Username']/descendant::span[@class='oxd-text oxd-text--span' and text()='%s']")
//    private String usernameSortingDDOption;

    private final static String usernameSortingDDOption = ".//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Username']/descendant::span[@class='oxd-text oxd-text--span' and text()='%s']";


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

    public AdminPage verifyUsernameColumnSortingIs(String sortingDirection) {
        ArrayList<String> actualListFromWebelement = new ArrayList<>();
        ArrayList<String> tobeModifiedListFromWebelement = new ArrayList<>();
        for (WebElement element: usernameCellValue){
            actualListFromWebelement.add(element.getText());
            tobeModifiedListFromWebelement.add(element.getText());
        }
        actualListFromWebelement.replaceAll(String::toLowerCase);
        tobeModifiedListFromWebelement.replaceAll(String::toLowerCase);

        if (sortingDirection.equalsIgnoreCase("Asc")){
            Collections.sort(tobeModifiedListFromWebelement);
        } else if (sortingDirection.equalsIgnoreCase("Desc")) {
            Collections.sort(tobeModifiedListFromWebelement, Collections.reverseOrder());
        }

        Assertions.assertIterableEquals(actualListFromWebelement, tobeModifiedListFromWebelement, "Lists are not equal");
        return this;
    }


    public AdminPage setUsernameColumnSorting(String sortingType) {
        selectTextInSortingDD(usernameSortingDDTest, usernameSortingDDOption, sortingType);
        return this;
    } //Todo - think of creating method which will sort fields sortListBy(fieldname, isasc)...



}
