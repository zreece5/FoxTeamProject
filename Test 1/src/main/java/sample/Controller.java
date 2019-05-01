package sample;/*

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;*/


public class Controller {
    /*Stage currentStage = new Stage();

    @FXML
    private TextField eMailField;

    @FXML
    private javafx.scene.control.TextField PasswordField;*/

    public void loadLoginPage() throws Exception {
        /*Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginScreen.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Login Screen");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));

        currentStage = primaryStage;
        currentStage.show();*/
    }

    public void LoginClick() throws Exception {
            Login();
    }

    public void Login()throws Exception{
        /*if(eMailField.getText().equals("user") && PasswordField.getText().equals("pass")){
            System.out.println("Username And Login Match");
            currentStage.hide();
            Stage primaryStage = new Stage();
            System.out.println("Step 1");
            Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
            System.out.println("step 2");
            primaryStage.setTitle("Main Menu");
            System.out.println("Step 3");
            primaryStage.setScene(new Scene(root, 600, 400));
            currentStage = primaryStage;
            currentStage.show();
        }
        else{
            System.out.println("Username or Password Does not match");
        }*/
    }

    //This method is just for testing purposes
    public void Login(String username, String password)throws Exception{
        if(username.equals("user") && password.equals("pass")) {
            System.out.println("Username and Password are correct");
        }
        /*if(eMailField.getText().equals("user") && PasswordField.getText().equals("pass")){
            System.out.println("Username And Login Match");
            currentStage.hide();
            Stage primaryStage = new Stage();
            System.out.println("Step 1");
            Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
            System.out.println("step 2");
            primaryStage.setTitle("Main Menu");
            System.out.println("Step 3");
            primaryStage.setScene(new Scene(root, 600, 400));
            currentStage = primaryStage;
            currentStage.show();
        }
        else{
            System.out.println("Username or Password Does not match");
        }*/
    }

    public void displayMainMenu() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    /*public void mmCreateClick(ActionEvent event) throws Exception{
        displayCreateProfile();
    }*/

    public void displayCreateProfile() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/CreateProfile.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 900));
        primaryStage.show();*/
    }

    /*public void mmEditClick(ActionEvent event) throws Exception{
        displayEditProfile();
    }*/

    public void displayEditProfile() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/EditProfile.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 900));
        primaryStage.show();*/
    }

    //Button Click Event for Add Friend Button
    public void mmAddFriendSearchClick() throws Exception{
        displayAddFriendSearch();
    }

    //Displays Add Friend Page
    public void displayAddFriendSearch() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/AddFriend.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Add Friend Search");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }


    //Button Click Event for Friend Search Button
    public void friendSearchClick() throws Exception{
        displayAddFriendresults();
    }

    //Displays friend Search Results Page
    public void displayAddFriendresults() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/SearchResults.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Friend Search Results");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }


    //Button Click Event for Manage Friends Button
    public void mmAddFriendClick() throws Exception{
        displayManageFriendsGroups();
    }

    //Displays Manage Friends Page
    public void displayManageFriendsGroups() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/ManageFriendsGroups.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    public void mmGameSelectionClick() throws Exception{
        displayGameSelectionPage();
    }

    //Displays Game selection Page
    public void displayGameSelectionPage() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/GameSelection.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    //Button Click Event for Start MatchMaking Home
    public void mmStartMatchMakingClick() throws Exception{
        displayStartMatchMakingHomePage();
    }

    //Displays Start Matchmaking Home Page
    public void displayStartMatchMakingHomePage() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/StartMatchmakingHome.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    //Button Click Event for View Friends and Groups
    public void mmViewFriendsGroupsClick() throws Exception{
        displayViewFriendsGroupsPage();
    }

    //Displays View friends and Groups Page
    public void displayViewFriendsGroupsPage() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/viewFriendsGroups.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 245, 454));
        primaryStage.show();*/
    }

    //Button Click Event for MatchMaking 1v1
    public void mmMatchMaking1v1Click() throws Exception{
        displayMatchMaking1v1Page();
    }

    //Displays 1v1 Matchmaking 1v1 Page
    public void displayMatchMaking1v1Page() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/Matchmaking1v1.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    //Button Click Event for MatchMaking 3v3
    public void mmMatchMaking3v3Click() throws Exception{
        displayMatchMaking3v3Page();
    }

    //Displays 1v1 Matchmaking 1v1 Page
    public void displayMatchMaking3v3Page() throws Exception{
        /*System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/Matchmaking3v3.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Manage Friends and Groups");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    //Saves Data from Edit Profile Page
    public void saveProfileEditData() {

    }

    //Saves Data from Create Profile Page
    public void saveProfileCreateData() {

    }
}
