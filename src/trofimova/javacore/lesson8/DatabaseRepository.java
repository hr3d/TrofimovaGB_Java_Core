package trofimova.javacore.lesson8;



import trofimova.javacore.lesson8.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// Репозиторий для работы
public interface DatabaseRepository {

    boolean saveWeatherData(WeatherData weatherData) throws SQLException;

    List<WeatherData> getAllSavedData() throws SQLException;
}
