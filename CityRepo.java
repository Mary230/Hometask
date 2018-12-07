package for_db.ht14;

import for_db.Repos.DatabaseConnection;
import javaClasses.ht14.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityRepo {
    private static Connection connection;

    public CityRepo() {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstanceToGetConnection();
        connection = databaseConnection.getConnection();
    }

    public List<City> findAllByRegion(int id){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM public.city WHERE region_id = ?");
            preparedStatement.setInt(1, id);
            List<City> cities = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cities.add(new City(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return cities;
        } catch (SQLException e) {
            return null;
        }


    }

}
