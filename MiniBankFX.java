package application;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MiniBankFX extends Application {

    private double balance = 0.0;
    private Label balanceLabel;

    @Override
    public void start(Stage primaryStage) {
        // UI Components
        Label title = new Label("💰 Mini Banking System");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        balanceLabel = new Label("Current Balance: Rs. " + balance);
        balanceLabel.setStyle("-fx-font-size: 14px;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");
        Button checkBtn = new Button("Check Balance");
        Button exitBtn = new Button("Exit");

        // Button Actions
        depositBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    showAlert(Alert.AlertType.INFORMATION, "Deposited Rs. " + amount);
                    updateBalance();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Enter a positive amount.");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid input. Please enter a number.");
            }
        });

        withdrawBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    showAlert(Alert.AlertType.INFORMATION, "Withdrawn Rs. " + amount);
                    updateBalance();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Insufficient balance or invalid amount.");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid input. Please enter a number.");
            }
        });

        checkBtn.setOnAction(e -> updateBalance());

        exitBtn.setOnAction(e -> primaryStage.close());

        // Layout
        VBox root = new VBox(10, title, balanceLabel, amountField,
                             new HBox(10, depositBtn, withdrawBtn),
                             new HBox(10, checkBtn, exitBtn));
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f2f2f2;");

        // Scene setup
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setTitle("Mini Banking System - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: Rs. " + balance);
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Bank Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
