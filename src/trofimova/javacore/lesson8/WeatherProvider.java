package trofimova.javacore.lesson8;

import trofimova.javacore.lesson8.Periods;
import trofimova.javacore.lesson8.WeatherData;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

    WeatherData getAllFromDb() throws IOException;
}
