/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init() {
    var defaultBounds = new google.maps.LatLngBounds(
        new google.maps.LatLng(-33.8902, 151.1759),
        new google.maps.LatLng(-33.8474, 151.2631));
                    
    var input = document.getElementById('searchParam');
    var option = { bounds : defaultBounds };
                
    var autocomplete = new google.maps.places.Autocomplete(input, option);

    google.maps.event.addListener(autocomplete, 'place_changed', function() {
        fillInAddress();
    });
                
    autocomplete.addListener('place_changed', function() {
        var place = autocomplete.getPlace();
        document.getElementById('searchParam').value = place;
    })
}
