package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import managers.DriverManager;


import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {

    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public void AfterSteps(Scenario scenario) throws IOException {

        System.out.println(scenario.getName().toString());
        System.out.println(scenario.getStatus());

       this.driver=driver;
        if (scenario.isFailed()) {
            final byte[] screenshot  =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            File sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("C:\\Automation\\ScreenShots");

            scenario.embed(screenshot , "image/png");

           // Files.copy();

        }

        testContext.getWebDriverManager().closeDriver();

    }
}
