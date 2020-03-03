package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import managers.DriverManager;


import managers.FileReadManager;
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


    public Hooks(TestContext context) {
        testContext = context;
    }

    @After(order=1)
    public void AfterSteps(Scenario scenario) throws IOException {

        System.out.println(scenario.getName().toString());
        System.out.println(scenario.getStatus());



        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            try
            {
                File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                System.out.println(sourcePath.toPath().toString());
                System.out.println(destinationPath.toPath().toString());

                Files.copy(sourcePath.toPath(), destinationPath.toPath());
            }

            catch (Exception ignore)
            {

            }
        }



    }

    @After(order = 0)
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }
}
