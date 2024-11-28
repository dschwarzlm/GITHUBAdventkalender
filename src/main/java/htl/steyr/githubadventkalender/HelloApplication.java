package htl.steyr.githubadventkalender;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloApplication extends Application {

    private static final String[] IT_RIDDLES = {
            "Rätsel 1: Ich bin ein Weg, auf dem Daten fließen können, aber ich kann keine Daten speichern. Was bin ich?",
            "Rätsel 2: Ich bin eine Art von Malware, die den Benutzer erpresst, indem sie wichtige Dateien verschlüsselt. Wer bin ich?",
            "Rätsel 3: Ich bin ein Protokoll, das für sichere Datenübertragungen im Web verwendet wird. Was bin ich?",
            // Fügen Sie hier weitere Rätsel hinzu
    };

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        for (int i = 1; i <= 24; i++) {
            Button button = new Button(String.valueOf(i));
            button.setPrefSize(60, 60);
            button.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            int day = i;
            button.setOnAction(e -> openDoor(day));
            gridPane.add(button, (i - 1) % 6, (i - 1) / 6);
        }

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(gridPane);
        vbox.setStyle("-fx-background-color: linear-gradient(to bottom, #ffcccc, #ff9999);");

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("Adventskalender");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openDoor(int day) {
        String riddle = IT_RIDDLES[(day - 1) % IT_RIDDLES.length];
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("IT-Rätsel");
        alert.setHeaderText("Türchen " + day);
        alert.setContentText(riddle);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
