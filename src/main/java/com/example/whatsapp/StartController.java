package com.example.whatsapp;

import comandos.ComandosDB;
import entity.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;


import java.util.List;
import java.util.Objects;


public class StartController {

    @FXML
    private FlowPane containerC;
    @FXML
    private FlowPane chatPane;

    @FXML
    private void initialize() {
        Platform.runLater(this::loadData);
    }

    private void loadData() {
        loadUsers();
    }

    private void loadUsers() {
        ComandosDB comandos = new ComandosDB();
        if (containerC != null) {
            List<Usuario> clientsList = comandos.todosUser();
            containerC.getChildren().clear();
            clientsList.forEach(this::createCardChats);
        }
    }
    private void createCardChats(Usuario usuario) {
        if (containerC != null) {
            AnchorPane anchorPane = createAnchorPane(330, 40);

            Label logInLabel = new Label(usuario.getNome());
            logInLabel.setLayoutX(52);
            logInLabel.setLayoutY(10);
            logInLabel.setStyle("-fx-text-fill: #483c3c;");
            logInLabel.getStyleClass().add("text");  // Adicione a classe de estilo se necessário
            logInLabel.setFont(new Font(13));
            logInLabel.setCursor(Cursor.HAND);

            Image image = new Image(Objects.requireNonNull(getClass().getResource("/imgs/homem.png")).toExternalForm());

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(39.0);
            imageView.setFitHeight(30.0);
            imageView.setLayoutX(6.0);
            imageView.setLayoutY(5.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);


            anchorPane.setOnMouseClicked(event -> chatPane.setVisible(true));


            anchorPane.getChildren().addAll(logInLabel, imageView);
            containerC.getChildren().add(anchorPane);
        }
    }
    private void createChats(Usuario user){

    }



    private AnchorPane createAnchorPane(double width, double height) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(width, height);
        anchorPane.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 4px; -fx-background-radius: 4px;");
        return anchorPane;
    }

}
