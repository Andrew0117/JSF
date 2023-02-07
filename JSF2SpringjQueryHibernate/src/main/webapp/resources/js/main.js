var prot = window.location.protocol;
var host = window.location.host;

$(document).ready(function () {
    $('#l').click(function (event) {
        var u = $('#u').val();
        var p = $('#p').val();
        console.log("u: " + u + " p: " + p);
        $.ajax({
            url: prot + '//' + host + "/r/login",
            contentType: "application/json; charset=utf-8",
            type: "POST",
            dataType: 'json',
            data: JSON.stringify({'u': u, 'p': p}),
            delay: 250,
            statusCode: {
                200: function () {
                    console.log("200.");
                    window.location = prot + '//' + host + "/welcome.xhtml";
                },
                403: function (data) {
                    if ("undefined" !== typeof data) {
                        var obj = JSON.parse(data.responseText);
                        document.getElementById("er").innerHTML = obj.er;
                        console.log(obj.er);
                    }
                },
                404: function () {
                    console.log("404.");
                },
                415: function () {
                    console.log("415.");
                }
            },
            success: function (data) {
                if ("undefined" !== typeof data) {
                    var obj = data;
                    console.log(obj.s);
                    window.location = prot + '//' + host + "/welcome.xhtml";
                }
            },
            error: function (e) {
                console.log(e);
            },
            done: function () {
                console.log("done");
            }
        });
    });
});
