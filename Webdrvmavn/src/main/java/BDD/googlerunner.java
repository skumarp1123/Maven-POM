package BDD;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:reports/test-report/index.html"},
//tags= "@SmokeTest",
dryRun=true,
monochrome=true,
features = "src/test/java/iamgessearch",
glue = "BDD")

public class googlerunner {

}