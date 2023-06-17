package abcd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-default-report.html",
                "rerun:target/failed.txt"},
        features = "src/test/resources/features",
        glue = "abcd/step_definitions",
        dryRun = false,
        tags = "@smoke"
)

public class CukesRunner {
}
