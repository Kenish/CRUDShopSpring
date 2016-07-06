/**
 * Created by mati on 2016-07-06.
 */
$(document).on("ready", function(){
    submitHandler();
});

function submitHandler() {
    $("#submit").on("click", function(e){
        e.preventDefault();
        if(Form.isValid()){
            Form.send();
        }
    });
}

var Form = {

    isValid: function(){
        return true;
    },

    send: function(){
        $.ajax({
            url: "127.0.0.1:8080/api/users",
            method: "POST",
            data: Form.getData(),
            dataType: "jsonp"
        })
            .done(function(response){
                console.log("Server response is: " + response.responseText);
                console.log("Status: " + response.status)
            })
    },

    getData: function(){
        var json = $("#registerForm").serializeObject();
        return json;
    }

};