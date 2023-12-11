package adminTabTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CheckUserRoleFilterTest extends BaseTest {

    @Test
    public void checkUserRoleFilter(){
        homePage
                .openHomePage()
                .clickAdminTab()
                .checkIsRedirectedToAdminPage()
                ;
    }
}
