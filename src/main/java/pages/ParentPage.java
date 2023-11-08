package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage { //parent class for all pages
    protected WebDriver webDriver; //this webDriver is available in all pages
    protected Logger logger = Logger.getLogger(getClass()); //logger will be available in all descendants

    public ParentPage(WebDriver webDriver) { //driver to be available in all descendants
        this.webDriver = webDriver;
    }

    protected void printErrorAndStopTest(Exception e){
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e); //assert.fail stops test and mark as red
    }

}
