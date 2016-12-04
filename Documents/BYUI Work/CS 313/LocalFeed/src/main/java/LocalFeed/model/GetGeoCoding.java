/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalFeed.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.io.IOException;
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
         UriBuilder uriBuilder = UriBuilder.fromUri("https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCgE27tM4uyw4_akGQMaFEV119osJ7xmN0").queryParam("s", request.getParameter("searchParam"));
        
        //ObjectMapper mapper = new ObjectMapper();

        //Map<String, Object> map = mapper.readValue(uriBuilder.build().toURL(), Map.class);

        //List list = (List) map.get("Search");
        
        //request.setAttribute("geocoding", list);
        String searchParam = (String) request.getParameter("searchParam");
        
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCgE27tM4uyw4_akGQMaFEV119osJ7xmN0");
        GeocodingResult[] results =  GeocodingApi.geocode(context,
        searchParam).await();
        System.out.println(results[0].formattedAddress);    
        
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

}
