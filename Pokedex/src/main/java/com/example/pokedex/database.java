package com.example.pokedex;

import java.sql.*;

public class database {

    public Connection dbConnect()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/pokedex";
            String username = "root";
            String password = "admin1234";

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");
            return con;

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }


    public ResultSet showAllPokemons() throws SQLException {

        Connection con = dbConnect();
        Statement stmt = con.createStatement();

        String sql = "SELECT * FROM pokemons; ";

        return stmt.executeQuery(sql);
    }

    //save favorite
    public void setAsFavorite(Boolean favorite,String name) throws SQLException {

        String sql = "UPDATE pokemons\n" +
                "SET isFavorite = ?\n" +
                "WHERE name = ?;\n";

        String pokemonName = name;

        int isFav = favorite? 1:0;

        Connection con = dbConnect();
        PreparedStatement query = con.prepareStatement(sql);
        query.setInt(1,isFav);
        query.setString(2,name);
        query.executeUpdate();



    }
}
