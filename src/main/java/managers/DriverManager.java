package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    public DriverManager() {
        driverType = FileReadManager.getInstance().getConfigReader().getBrowser();

    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }
    private WebDriver createDriver() {

            driver = createLocalDriver();


        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReadManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReadManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReadManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }


    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}

