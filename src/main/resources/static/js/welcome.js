/**
 * Created by mati on 2016-07-08.
 */
$(document).on("ready", function(){
    setUserName();
});

function setUserName(){
    var username = getUrlParameter("user");
    $("#user").text(username);
    window.history.pushState('Register success', 'Title', '/welcome');

}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};