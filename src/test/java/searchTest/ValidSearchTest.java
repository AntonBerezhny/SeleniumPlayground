package searchTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ValidSearchTest extends BaseTest {
    final static String SEARCH_REQUEST = "a";

    @Test
    public void TC1_validSearch(){
        homePage
                .openHomePage()
                .checkAllMenuItemsArePresent(TestData.NUMBER_OF_MENU_ELEMENTS)
                .enterSearchRequestIntoSearchInput(SEARCH_REQUEST)
                .checkCorrectNumberOfMenuItemsDisplayedUponSearch(SEARCH_REQUEST)
                .clearTheSearchInputField()
                .checkAllMenuItemsArePresent(TestData.NUMBER_OF_MENU_ELEMENTS)

                ;


    }
}
