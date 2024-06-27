package com.example.pokedex;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.util.Objects;

public class ItemController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label cellIndex;

    @FXML
    private ImageView pokemon_image;

    @FXML
    private Label typeLabel;

    private pokemon _pokemon;

    private MyListener myListener;

    @FXML
    private VBox imageBox;
    @FXML
    private HBox textBox;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(_pokemon);
    }

    public void setData(int index,pokemon _pokemon, MyListener myListener) {
        _pokemon.setIndex(index);
        this._pokemon = _pokemon;
        this.myListener = myListener;
        nameLabel.setText(_pokemon.getName());
        typeLabel.setText(_pokemon.getType());
        cellIndex.setText("#"+(index+1));
        String name = nameLabel.getText();
        System.out.println(name);

        // Define placeholder image path (replace with your actual placeholder image path)
        InputStream placeHolder = getClass().getResourceAsStream("images/pokeball.png");
        String placeholderImagePath = "C:\\Users\\Rafid\\IdeaProjects\\Pokedex\\src\\main\\resources\\com\\example\\pokedex\\images\\pokeball.png";

        String imageURL = name + ".png";
        InputStream pokemonImage = getClass().getResourceAsStream("images/"+imageURL);
        String imagePath = "C:\\Users\\Rafid\\IdeaProjects\\Pokedex\\src\\main\\resources\\com\\example\\pokedex\\images\\" + imageURL;

        // Try loading the pokemon image
        Image image;
        try {
            image = new Image(pokemonImage);
            _pokemon.setImageSrc("images/"+imageURL);
        } catch (Exception e) {
            // Handle exception (e.g., image not found)
            System.out.println("Error loading image: " + "images/"+imageURL);
            image = new Image(placeholderImagePath);
        }

        pokemon_image.setImage(image);
        imageBox.setStyle(" -fx-background-color:"+_pokemon.getColor()+";\n" +
                "-fx-background-radius: 20;" +"\n" +
                " -fx-effect: dropShadow(three-pass-box,#545050, 10.0 , 0.0 , 0.0 ,10.0);");
        textBox.setStyle(" -fx-background-color:"+_pokemon.getColor()+";\n" +
                "-fx-background-radius: 20;");
        nameLabel.setStyle(" -fx-effect: dropShadow(three-pass-box,#282727, 3.0 , 0.0 , 0.0 ,3.0);");


    }

}
