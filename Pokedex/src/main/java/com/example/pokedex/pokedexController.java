package com.example.pokedex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class pokedexController implements Initializable {

    private Boolean isFavorite = false;

    @FXML
    private VBox displayBox;

    @FXML
    private GridPane grid;

    @FXML
    private Label cardDescription;

    @FXML
    private ImageView cardImage;

    @FXML
    private Button showEvolveButton;

    @FXML
    private Label weightLabel;

    @FXML
    private Label heightLabel;



    @FXML
    private ImageView favourite ;


    @FXML
    private VBox card;

    @FXML
    private  Label cardName;

    @FXML
    private ImageView evolvedPokemonImage;


    private List<pokemon> pokemonsList = new ArrayList<>();

    @FXML
    private Text description;

    @FXML
    private TextField searchField;

    @FXML
            private  Button search;
    pokemon evolvedPokemon;
    pokemon displayedPokemon;

    MyListener myListener;
    ResultSet rs;

    database Global_database;

    private  void setDescription(pokemon _pokemon){
        description.setText(_pokemon.getDescription());
    }

    private void setFavouriteIconOn(Boolean state){
        if(state == true)
        {
            InputStream inputStream = getClass().getResourceAsStream("images/star.png");
            Image favoriteImageOn = new Image(inputStream);
            favourite.setImage(favoriteImageOn);
        }
        else{
            InputStream inputStream = getClass().getResourceAsStream("images/starBorder.png");
            Image favoriteImageOff = new Image(inputStream);
            favourite.setImage(favoriteImageOff);
        }
    }

    @FXML
    private void onFavoriteClicked(MouseEvent event) throws SQLException {

        int index = displayedPokemon.getIndex();
        //if pokemon is favorite, click will make it un favorite
        if(!pokemonsList.get(index).getFavorite()) {
            setFavouriteIconOn(true);
            //sql query to update favorite
            Global_database.setAsFavorite(true, displayedPokemon.getName());
            pokemonsList.get(index).setFavorite(true);

        }
        //if pokemon is not favorite, click will make it favorite
        else{
            setFavouriteIconOn(false);
            Global_database.setAsFavorite(false, displayedPokemon.getName());
            pokemonsList.get(index).setFavorite(false);
        }
    }
    private void showPokemonCard(pokemon _pokemon){

          displayedPokemon = _pokemon;
          int index = displayedPokemon.getIndex() ;

          System.out.println(displayedPokemon.getIndex()+displayedPokemon.getName());
          //set favorite icon on or off based on if pokemon was selected as favorite or not
          setFavouriteIconOn(pokemonsList.get(_pokemon.getIndex()).getFavorite());

          Image image = new Image(_pokemon.getImageSrc());
          Image evolvedImage ;
          cardImage.setImage(image);
          cardDescription.setText(_pokemon.getDescription());
          cardName.setText(_pokemon.getName());


          String height = "Height: "+_pokemon.getHeight() + "m";
          String weight = "Weight: "+_pokemon.getWeight() + "kg";

          heightLabel.setText(height);
          weightLabel.setText(weight);

          card.setStyle(" -fx-background-color:"+_pokemon.getColor()+";\n" +
                  "-fx-background-radius: 20;" +"\n" +
                  " -fx-effect: dropShadow(three-pass-box,#545050, 10.0 , 0.0 , 0.0 ,10.0);");
          showEvolveButton.setStyle(" -fx-background-color:"+_pokemon.getColor()+";\n" +
                  "-fx-background-radius: 20;" +
                  "-fx-border-color: white;"+
                  "-fx-border-radius: 20;");

          evolvedPokemon = getEvolvedPokemon(_pokemon);

          if(evolvedPokemon != null)
          {
              evolvedImage = new Image(evolvedPokemon.getImageSrc());
              evolvedPokemonImage.setImage(evolvedImage);
              showEvolveButton.setText("Evolves to");
              showEvolveButton.setDisable(false);
          }
          else
          {
              InputStream inputStream = getClass().getResourceAsStream("images/pokeball.png");
              Image pokeball = new Image(inputStream);
              showEvolveButton.setText("No further evolution");
              showEvolveButton.setDisable(true);
              evolvedPokemonImage.setImage(pokeball);
          }

    }

    public void clickEvolveButton(ActionEvent event){
        if(!showEvolveButton.isDisabled()){
            if(evolvedPokemon != null) {
                showPokemonCard(evolvedPokemon);
            }
        }
    }

    //returns the evolved pokemon object
    public pokemon getEvolvedPokemon(pokemon _pokemon){
        for(int i=0;i<pokemonsList.size();i++){
            if(Objects.equals(_pokemon.getEvolvesTo(), pokemonsList.get(i).getName()))
            {
                return  pokemonsList.get(i);
            }
        }
        return null;
    }

    @FXML
    public void onClickSearch(ActionEvent event){
            String nameSearched = searchField.getText();
            pokemon _pokemon = getSearchedPokemon(nameSearched);
            if(_pokemon != null){
                showPokemonCard(_pokemon);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No match");
                InputStream inputStream = getClass().getResourceAsStream("images/pokeball.gif");
                Image image = new Image(inputStream);
                ImageView errorImage = new ImageView(image);
                errorImage.setFitHeight(100);
                errorImage.setFitWidth(100);
                alert.setGraphic(errorImage);
                alert.setHeaderText("");
                alert.setContentText("Pichu was forced to wake up and tell you that this pokemon is not in this pokedex\n" +
                        "Now feel sorry for waking up Pichu !!");
                alert.showAndWait();
            }
    }
    public pokemon getSearchedPokemon(String name){
        name = name.toLowerCase();
        for(int i=0;i<pokemonsList.size();i++){
            if(Objects.equals(name, pokemonsList.get(i).getName().toLowerCase()))
            {
                return  pokemonsList.get(i);
            }
        }
        return null;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Global_database = new database();

        try {
            rs = new database().showAllPokemons();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while (rs.next()) {
                // Create a new Medicine object from each row in the ResultSet
                pokemon a_pokemon = new pokemon(rs);
                // Add the medicine object to the ObservableList
                pokemonsList.add(a_pokemon);
            }
        } catch (SQLException e) {
            // Handle potential SQLException here
            e.printStackTrace();
        }

        //Init with 1st card shown
        showPokemonCard(pokemonsList.get(0));

        if(!pokemonsList.isEmpty()){
            myListener = new MyListener() {
                @Override
                public void onClickListener(pokemon _pokemon) {
                     showPokemonCard(_pokemon);
                }

            };
        }
        int column = 0;
        int row = 1;
        for (int i = 0; i < pokemonsList.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(pokedexController.class.getResource("item.fxml"));
           // fxmlLoader.setLocation(getClass().getResource("../../resources/com.example.pokedex/item.fxml"));

            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


                ItemController itemController = fxmlLoader.getController();

                itemController.setData(i,pokemonsList.get(i), myListener);

            if (column == 4) {
                column = 0;
                row++;
            }

            grid.add(anchorPane, column++, row); //(child,column,row)
            //set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);

            //set grid height
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);


            GridPane.setMargin(anchorPane, new Insets(5));

        }


    }
}
