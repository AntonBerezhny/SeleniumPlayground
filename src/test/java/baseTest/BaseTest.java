package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver; //webdriver initialized, available in all descendants
    Logger logger = Logger.getLogger(getClass()); //getter
    protected LoginPage loginPage; //imported recently created class
    protected HomePage homePage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(); // chrome was set in webDriver variable
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(webDriver); // passing webDriver(protected Webdriver webDriver) variable to login page
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");

    }

}
