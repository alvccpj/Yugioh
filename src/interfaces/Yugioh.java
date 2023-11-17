package interfaces;


import app.Usuario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Yugioh extends Application {

    private Usuario u;  // Suponha que você tenha uma instância de Usuario

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        Label usernameLabel = new Label("Usuário:");
        TextField usernameInput = new TextField();

        Label passwordLabel = new Label("Senha:");
        PasswordField passwordInput = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(usernameInput.getText(), passwordInput.getText()));

        Button registerButton = new Button("Registrar");
        registerButton.setOnAction(e -> showRegistrationScene());

        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, registerButton);

        Scene loginScene = new Scene(loginLayout, 300, 200);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showRegistrationScene() {
        Stage registrationStage = new Stage();
        registrationStage.setTitle("Registro");

        Label usernameLabel = new Label("Usuário:");
        TextField usernameInput = new TextField();


        Button registerButton = new Button("Registrar");
        registerButton.setOnAction(e -> handleRegistration(usernameInput.getText()));

        VBox registrationLayout = new VBox(10);
        registrationLayout.getChildren().addAll(usernameLabel, usernameInput, registerButton);

        Scene registrationScene = new Scene(registrationLayout, 300, 200);

        registrationStage.setScene(registrationScene);
        registrationStage.show();
    }

    private void handleLogin(String username, String password) {
       
    }

    private void handleRegistration(String username) {
       
    }
}