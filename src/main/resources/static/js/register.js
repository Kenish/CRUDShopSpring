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
            url: "http://localhost:8080/api/users",
            method: "POST",
            data: Form.getData()
        })
            .done(function(response){
                console.log("Server response is: " + response.responseText);
                console.log("Status: " + response.status)
            })
            .fail(function(r){console.log(r)})
    },

    getData: function(){
        var json = $("#registerForm").serializeObject();
        return json;
    }

};