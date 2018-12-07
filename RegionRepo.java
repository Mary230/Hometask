package for_db.ht14;

import for_db.Repos.DatabaseConnection;
import javaClasses.ht14.City;
import javaClasses.ht14.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepo {
    private static Connection connection;

    public RegionRepo() {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstanceToGetConnection();
        connection = databaseConnection.getConnection();
    }

    public List<Region> findAllByCountry(int id){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM public.region WHERE country_id = ?");
            preparedStatement.setInt(1, id);
            List<Region> regions = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                regions.add(new Region(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return regions;
        } catch (SQLException e) {
            return null;
        }


    }
}
