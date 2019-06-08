package ru.stqa.pft.adressbook.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:bdd", plugin = {"pretty", "html:build/cucumber-reports"})
public class GroupTests extends AbstractTestNGCucumberTests {
}
