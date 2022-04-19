package com.lab5.blaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager; 

public class BlazeSteps {
    private WebDriver driver;
    

    @When("Access {string}")
    public void accessBlaze(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    @And("Select {string} as departure")
    public void chooseDeparture(String from) {
        driver.findElement(By.name("fromPort")).click();
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = '" + from + "']")).click();
    }    
    @And("Select {string} as destination")
    public void chooseDestination(String to) {
        driver.findElement(By.name("toPort")).click();
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
    }

    @And("Click find flights")
    public void findFlights() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("the page title should be Flights from {string} to {string}:")
    public void getTitle(String from, String to) {
        assertEquals("Flights from " + from + " to " + to + ":", driver.findElement(By.cssSelector("h3")).getText());
    }
    
    @And("Press Choose This Flight")
    public void chooseFlight() {
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
    }
      
    @And("Check reservation info")
    public void checkInfo() {
        assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.cssSelector("h2")).getText());
        assertEquals("Airline: United", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(2)")).getText());
        assertEquals("Flight Number: UA954", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(3)")).getText());
        assertEquals("Price: 400", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(4)")).getText());
        assertEquals("Arbitrary Fees and Taxes: 514.76", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(5)")).getText());
    }
    
    @And("Fill the form")
    public void fillForm() {
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Pylance");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Quinta Da Samarrõa");
        driver.findElement(By.id("city")).sendKeys("Viseu");
        driver.findElement(By.id("state")).sendKeys("Tuga");
        driver.findElement(By.id("zipCode")).sendKeys("3505514");
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("962235235");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2024");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Pylance Pylex");
        
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
    
    @Then("Check purchase info")
    public void ending() {
        assertEquals("Thank you for your purchase today!", driver.findElement(By.cssSelector("h1")).getText());
        
        // Asserts in confirmation page
        assertEquals("PendingCapture", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());
        assertEquals("555 USD", driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText());
        assertEquals("xxxxxxxxxxxx1111", driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText());
        assertEquals("11 /2018", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText());
        assertEquals("888888", driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText());
        
        assertEquals("BlazeDemo Confirmation", driver.getTitle());
        driver.quit();
    }
}