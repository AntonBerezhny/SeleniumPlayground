package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{ //this class will contain both abstract and already created classes

    protected String base_url = "https://opensource-demo.orangehrmlive.com";

    public ParentPage(WebDriver webDriver) {
        super(webDriver); //take Webdriver from Superclass
    }

    abstract String getRelativeURL(); // no realization, all descendants of Parent page will/must have(implement) this method

    /**
     * google.com == google.com
     */
    protected void checkURL(){
        Assert.assertEquals("Invalid page shown", base_url + getRelativeURL(), webDriver.getCurrentUrl());
    }

    /**
     * google.com == google -> true //partially contains
     */
    protected void checkURLContainsRelative(){
        Assert.assertThat("Invalid page", webDriver.getCurrentUrl(), CoreMatchers.containsString(base_url + getRelativeURL())); // checking webdriver.getcurrentUrl contains baseurl +getrelativeURL if so mark as true
    }

}
