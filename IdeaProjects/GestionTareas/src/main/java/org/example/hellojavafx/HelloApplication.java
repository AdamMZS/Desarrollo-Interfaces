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

    private Label titulo;
    private Label introducir;
    private TextArea textArea;
    private Button button;
    private ListView<String> lista;
    private VBox root;
    
    void initialize() {
        titulo = new Label("Gestor de Tareas");
        introducir= new Label("Introduzca una tarea:");
        textArea = new TextArea();
        textArea.setPromptText("Descripción");
        button= new Button("Guardar");
        lista = new ListView<String>();
    }
    void arrange(){
        root = new VBox();
        root.getChildren().addAll(
                titulo,
                introducir,
                textArea,
                button,
                lista
        );
    }
    void setUp(Stage stage){
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void clickOnbutton() {
        button.setOnAction(e -> {
            String tarea = textArea.getText();
            if (tarea.trim().isEmpty()) {
                textArea.setText("Error: No se puede agregar una tarea vacía");
                textArea.setStyle("-fx-border-color: red; -fx-border-width: 2px;-fx-text-fill: red;");
            } else {
                lista.getItems().add(tarea);
                textArea.clear();
            }
        });
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Gestión de Tareas");
        initialize();
        arrange();
        clickOnbutton();
        setUp(stage);
    }

}