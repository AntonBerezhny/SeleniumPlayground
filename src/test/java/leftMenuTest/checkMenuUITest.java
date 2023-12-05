package leftMenuTest;

import baseTest.BaseTest;
import org.junit.Test;

public class checkMenuUITest extends BaseTest {
    @Test
    public void checkMenuPresence(){
        homePage
                .openHomePage()
                .checkMenuItemsPresenceByName()

                ;
    }
}
