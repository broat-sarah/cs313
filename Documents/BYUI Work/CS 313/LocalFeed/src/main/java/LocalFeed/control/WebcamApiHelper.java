/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalFeed.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class WebcamApiHelper implements ApiHelper{
    
    private final String apiKey;
    public GeoLatLng geoLatLng;
    public String searchParam;
    public Double radius;
    
    private List<LinkedHashMap> webcams;
    
    public WebcamApiHelper(String ApiKey) {
        this.apiKey = ApiKey;
    }
    
    public String getApiKey() {
        return apiKey;
    }
    
    @Override
    public void processRequest() {
        
        try {
            String webcamapi_URL = "https://webcamstravel.p.mashape.com/webcams/list/nearby=" + String.valueOf(geoLatLng.lat)
                               + "," + String.valueOf(geoLatLng.lng) + "," + radius.toString();
        
            HttpResponse<JsonNode> response = Unirest.get(webcamapi_URL).header("X-Mashape-Key", apiKey).asJson();
            
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(response.getRawBody(), Map.class);
            Map<String, Object> result = (LinkedHashMap)map.get("result");
            webcams = (ArrayList)result.get("webcams");
            
        } catch (UnirestException | IOException ex) {
            Logger.getLogger(WebcamApiHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void processRequest(GeoLatLng geoLatLng, Double radius) {
        this.geoLatLng = geoLatLng;
        this.radius = radius;
        processRequest();
    }
    
    public List<LinkedHashMap> getWebCams() {
        return webcams;
        
    }
    
    
    
}