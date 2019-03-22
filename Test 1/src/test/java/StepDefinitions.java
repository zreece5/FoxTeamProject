import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
    @Given("^I have (\\d+) cukes in my belly$")
    public void i_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);

        //throw new PendingException();
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.wait(cukes);
        //throw new PendingException();
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        Belly belly = new Belly();
        belly.growl();
        //throw new PendingException();
    }
}
