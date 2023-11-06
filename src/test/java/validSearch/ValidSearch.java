package validSearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ValidSearch {
    private WebDriver webDriver; //variable was created from library

    @Test
    public void validSearch(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(); //chrome was written to a webdriver variable;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement inputUsername =
                webDriver.findElement(By.xpath(".//input[@placeholder='Username' and @name='username']")); //variable with webelement type created
        inputUsername.clear();
        inputUsername.sendKeys("Admin");

        WebElement inputPassword =
                webDriver.findElement(By.xpath(".//input[@placeholder='Password' and @name='password']"));
        inputPassword.clear();
        inputPassword.sendKeys("admin123");

        WebElement loginButton =
                webDriver.findElement(By.xpath(".//button[@type='submit']"));
        loginButton.click();

        //WebElement searchInputField = webDriver.findElement(By.xpath(".//input[@placeholder='Search']"));
        //Assert.assertTrue("Search input field is not displayed", searchInputField.isDisplayed());

        Assert.assertTrue("Search input field is not displayed", isSearchInputFieldDisplayed());


        webDriver.quit();

    }

    private boolean isSearchInputFieldDisplayed(){
        try {
            return webDriver.findElement(By.xpath(".//input[@placeholder='Search']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
