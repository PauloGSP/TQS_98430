package io.cucumber.skeleton;

import java.lang.annotation.Target;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        Book belly = new Book();
        belly.eat(cukes);
    }
    @When("I wait {int} hour")
    public void I_wait_hours(int hours) {
        Book belly = new Book();
 
        try 
        {
            belly.wait(hours);
        } 
        catch(Exception e)
        {
            System.err.println("Interrupted");}
        }
    @Then("my belly should growl")
    public void growl(){
        System.out.println("growls");

        //do nothing
    }
}
