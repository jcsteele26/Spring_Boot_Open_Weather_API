package com.steele.weatherapp.controller;

import com.steele.weatherapp.model.Request;
import com.steele.weatherapp.model.Response;
import com.steele.weatherapp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    //@Autowired
    //private WeatherService weatherService;

    @GetMapping
    public String getIndex(Model model) {
        //Response response = weatherService.getForecast("28027");
        model.addAttribute("request", new Request());
        return "index";
    }

    @PostMapping
    public String postIndex(Request request, Model model) {
        Response data = WeatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }
        
}