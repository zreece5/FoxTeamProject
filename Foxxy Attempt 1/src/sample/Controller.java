package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {
    Stage currentStage = new Stage();

    @FXML
    private TextField eMailField;

    @FXML
    private javafx.scene.control.TextField PasswordField;

    public void loadLoginPage() throws Exception {
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginScreen.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Login Screen");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));

        currentStage = primaryStage;
        currentStage.show();
    }

    //Button event that activates Login()
    public void Login(ActionEvent event) throws Exception{
        Login();
    }

    //Actually Check user Creditentials if so opens main menu.
    public void Login()throws Exception{
        if(eMailField.getText().equals("user") && PasswordField.getText().equals("pass")){
            displayMainMenu();
        }
        else{
            System.out.println("Username or Password Does not match");
        }
    }

    public void displayMainMenu() throws Exception{
        System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    //Button event for Create profile Page
    public void mmCreateClick(ActionEvent event) throws Exception{
        displayCreateProfile();
    }

    //Displays Create Profile Page
    public void displayCreateProfile() throws Exception{
        System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/CreateProfile.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 900));
        primaryStage.show();
    }

    //Button Click Event for Edit Profile Button
    public void mmEditClick(ActionEvent event) throws Exception{
        displayEditProfile();
    }

    //Displays Edit Profile Page
    public void displayEditProfile() throws Exception{
        System.out.println("Username And Login Match");
        currentStage.hide();
        Stage primaryStage = new Stage();
        System.out.println("Step 1");
        Parent root = FXMLLoader.load(getClass().getResource("view/EditProfile.fxml"));
        System.out.println("step 2");
        primaryStage.setTitle("Main Menu");
        System.out.println("Step 3");
        primaryStage.setScene(new Scene(root, 600, 900));
        primaryStage.show();
    }

    //Saves Data from Edit Profile Page
    public void saveProfileEditData() {

    }

    //Saves Data from Create Profile Page
    public void saveProfileCreateData() {

    }
}
