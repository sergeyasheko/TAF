package services;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Locale;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowserService() {
        switch (ReadProperties.browserName().toLowerCase(Locale.ROOT)) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                break;
            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not supported.");
        }
    }

    public WebDriver getDriver() {

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Неявные ожидания элемента
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //Неявные ожидания страниц
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60)); //Неявные ожидания скриптов
        return this.driver;

    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(ReadProperties.isHeadless());
        chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--window-size=1920,1200");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }
}
