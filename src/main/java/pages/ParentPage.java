package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage { //parent class for all pages
    protected WebDriver webDriver; //this webDriver is available in all pages
    protected Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver webDriver) { //driver to be available in all descendants
        this.webDriver = webDriver;
    }
}
