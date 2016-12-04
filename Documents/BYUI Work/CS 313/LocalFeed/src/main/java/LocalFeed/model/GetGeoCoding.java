/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalFeed.model;

import LocalFeed.control.GeoLatLng;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sarahbroat
 */
@WebServlet(name = "GetGeoCoding", urlPatterns = {"/GetGeoCoding"})
public class GetGeoCoding extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        String searchParam = (String) request.getParameter("searchParam");

        
        // Get Geocoding data from google
        GeoLatLng geoCoordinates = getGeoCode (searchParam);

        // Get Webcams from webcamstravel
        List<LinkedHashMap> webcams = getWebCams(geoCoordinates);
        
        // Send list of webcams to .jsp
        request.setAttribute("webcams", webcams);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GetGeoCoding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GetGeoCoding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private GeoLatLng getGeoCode (String searchParam) throws Exception {
        
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCUKop6Z-SYaibrXoQavQY1kQn8hNuKwZM");
        GeocodingResult[] results =  GeocodingApi.geocode(context, searchParam).await();
        System.out.println(results[0].formattedAddress);    
        
        double lat = results[0].geometry.location.lat;
        double lng = results[0].geometry.location.lng;
        GeoLatLng geoCoordinates = new GeoLatLng(lat, lng);
        
        return geoCoordinates;
    }
    
    private List<LinkedHashMap> getWebCams (GeoLatLng geoCoordinates) throws UnirestException, IOException {
        
        String radius = "50";
        String webcamapi_URL = "https://webcamstravel.p.mashape.com/webcams/list/nearby=" + String.valueOf(geoCoordinates.lat)
                               + "," + String.valueOf(geoCoordinates.lng) + "," + radius;
        
        
        HttpResponse<JsonNode> response = Unirest.get(webcamapi_URL).header("X-Mashape-Key", "kTqdiyRL6EmshKwrMBbktSxWuJ4Qp1Vos1HjsnjIugmfxSG56Y").asJson();
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(response.getRawBody(), Map.class);
        Map<String, Object> result = (LinkedHashMap)map.get("result");
        List<LinkedHashMap> webcams = (ArrayList)result.get("webcams");
        
        return webcams;
    }
}
