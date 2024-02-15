package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonActionsWithElements {
    WebDriver webDriver; //this webDriver is available in all pages
    Logger logger = Logger.getLogger(getClass());  //logger will be available in all descendants
    WebDriverWait webDriverWait10, webDriverWait15; //initializing waits

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class); //to create multiple files need to create multiple variables(configProperties)
    //

    public CommonActionsWithElements(WebDriver webDriver) {   //driver to be available in all descendants
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); //asking to initialize/create elements when page is created(FindBy elements)
         webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10)); //webdriver should be setted in constructor
         webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    protected void enterTextIntoElement(WebElement webElement, String text){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            String name = getElementName(webElement);
            webElement.sendKeys(text);
            logger.info(text + " was inputted into the element " + name);
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked" );
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void selectTextInDDByUI(WebElement dropDown,  String textValue){
        try {
            clickOnElement(dropDown);

            //clickOnElement(webDriver.findElement(By.xpath(String.format(".//*[@class='oxd-select-option']/span[text()='%s']", textValue))));
            //clickOnElement(webDriver.findElement(By.xpath(".//*[@class='oxd-select-option']/span[contains(text(), 'Admin')]")));
            clickOnElement(webDriver.findElement(By.xpath(".//span[@class='asdf']")));


//            clickOnElement(usernameSortingDD);
//            clickOnElement(usernameSortingDD.findElement(By.xpath(String.format(usernameSortingDDOption, sortingType))));
//            //webDriver.findElements(By.xpath(String.format(usernameSortingDDOption, sortingType)));

        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void selectTextInSortingDD(WebElement dropDown, String dropDownOption, String textValue){
        try {
            clickOnElement(dropDown);
            clickOnElement(webDriver.findElement(By.xpath(String.format(dropDownOption, textValue))));
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clearTheInputField(WebElement webElement){
        try {
            //webElement.clear();
            while (!webElement.getAttribute("value").equals("")){
                webElement.sendKeys(Keys.BACK_SPACE);
            }
            logger.info("Element was cleared");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();//if present return true, if no return false;
            String message;
            if (state){ // if (state)equals to if (state == true), if false need to write == false;
                message = getElementName(webElement) + " Element is displayed";
            } else {
                message = getElementName(webElement) + " Element is not displayed";
            }
            logger.info(message);
            return state;
        }catch (Exception e){
            logger.info("Element is not displayed");
            return false;
        }
    }

    private String getElementName(WebElement webElement){
        try {
            return webElement.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }

    protected void printErrorAndStopTest(Exception e){
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e); //assert.fail stops test and mark as red
    }

}
