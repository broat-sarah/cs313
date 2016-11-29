/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalFeed.control;

import java.util.StringTokenizer;
import wicket.contrib.gmap.api.GLatLng;

/**
 *
 * @author sarahbroat
 */
public class GeoLatLng {
    
    /**
     * Default serialVersionUID.
     */
    public static final long serialVersionUID = 1L;
    public double lat;
    public double lng;
    public boolean unbounded;

    /**
     * Construct.
     *
     * @param lat
     * @param lng
     */
    public GeoLatLng(double lat, double lng)
    {
        this(lat, lng, false);
    }

    /**
     * Construct.
     *
     * @param lat
     * @param lng
     * @param unbounded
     */
    public GeoLatLng(double lat, double lng, boolean unbounded)
    {
        this.lat = lat;
        this.lng = lng;
        this.unbounded = unbounded;
    }

    public double getLat()
    {
        return lat;
    }

    public double getLng()
    {
        return lng;
    }
    
    @Override
    public String toString() {
        return "GeoLatLng{" + "lat=" + lat + ", lng=" + lng + ", unbounded=" + unbounded + '}';
    }
    
    
    /**
     * @return 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int PRIME = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        result = PRIME * result + (unbounded
                ? 1231
                : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeoLatLng other = (GeoLatLng) obj;
        if (Double.doubleToLongBits(this.lat) != Double.doubleToLongBits(other.lat)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lng) != Double.doubleToLongBits(other.lng)) {
            return false;
        }
        return this.unbounded == other.unbounded;
    }

    /**
     * @return 
     * @see java.lang.Object#equals(java.lang.Object)
     */
   

    /**
     * (37.34068368469045, -122.48519897460936)
     * @param value
     * @return 
     */
    public static GLatLng parse(String value)
    {
        try
        {
            StringTokenizer tokenizer = new StringTokenizer(value, "(, )");

            float lat = Float.valueOf(tokenizer.nextToken());
            float lng = Float.valueOf(tokenizer.nextToken());
            return new GLatLng(lat, lng);
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
