package trofimova.javacore.lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import trofimova.javacore.dz.Example;
import trofimova.javacore.lesson7.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.io.StringReader;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(request).execute().body().string();
            //System.out.println(jsonResponse);
            StringReader reader = new StringReader(jsonResponse);

            WeatherResponse[] weatherResponse = objectMapper.readValue(reader, WeatherResponse[].class);
            System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase() +
                    " сегодня " + weatherResponse[0].getLocalObservationDateTime().substring(0,10) +
                    " на данный момент " + weatherResponse[0].getWeatherText() +
                    ", температура - " + weatherResponse[0].getTemperature().getMetric().getValue() +
                    "°C");

        } else if(periods.equals(Periods.FIVE_DAYS)){
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(request).execute().body().string();
            //System.out.println(jsonResponse);
            StringReader reader = new StringReader(jsonResponse);

            WeatherResponseForecast weatherResponseForecast = objectMapper.readValue(reader, WeatherResponseForecast.class);

            for(int i = 0; i < 5; i++){
                System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity().toUpperCase() +
                        " на дату " + weatherResponseForecast.getDailyForecasts().get(i).getDate().substring(0,10) +
                        " ожидается днем " + weatherResponseForecast.getDailyForecasts().get(i).getDay().getIconPhrase() +
                        " ночью " + weatherResponseForecast.getDailyForecasts().get(i).getNight().getIconPhrase() +
                        ", температура от " + weatherResponseForecast.getDailyForecasts().get(i).getTemperatureForecast().getMinimum().getValue() +
                        "°C до " + weatherResponseForecast.getDailyForecasts().get(i).getTemperatureForecast().getMaximum().getValue() + "°C");
            }
        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}

