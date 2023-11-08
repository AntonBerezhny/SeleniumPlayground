package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSearchInputFieldDisplayed(){
        try {
            return webDriver.findElement(By.xpath(".//input[@placeholder='Search']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
