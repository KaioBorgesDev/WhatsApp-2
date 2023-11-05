package com.example.whatsapp;

import comandos.ComandosDB;
import entity.Conversation;
import entity.Messager;
import entity.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class StartController {

    @FXML
    private Button btArchiveds;

    @FXML
    private Button btSendMessage;

    @FXML
    private FlowPane chatPane;

    @FXML
    private FlowPane containerC;

    @FXML
    private TextField tfSendMenssages;

    @FXML
    private Label userNameChat;

    @FXML
    private Pane usuarioChat;

    ComandosDB comandosDB = new ComandosDB();

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

            Label nameLabel = new Label(usuario.getNome());
            nameLabel.setLayoutX(52);
            nameLabel.setLayoutY(10);
            nameLabel.setStyle("-fx-text-fill: #483c3c;");
            nameLabel.getStyleClass().add("text");  // Adicione a classe de estilo se necessário
            nameLabel.setFont(new Font(13));
            nameLabel.setCursor(Cursor.HAND);

            Image image = new Image(Objects.requireNonNull(getClass().getResource("/imgs/homem.png")).toExternalForm());

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(39.0);
            imageView.setFitHeight(30.0);
            imageView.setLayoutX(6.0);
            imageView.setLayoutY(5.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);


            anchorPane.setOnMouseClicked(event -> {
                createChats(usuario);
                Conversation conversation = comandosDB.pegarConversaDono(1L, 2L,"Select * from conversas where id_usuario = ? and id_usuario_2 = ? ");
                createCardMessage(conversation);

            });
            btSendMessage.setOnMouseClicked(event -> {
                String message = tfSendMenssages.getText();


            });


            anchorPane.getChildren().addAll(nameLabel, imageView);
            containerC.getChildren().add(anchorPane);
        }
    }
    private void createCardMessage(Conversation conversation) {
        Messager mensagens = null;
        if (containerC != null) {
            AnchorPane anchorPane = createAnchorPane(50, 20);
            Long id = conversation.getIdconversa();
            mensagens = comandosDB.pegarMessager(id);

            String messagem = mensagens.getConteudo();
            Label message = new Label(messagem);
            message.setLayoutX(10);
            message.setLayoutY(10);
            message.setStyle("-fx-text-fill: #483c3c;");
            message.getStyleClass().add("text");  // Adicione a classe de estilo se necessário
            message.setFont(new Font(13));
            message.setCursor(Cursor.HAND);

            Image image = new Image(Objects.requireNonNull(getClass().getResource("/imgs/homem.png")).toExternalForm());

            anchorPane.getChildren().addAll(message);
            containerC.getChildren().add(anchorPane);
        }
    }
    private void createChats(Usuario user){
        chatPane.setVisible(true);

        userNameChat.setText(user.getNome());

    }
    private void createChats(Conversation conversation){
        chatPane.setVisible(true);



    }




    private AnchorPane createAnchorPane(double width, double height) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(width, height);
        anchorPane.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 4px; -fx-background-radius: 4px;");
        return anchorPane;
    }

}
