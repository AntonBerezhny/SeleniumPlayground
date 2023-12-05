package pages;

import libs.ConfigProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//input[@class='oxd-input oxd-input--active']")
    private WebElement searchInputField;

    @FindBy(xpath = ".//input[@class='oxd-input oxd-input--focus']")
    private WebElement searchInputFieldFocus;

    @FindBy(xpath = ".//input[@placeholder='Search']")
    private WebElement searchInputFieldWithPlaceholder;

    @FindBy(xpath = ".//li[@class='oxd-main-menu-item-wrapper']")
    private List<WebElement> listOfMenuItems;

    private String listOfMenuItemsString = ".//li[@class='oxd-main-menu-item-wrapper']";

    private String menuItemContainText = ".//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]]";




    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/web/index.php/dashboard/index";
    }

    public boolean isSearchInputFieldDisplayed(){
        try {
            return searchInputField.isDisplayed();
        }catch (Exception e){
            logger.info("Search input field is not displayed");
            return false;
        }
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver); //in this method we create an object needed to proceed to loginPage itself
        loginPage.fillingLoginFormWithValidCreds();//ToDO change behavior????
        checkIsRedirectedToHomePage();
        return this;
    }

    public HomePage checkIsRedirectedToHomePage() {
        checkURL();
        Assert.assertTrue("HomePage was not opened", isSearchInputFieldDisplayed()); //if isSear...false test will be stopped
        return this;
    }

    public HomePage checkAllMenuItemsArePresent(int itemsQuantity) {
        Assert.assertEquals("The number of menu items doesn't correspond to expected",
                itemsQuantity, listOfMenuItems.size());
        logger.info(itemsQuantity + " menu items are present");
        return this;
    }

    public HomePage checkNoMenuItemsArePresent() {
        Assert.assertEquals("Menu items list is not blank", 0, listOfMenuItems.size());
        logger.info(listOfMenuItems.size() + " menu items are present");
        return this;
    }

    public HomePage enterSearchRequestIntoSearchInput(String searchRequest) {
        enterTextIntoElement(searchInputField, searchRequest);
        return this;
    }

    public List<WebElement> getMenuItemsWithRequest(String request){
        return webDriver.findElements(By.xpath(String.format(menuItemContainText, request))); //findElementS finds all element using specified locator, findElement return only first
        // method populates 'request' into 's' locator in the top of the page
    }

    public HomePage checkCorrectNumberOfMenuItemsDisplayedUponSearch(String searchInput) {
       List<WebElement> listOfMenuItemsWithSearchRequest = getMenuItemsWithRequest(searchInput);
            for (WebElement element: listOfMenuItemsWithSearchRequest){
                if (element.getText().toLowerCase().contains(searchInput)){
                    logger.info(element + " contains" + searchInput);
                }else {
                    Assert.fail(element + " doesn't contain " + searchInput);
                }
            };


        return this;
    }

    public HomePage clearTheSearchInputField() {
        clearTheInputField(searchInputFieldWithPlaceholder);
        return this;
    }

    public HomePage checkMenuItemsPresenceByName() {
        List expectedListFromFile = configProperties.list_of_menu_names();
        Collections.sort(expectedListFromFile);

        ArrayList<String> listFromWebelement = new ArrayList<>();
        for (WebElement element: listOfMenuItems){
            listFromWebelement.add(element.getText());
        }
        Collections.sort(listFromWebelement);
        logger.info(listFromWebelement);
        logger.info(expectedListFromFile);
        Assert.assertEquals(listFromWebelement,expectedListFromFile);
        return this;
    }
}
