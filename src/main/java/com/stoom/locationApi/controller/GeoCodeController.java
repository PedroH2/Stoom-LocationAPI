package com.stoom.locationApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stoom.locationApi.apiConsumer.GeoCodeResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class GeoCodeController {

    private final String APIKEY = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
    @RequestMapping(path = "/geocode", method = RequestMethod.GET )
    public GeoCodeResult getGeocode(@RequestParam String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress)
                .get()
                .addHeader("geocoding-host", "maps.googleapis.com/maps/api/geocode/json?address=")
                .addHeader("geocoding-api-key", APIKEY)
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody.string(), GeoCodeResult.class);
    }
}