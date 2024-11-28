module htl.steyr.githubadventkalender {
    requires javafx.controls;
    requires javafx.fxml;


    opens htl.steyr.githubadventkalender to javafx.fxml;
    exports htl.steyr.githubadventkalender;
}