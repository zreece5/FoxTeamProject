

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sample.Controller;
import sample.Main;

public class StepDefinitions {
    //Login Tests
    @Given("^I started the application$")
    public void I_started_the_application() throws Throwable {
        Main main = new Main();
        main.start();
    }
    @When("^I use the correct username and password$")
    public void I_use_the_correct_username_and_password() throws Throwable {
        String username = "user";
        String password = "pass";
        Controller controller = new Controller();
        controller.Login(username, password);
    }
    @Then(("^I should be logged in$"))
    public void I_should_be_logged_in() throws Throwable {
        Controller controller = new Controller();
        controller.displayMainMenu();
    }


    //Main Menu
    @Given("^I have logged in$")
    public void i_have_logged_in() throws Exception {
        String username = "user";
        String password = "pass";
        Controller controller = new Controller();
        controller.Login(username, password);
    }

    @When("^I open the main menu page$")
    public void i_open_the_main_menu_page() throws Exception {
        Controller controller = new Controller();
        controller.Login();
    }

    @Then("^the main menu should be viewable$")
    public void the_main_menu_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayMainMenu();
    }

    //Create Profile Tests
    @Given("^I have logged in and see the main menu screen$")
    public void I_have_logged_in_and_see_the_main_menu_screen() throws Throwable {
        Controller controller = new Controller();
        controller.loadLoginPage();


        //throw new PendingException();
    }
    @When("^I open the create profile page$")
    public void I_open_the_create_profile_page() throws Throwable {
        Controller controller = new Controller();
        controller.displayCreateProfile();

    }
    @Then("^my profile should be createable$")
    public void my_profile_should_be_createable() throws Throwable {
        Controller controller = new Controller();
        controller.saveProfileCreateData();

    }

    //Edit Profile Tests
    @When("^I open the edit profile page$")
    public void i_open_the_edit_profile_page() throws Exception {
        Controller controller = new Controller();
        controller.displayEditProfile();

    }

    @Then("^my profile should be editable$")
    public void my_profile_should_be_editable() throws Exception {
        Controller controller = new Controller();
        controller.saveProfileEditData();
    }



}
