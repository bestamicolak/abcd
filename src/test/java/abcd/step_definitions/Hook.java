package abcd.step_definitions;

import abcd.utilities.CommonSteps;
import abcd.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;

public class Hook {
    @Before
    public void setUp() {
        Driver.get();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            // take screenshot and save it in /failed
            picture = CommonSteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }
        // Driver.closeDriver();
    }
}
