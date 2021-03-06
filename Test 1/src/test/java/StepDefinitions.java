

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


    //SPRINT 2
    @Given("^at Manage Friends Menu$")
    public void at_Manage_Friends_Menu() throws Exception {
        Controller controller = new Controller();
        controller.displayManageFriendsGroups();
    }

    @When("^press the Add Friend button$")
    public void press_the_Add_Friend_button() throws Exception {
        Controller controller = new Controller();
        controller.mmAddFriendClick();
    }

    @Then("^the Add friend Page should display$")
    public void the_Add_friend_Page_should_display() throws Exception {
        Controller controller = new Controller();
        controller.displayAddFriendSearch();
    }

    @Given("^at Main Menu$")
    public void at_Main_Menu() throws Exception {
        Controller controller = new Controller();
        controller.displayMainMenu();
    }

    @When("^press the Friend List button$")
    public void press_the_Friend_List_button() throws Exception {
        Controller controller = new Controller();
        controller.mmAddFriendClick();
    }

    @Then("^the Manage Friends page should open$")
    public void the_Manage_Friends_page_should_open() throws Exception {
        Controller controller = new Controller();
        controller.displayManageFriendsGroups();
    }

    @Given("^at Add Friend Page$")
    public void at_Add_Friend_Page() throws Exception {
        Controller controller = new Controller();
        controller.displayAddFriendSearch();
    }

    @When("^press the Search Friend Button$")
    public void press_the_Search_Friend_Button() throws Exception {
        Controller controller = new Controller();
        controller.friendSearchClick();
    }

    @Then("^the Friend Search Results page should open$")
    public void the_Friend_Search_Results_page_should_open() throws Exception {
        Controller controller = new Controller();
        controller.displayAddFriendresults();
    }

    @When("^I click Login button$")
    public void i_click_Login_button() throws Exception {
        Controller controller = new Controller();
        controller.LoginClick();
    }

    //Sprint 3
    @Given("^Match Making Home Page is open$")
    public void match_Making_Home_Page_is_open() throws Exception {
        Controller controller = new Controller();
        controller.displayStartMatchMakingHomePage();
    }


    @Given("^Main Menu is open$")
    public void main_Menu_is_open() throws Exception {
        Controller controller = new Controller();
        controller.displayMainMenu();
    }

    @When("^game selection is clicked$")
    public void game_selection_is_clicked() throws Exception {
        Controller controller = new Controller();
        controller.mmGameSelectionClick();
    }

    @Then("^the game selection page should be viewable$")
    public void the_game_selection_page_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayGameSelectionPage();
    }

    @Given("^Manage friends Page is open$")
    public void manage_friends_Page_is_open() throws Exception {
        Controller controller = new Controller();
        controller.displayManageFriendsGroups();
    }

    @When("^Views Friends and Groups button is clicked$")
    public void views_Friends_and_Groups_button_is_clicked() throws Exception {
        Controller controller = new Controller();
        controller.mmViewFriendsGroupsClick();
    }

    @Then("^the View Friends page should be viewable$")
    public void the_View_Friends_page_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayViewFriendsGroupsPage();
    }

    @Given("^see the search friends page$")
    public void see_the_search_friends_page() throws Exception {
        Controller controller = new Controller();
        controller.displayAddFriendSearch();
    }

    @When("^search button is clicked$")
    public void search_button_is_clicked() throws Exception {
        Controller controller = new Controller();
        controller.mmAddFriendClick();
    }

    @Then("^the search Results page should be viewable$")
    public void the_search_Results_page_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayAddFriendresults();
    }

    @When("^One v One button is clicked$")
    public void one_v_One_button_is_clicked() throws Exception {
        Controller controller = new Controller();
        controller.mmMatchMaking1v1Click();
    }

    @Then("^the one V One wait page should be viewable$")
    public void the_one_V_One_wait_page_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayMatchMaking1v1Page();
    }

    @When("^Three V Three button is clicked$")
    public void three_V_Three_button_is_clicked() throws Exception {
        Controller controller = new Controller();
        controller.mmMatchMaking3v3Click();
    }

    @Then("^the Three v Three wait page should be viewable$")
    public void the_Three_v_Three_wait_page_should_be_viewable() throws Exception {
        Controller controller = new Controller();
        controller.displayMatchMaking3v3Page();
    }

}
