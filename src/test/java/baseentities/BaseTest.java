package baseentities;

import com.codeborne.selenide.Configuration;
import configuration.ReadProperties;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1960x1080";
        Configuration.reportsFolder = "target/screens";
    }

}
