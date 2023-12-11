package libs;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class); //initialize confighidden
    public final static String VALID_LOGIN = System.getProperty("login", configHiddenProperties.login()) ; //not able to change, available in every place of the program
    public final static String VALID_PASSWORD = System.getProperty("password", configHiddenProperties.password());

    public final static int NUMBER_OF_MENU_ELEMENTS = 12;
}
