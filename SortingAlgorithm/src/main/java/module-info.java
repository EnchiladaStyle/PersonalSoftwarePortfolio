module com.example.sortingalgorithm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sortingalgorithm to javafx.fxml;
    exports com.example.sortingalgorithm;
}