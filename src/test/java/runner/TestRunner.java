package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			tags = "@run",
			features = "src/test/java/features",
			glue = {"base","steps"},
			monochrome = true,
			dryRun = false,
			plugin = {"html:target/index.html", "json:target/report.json"})
	public class TestRunner {
	
	

}
