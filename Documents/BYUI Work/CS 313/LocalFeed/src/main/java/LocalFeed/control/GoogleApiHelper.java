/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalFeed.control;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class GoogleApiHelper implements ApiHelper{
    
    private final String apiKey;
    public GeoLatLng geoLatLng;
    public String searchParam;
    public Double lat;
    public Double lng;
    
    public GoogleApiHelper(String ApiKey) {
        this.apiKey = ApiKey;
    }
    
    public String getApiKey() {
        return apiKey;
    }
    
    @Override
    public void processRequest() {
        
        try {
            GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
            GeocodingResult[] results =  GeocodingApi.geocode(context, searchParam).await();
            System.out.println(results[0].formattedAddress);    
        
            lat = results[0].geometry.location.lat;
            lng = results[0].geometry.location.lng;
            geoLatLng = new GeoLatLng(lat, lng);
        } catch (Exception ex) {
            Logger.getLogger(GoogleApiHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void processRequest(String searchParam) {
        this.searchParam = searchParam;
        processRequest();
    }
    
    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }
}