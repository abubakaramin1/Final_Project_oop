module com.example.final_project_oop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.final_project_oop to javafx.fxml;
    exports com.example.final_project_oop;
}