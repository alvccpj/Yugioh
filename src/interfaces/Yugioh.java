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

    private Usuario u;
    private TextField usernameInput;

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
        // Verificar se o nome de usuário e a senha estão corretos
        if (username.equals("alvaro") && password.equals("alvaro123")) {
            System.out.println("Login bem-sucedido. Fechando a interface.");
            // Fechar a interface
            Stage stage = (Stage) usernameInput.getScene().getWindow();
            stage.close();
        } else {
            // Exibir mensagem de erro
            System.out.println("Login incorreto. Por favor, tente novamente.");
        }
    }

    private void handleRegistration(String username) {
       
    }
}
