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
        List<String> webcamURLs = getWebCams(geoCoordinates);
        // Send list of webcams to .jsp
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
    
    private List<String> getWebCams (GeoLatLng geoCoordinates) throws UnirestException {
        
        String radius = "50";
        String webcamapi_URL = "https://webcamstravel.p.mashape.com/webcams/list/nearby=" + String.valueOf(geoCoordinates.lat)
                               + "," + String.valueOf(geoCoordinates.lng) + "," + radius;
        
        
        HttpResponse<JsonNode> response = Unirest.get(webcamapi_URL).header("X-Mashape-Key", "kTqdiyRL6EmshKwrMBbktSxWuJ4Qp1Vos1HjsnjIugmfxSG56Y").asJson();

        JsonNode responseBody = response.getBody();
        //<a name="lkr-timelapse-player" data-id="1459258090" data-play="day" href="//lookr.com/1459258090" target="_blank">Seattle: Columbia St Express Lanes</a><script async type="text/javascript" src="//api.lookr.com/embed/script/timelapse.js"></script>
        
        
//UriBuilder uriBuilder = UriBuilder.fromUri("https://webcamstravel.p.mashape.com/webcams/list/nearby={lat},{lng},{radius}").queryParam("s", request.getParameter("searchParam"));
        
        //ObjectMapper mapper = new ObjectMapper();

        //Map<String, Object> map = mapper.readValue(uriBuilder.build().toURL(), Map.class);

        //List list = (List) map.get("Search");
        //<a name="lkr-timelapse-player" data-id="1459258090" data-play="day" href="//lookr.com/1459258090" target="_blank">Seattle: Columbia St Express Lanes</a><script async type="text/javascript" src="//api.lookr.com/embed/script/timelapse.js"></script>
        //request.setAttribute("webcams", list);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        
        List<String> webcamURLs = new ArrayList();
        return webcamURLs;
    }
}
