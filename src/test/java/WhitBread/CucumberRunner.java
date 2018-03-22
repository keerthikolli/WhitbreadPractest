package WhitBread;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        format = {"html:src/report/cucumber-html-report",
                "json:src/report/cucumber-json-report.json",
                "junit:Whitbread/src/report/cucumber-results.xml",
                "usage:Whitbread/src/report/cucumber-uage.json"},
        glue = {"WhitBread.stepDefinitions"}

)
/*@CucumberOptions(plugin = {"pretty"},
features = {"classpath:features"},
glue = {"classpath:WhitBread.WhitBread.WhitBread.stepDefinitions"}
)*/
public class CucumberRunner {
}
