/**
 * Created by mati on 2016-07-06.
 */

$(document).on("ready", function(){
    submitHandler();
});

function submitHandler() {
    var form = $("#registerForm");
    form.on("submit", function(){
        if(Form.isValid()){
            Form.send();
        }
        return false;
    });
}

var Form = {

    isValid: function(){
        return true;
    },

    send: function(){
        $.ajax({
            url: "/api/users",
            method: "POST",
            data: Form.getData(),
            headers: {
                'Content-Type': 'application/json;charset=UTF-8'
            }
        })
            .done(function(data, textStatus, xhr){
                if(xhr.status == 201){
                    console.log(textStatus);
                }
            })
            .fail(function(r){console.log(r)})
    },

    getData: function(){

        var serializeForm = $("#registerForm").serializeArray();

        var jsObject = {};
        $.each(serializeForm, function(){
            jsObject[this.name] = this.value;
        });

        return JSON.stringify(jsObject);
    }

};