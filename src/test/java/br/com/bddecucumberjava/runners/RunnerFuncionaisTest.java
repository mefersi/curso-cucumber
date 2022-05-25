package br.com.bddecucumberjava.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = {"br.com.bddecucumberjava.steps", "br.com.bddecucumberjava.config"}, 
		tags = {"@funcionais"}, 
		plugin = {"pretty", "html:target/report-html", "json:target/report-json"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		strict = true
		)
public class RunnerFuncionaisTest {

	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.name("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
