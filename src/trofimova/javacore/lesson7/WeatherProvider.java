package trofimova.javacore.lesson7;

import trofimova.javacore.lesson7.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;
}
