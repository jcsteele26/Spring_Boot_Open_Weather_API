package com.steele.weatherapp.service;

import com.steele.weatherapp.model.Response;
import com.steele.weatherapp.model.ZipCode;
import com.steele.weatherapp.repository.ZipRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

   // @Value("${api_key}")
    private static String apiKey = "8eb1bab775f7054ad6e4ad638a4883fe";

    @Autowired
    private static ZipRepository zipRepository;

    public void save(ZipCode zipCode) {
        zipRepository.save(zipCode);
    }

    public static Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
                + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        try {
           // ZipCode zip = new ZipCode(zipCode);
           // zipRepository.save(zip);
            return restTemplate.getForObject(url, Response.class);
        }
        catch (final HttpClientErrorException ex) {
            final Response response = new Response();
            response.setName("error");
            return response;
        }
    
    }
}