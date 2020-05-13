
package com.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:Features" }, glue = { "classpath:com.cucumber.stepdefinitions",
		"classpath:com.cucumber.helper" }, tags = {
				"@Desalin" }, strict = true, monochrome = true, dryRun = true, plugin = { "pretty", "html:target/reports",
						"json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt" }

)
public class JunitRunner {

}