package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue= "stepDefinitions.LoginSteps,stepDefinitions.AddProductSteps",
        plugin = { "pretty","html:target/cucumber-reports",
                "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/cucumber-reports"},
        monochrome = true

)
class TestRunner_Login {
}
