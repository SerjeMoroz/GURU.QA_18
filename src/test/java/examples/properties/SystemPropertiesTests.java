package examples.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("remote")
    void simplePropertyTest() {
        String browserName = System.getProperty("browser", "firefox");
        String browserVersion = System.getProperty("browser_version", "140");
        System.out.println(browserName);
        System.out.println((browserVersion));
    }

}
