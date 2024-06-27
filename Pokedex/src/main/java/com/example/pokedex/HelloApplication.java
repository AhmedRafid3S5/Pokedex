package com.example.pokedex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pokedex.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1327, 720);

        stage.setTitle("Welcom to Pokédex");

        InputStream inputStream = getClass().getResourceAsStream("images/pokeball.png");
        Image logo = new Image(inputStream);
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}