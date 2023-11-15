package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//input[@placeholder='Search']")
    private WebElement searchInputField;

    @FindBy(xpath = ".//li[@class='oxd-main-menu-item-wrapper']")
    private List<WebElement> listOfMenuItems;

    private String menuItemContainText = ".//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()" +
            "[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]]";


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
        LoginPage loginPage = new LoginPage(webDriver); //in this method we create an object needed to proceed to loginPage itself
        loginPage.fillingLoginFormWithValidCreds();
        checkIsRedirectedToHomePage();
        return this;
    }

    public HomePage checkIsRedirectedToHomePage() {
        Assert.assertTrue("HomePage was not opened", isSearchInputFieldDisplayed()); //if isSear...false test will be stopped
        return this;
    }

    public HomePage checkAllMenuItemsArePresent(int itemsQuantity) {
        //WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assert.assertEquals("The number of menu items doesn't correspond to expected",
                itemsQuantity, listOfMenuItems.size());
        return this;
    }

    public HomePage enterSearchRequestIntoSearchInput(String searchRequest) {
        enterTextIntoElement(searchInputField, searchRequest);
        return this;
    }

    public List<WebElement> getMenuItemsWithRequest(String request){
        return webDriver.findElements(By.xpath(String.format(menuItemContainText, request)));
    }

    public HomePage checkCorrectNumberOfMenuItemsDisplayedUponSearch(String searchInput) {
       List<WebElement> listOfMenuItemsWithSearchRequest = getMenuItemsWithRequest(searchInput);
       int counter = listOfMenuItemsWithSearchRequest.size();
        for (int i = 0; i < counter; i++) {
            for (WebElement element: listOfMenuItemsWithSearchRequest){
                if (element.getText().contains(searchInput)){
                    logger.info(element + " contains" + searchInput);
                }else {
                    Assert.fail(element + " doesn't contain " + searchInput);
                }
            }

        }

        return this;
    }
}
