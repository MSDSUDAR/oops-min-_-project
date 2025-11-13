package MiniProject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FlightCheckInSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flight Check-In System");

        // Labels
        Label title = new Label("✈ Flight Check-In System");
        title.setFont(new Font("Arial", 24));

        Label nameLabel = new Label("Passenger Name:");
        Label flightLabel = new Label("Flight Number:");
        Label destinationLabel = new Label("Destination:");
        Label seatLabel = new Label("Seat Number:");

        // Input Fields
        TextField nameField = new TextField();
        TextField flightField = new TextField();
        TextField destinationField = new TextField();
        TextField seatField = new TextField();

        // Button
        Button generateBtn = new Button("Generate Boarding Pass");
        generateBtn.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-weight: bold;");

        // Boarding Pass area
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);
        outputArea.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 14;");

        // Button Action
        generateBtn.setOnAction(e -> {
            String name = nameField.getText();
            String flight = flightField.getText();
            String destination = destinationField.getText();
            String seat = seatField.getText();

            if (name.isEmpty() || flight.isEmpty() || destination.isEmpty() || seat.isEmpty()) {
                outputArea.setText("⚠ Please fill in all fields before generating the boarding pass.");
            } else {
                String boardingPass =
                        "==============================\n" +
                        "       BOARDING PASS\n" +
                        "==============================\n" +
                        "Passenger : " + name + "\n" +
                        "Flight No : " + flight + "\n" +
                        "Destination: " + destination + "\n" +
                        "Seat No   : " + seat + "\n" +
                        "Gate      : " + ((int)(Math.random() * 10) + 1) + "\n" +
                        "Status    : CHECKED-IN ✅\n" +
                        "==============================\n" +
                        "Have a safe flight!\n";

                outputArea.setText(boardingPass);
            }
        });

        // Layout
        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);
        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(flightLabel, 0, 1);
        form.add(flightField, 1, 1);
        form.add(destinationLabel, 0, 2);
        form.add(destinationField, 1, 2);
        form.add(seatLabel, 0, 3);
        form.add(seatField, 1, 3);

        VBox layout = new VBox(20, title, form, generateBtn, outputArea);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
