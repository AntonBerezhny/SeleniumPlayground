package searchTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class invalidSearchTest extends BaseTest {

    final String INVALID_SEARCH_REQUEST = "test";

    @Test
    public void TC2_invalidSearch(){
        homePage
                .openHomePage()
                .checkAllMenuItemsArePresent(TestData.NUMBER_OF_MENU_ELEMENTS)
                .enterSearchRequestIntoSearchInput(INVALID_SEARCH_REQUEST)
                .checkNoMenuItemsArePresent()
                .clearTheSearchInputField()
                .checkAllMenuItemsArePresent(TestData.NUMBER_OF_MENU_ELEMENTS)
                ;
    }
}
