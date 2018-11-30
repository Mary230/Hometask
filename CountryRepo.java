package for_db.ht14;

import for_db.Repos.DatabaseConnection;
import javaClasses.ht14.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryRepo {
    private static Connection connection;

    public CountryRepo() {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstanceToGetConnection();
        connection = databaseConnection.getConnection();
    }

    public Country findCountryByName(String name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ajax.country WHERE name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Country(resultSet.getInt("id"),
                    resultSet.getString("name"));
        } catch (SQLException e) {
            return null;
        }

    }

    public List<Country> findAll(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.countryes");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Country> countries = new ArrayList<>();
            while (resultSet.next()){
                countries.add(new Country(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return countries;
        } catch (SQLException e) {
            return null;
        }
    }

}
