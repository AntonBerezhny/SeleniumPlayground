package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

public class ValidSearchTest extends BaseTest {
    final static String SEARCH_REQUEST = "a";

    @Test
    public void TC1_validSearch(){
        homePage
                .openHomePage()
                .checkAllMenuItemsArePresent(12)
                .enterSearchRequestIntoSearchInput(SEARCH_REQUEST)
                .checkCorrectNumberOfMenuItemsDisplayedUponSearch(SEARCH_REQUEST)
                .clearTheSearchInputField()
                .checkAllMenuItemsArePresent(12)

                ;


    }
}
