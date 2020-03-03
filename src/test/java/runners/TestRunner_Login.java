package runners;



import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReadManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue= "stepDefinitions",
        plugin = { "pretty","html:src\\target\\cucumber-reports\\report.html"},
        monochrome = true

)
class TestRunner_Login {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReadManager.getInstance().getConfigReader().getReportConfigPath()));

        System.out.println(FileReadManager.getInstance().getConfigReader().getReportConfigPath());
    }
}
