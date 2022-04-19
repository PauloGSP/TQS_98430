package com.lab4;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * Unit test for simple App.
 */
public class HelloWorldChromeJupiterTest 
{

    private WebDriver driver; 


    @BeforeEach
    void setup() {
        driver = new ChromeDriver(); 
    }

    @Test
    void test() {
        // Exercise
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl); 
        String title = driver.getTitle(); 

        // Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java"); 
    
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}