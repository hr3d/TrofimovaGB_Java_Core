package trofimova.javacore.lesson8;


import trofimova.javacore.helpForLesson8.presentation.Demo;
import trofimova.javacore.lesson8.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "city TEXT NOT NULL,\n" +
        "date_time TEXT NOT NULL,\n" +
        "weather_text TEXT NOT NULL,\n" +
        "temperature REAL NOT NULL\n" +
        ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    String selectWeatherQuery = "SELECT * FROM weather";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
        createTableIfNotExists();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery);
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (connection != null) connection.close();
        }

        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws SQLException {
        Connection connection = null;
        List<WeatherData> weatherDataList = new ArrayList<>();
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectWeatherQuery);
            while(rs.next()){
                WeatherData weatherData = new WeatherData();
                weatherData.setCity(rs.getString("city"));
                weatherData.setLocalDate(rs.getString("date_time"));
                weatherData.setText(rs.getString("weather_text"));
                weatherData.setTemperature(rs.getDouble("temperature"));

                weatherDataList.add(weatherData);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (connection != null) connection.close();
        }
        return weatherDataList;
    }
}