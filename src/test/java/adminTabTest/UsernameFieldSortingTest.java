package adminTabTest;

import baseTest.BaseTest;
import org.junit.Test;

public class UsernameFieldSortingTest extends BaseTest {
@Test
    public void sortingByUsernameColumn(){
    homePage
            .openHomePage()
            .clickAdminTab()
        .checkIsRedirectedToAdminPage()
            .verifyUsernameColumnDefaultSortingIsAscending()
            .setUsernameColumnSorting("Descending")
            .verifyUsernameColumnSortingISDescending()
            .setUsernameColumnSorting("Ascending")
            .verifyUsernameColumnDefaultSortingIsAscending()

            ;
}

}
