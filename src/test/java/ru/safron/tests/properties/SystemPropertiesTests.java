package ru.safron.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void urlSelenoid() {
        String url = System.getProperty("url", "https://selenoid.autotests.cloud/wd/hub");
        System.out.println(url);
    }
}
