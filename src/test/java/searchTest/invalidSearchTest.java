package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

public class invalidSearchTest extends BaseTest {

    final String INVALID_SEARCH_REQUEST = "test";

    @Test
    public void TC2_invalidSearch(){
        homePage
                .openHomePage()
                .checkAllMenuItemsArePresent(12)
                .enterSearchRequestIntoSearchInput(INVALID_SEARCH_REQUEST)
                .checkNoMenuItemsArePresent(0)
                .clearTheSearchInputField()
                .checkAllMenuItemsArePresent(12)
                ;
    }
}
