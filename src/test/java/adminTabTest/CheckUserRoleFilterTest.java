package adminTabTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckUserRoleFilterTest extends BaseTest {
    final static String ADMIN_USER_ROLE = "Admin";
    final static String ESS_USER_ROLE = "ESS";

    @Test
    public void checkUserRoleFilter(){
        homePage
                .openHomePage()
                .clickAdminTab()
            .checkIsRedirectedToAdminPage()
                .selectValueInDDByUI(ADMIN_USER_ROLE)
                .clickTheSearchButton()
                .checkSearchResultTableContainsEnteredValue(ADMIN_USER_ROLE)
                .clickTheResetButton()
                .selectValueInDDByUI(ESS_USER_ROLE)
                .clickTheSearchButton()
                .checkSearchResultTableContainsEnteredValue(ESS_USER_ROLE)
                ;
    }
}
