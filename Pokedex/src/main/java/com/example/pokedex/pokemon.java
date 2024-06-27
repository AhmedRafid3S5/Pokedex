package com.example.pokedex;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pokemon {

    private String name;
    private String description;
    private String type;
    private String color;
    private InputStream imageSrc;
    private Float weight; //in kgs
    private Float height; //in meters

    private Boolean isFavorite;

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    private int index;

    private String evolvesTo;

    public String getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(String evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String[] evolutions;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public InputStream getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = getClass().getResourceAsStream(imageSrc);
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String[] getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(String[] evolutions) {
        this.evolutions = evolutions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Constructor ,pulls data from database result set
    public pokemon(ResultSet rs) throws SQLException {

        this.name = rs.getString("name");
        this.description = rs.getString("description");
        this.type = rs.getString("type");
        this.height = rs.getFloat("height");
        this.weight = rs.getFloat("weight");
        this.evolvesTo = rs.getString("evolvesTo");
        setColorFromType();

        String imageURL = "images/"+name + ".png";
        this.imageSrc = getClass().getResourceAsStream(imageURL);
        if(rs.getInt("isFavorite") == 1)
        {
            this.isFavorite = true;
        }
        else {
            this.isFavorite = false;
        }

    }

    public pokemon(String name, String description, String type, String color, String imageSrc, Float weight, Float height, int index, String evolvesTo) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.color = color;
        //this.imageSrc = imageSrc;
        this.weight = weight;
        this.height = height;
        this.index = index;
        this.evolvesTo = evolvesTo;
    }

    public void setColorFromType(){
        switch (this.getType().toLowerCase()){
            case "normal":
                this.color = "#A8A77A";
                break;
            case "fire":
                this.color = "#EE8130";
                break;
            case "water":
                this.color = "#6390F0";
                break;
            case "electric":
                this.color = "#F7D02C";
                break;
            case "grass":
                this.color = "#7AC74C";
                break;
            case "ice":
                this.color = "#96D9D6";
                break;
            case "fighting":
                this.color = "#C22E28";
                break;
            case "poison":
                this.color = "#A33EA1";
                break;
            case "ground":
                this.color = "#E2BF65";
                break;
            case "flying":
                this.color = "#A98FF3";
                break;
            case "psychic":
                this.color = "#F95587";
                break;
            case "bug":
                this.color = "#A6B91A";
                break;
            case "rock":
                this.color = "#B6A136";
                break;
            case "ghost":
                this.color = "#735797";
                break;
            case "dragon":
                this.color = "#6F35FC";
                break;
            case "dark":
                this.color = "#705746";
                break;
            case "steel":
                this.color = "#B7B7CE";
                break;
            case "fairy":
                this.color = "#D685AD";
                break;
            default:
                this.color = "#ccc";
                break;
        }
    }
}
