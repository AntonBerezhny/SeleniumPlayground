package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonActionsWithElements {
    WebDriver webDriver; //this webDriver is available in all pages
    Logger logger = Logger.getLogger(getClass());  //logger will be available in all descendants

    public CommonActionsWithElements(WebDriver webDriver) {   //driver to be available in all descendants
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); //asking to initialize/create elements when page is created(FindBy elements)
    }

    protected void enterTextIntoElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into the element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement){
        try {
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void printErrorAndStopTest(Exception e){
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e); //assert.fail stops test and mark as red
    }

}
