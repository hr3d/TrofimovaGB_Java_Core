package trofimova.javacore.lesson8;

import trofimova.javacore.lesson8.Functionality;
import trofimova.javacore.lesson8.Periods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_ALL_PREVIOUSLY_REQUESTED_WEATHER);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_ALL_PREVIOUSLY_REQUESTED_WEATHER:
                getAllPreviouslyWeather();
                break;
        }
    }

    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() throws IOException{
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }

    public void getAllPreviouslyWeather() throws IOException{
        weatherProvider.getWeather(Periods.SHOW_ALL_RESULT);
    }
}
