package com.skrill.interns.weather;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WeatherForecast {

    private static String[] dayHTMLClasses = { ".wfTodayContent", ".wfTomorrowContent", ".wfDayAfterTomorrowContent" };

    public String getWeather(String city, int numberOfDays) throws IOException {
        StringBuilder forecast = new StringBuilder();

        for (Cities cities : Cities.values()) {
            if (cities.name().equals(city)) {
                String url = Cities.valueOf(city).getUrl();
                if (numberOfDays > 0 && numberOfDays <= 3) {
                    Document sinoptik = Jsoup.connect(url).get();
                    for (int i = 0; i < numberOfDays; i++) {
                        forecast.append(getForecast(sinoptik, dayHTMLClasses[i]));
                    }
                    return forecast.toString();
                }
            }
        }
        forecast.append("No Information available for this city!");
        return forecast.toString();
    }

    public String getForecast(Document url, String className) {
        StringBuilder builder = new StringBuilder();
        String day = url.select(className + " .wfNonCurrentDay").text();
        builder.append(day + "\n");

        String date = url.select(className + " .wfNonCurrentDate").text();
        builder.append(date + "\n");

        String temperature = url.select(className + " .wfNonCurrentTemp").text();
        builder.append(temperature + "\n");

        String weatherCondition = url.select(className + " .wfNonCurrentCond").text();
        builder.append(weatherCondition + "\n");

        String wind = url.select(className + " .wfNonCurrentWind ").text();
        builder.append(wind + "\n");
        builder.append("**************************************");
        builder.append("\n");

        return builder.toString();
    }
}
