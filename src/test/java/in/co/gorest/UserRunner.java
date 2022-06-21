package in.co.gorest;

import cucumber.api.CucumberOptions;
import in.co.gorest.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/featurefile/"
        ,tags = "@smoke"
)
public class UserRunner extends TestBase {
}