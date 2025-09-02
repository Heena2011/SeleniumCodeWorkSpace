package com.orangehrm.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Feature",   // relative path
    glue = {"stepdefinitions"},
    plugin = {"pretty"}
)
public class TestRunner {
}