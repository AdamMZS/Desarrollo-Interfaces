package org.example.hellojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Gestión de Tareas");

        Label titulo = new Label("Gestor de Tareas");

        TextArea textArea = new TextArea();
        textArea.setPromptText("Descripción");

        var button = new Button("Guardar");
        var lista = new ListView<String>();

        button.setOnAction(e -> {
            lista.getItems().add(textArea.getText());
            if (textArea.getText().trim().isEmpty()) {
                textArea.setText("Error: No se puede agregar una tarea vacía");
                textArea.setStyle("-fx-border-color: red; -fx-border-width: 2px;-fx-text-fill: red;");
            }else
            textArea.clear();
        });

        VBox root = new VBox();
        root.getChildren().addAll(
                titulo,
                textArea,
                button,
                lista
        );
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}