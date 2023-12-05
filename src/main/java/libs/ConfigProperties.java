package libs;

import org.aeonbits.owner.Config;

import java.util.List;

@Config.Sources(value = "file:./src/main/java/resources/config.properties")
public interface ConfigProperties extends Config {
	long TIME_FOR_DEFAULT_WAIT();
	long TIME_FOR_EXPLICIT_WAIT_LOW();
	long TIME_FOR_EXPLICIT_WAIT_HIGH();

	String base_url();

	List list_of_menu_names();
}
