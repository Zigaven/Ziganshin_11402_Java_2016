function getComics(pub){
    $.ajax({
        url:"/client",
        method:"GET",
        data:{"pub":pub},
        dataType: 'json',
        contentType:'application/json',
        mimeType:'apllication/json',
        success:function(resp){
            if(resp.length > 0){
                $("#res").text("");
                console.log(resp);
                console.log("!!!!");
                for (var i = 0;i < resp.length;i++){
                    $("#res").append("<div class='row widget'>" +
                    "<div class='col-xs-12' id='com_pub'>" +
                        "<h4><b>"+resp[i].publisher+"</b></h4>" +
                        "</div>" +
                        "</div>" +
                        "<div class='row widget'>" +
                        "<div class='col-xs-12' id='com_info'>" +
                        "<h4>Name:</h4>" +
                    "<h3><b>" + resp[i].name + "</b></h3>" +
                    "<p><img src=" + 'resp[i].path' + "alt=''></p>" +
                        "<p> <h4>Price:</h4><p>" +
                    "<h3><b>" +  resp[i].price + "</b></h3></p>" +
                    "<p><h4>Description:</h4><p>" +
                    "<h3><b>" + resp[i].description + "</b></h3></p></div>" +
                    "<a class='btn btn-action btn-lg' role='button'>Order</a></p></div>")
                }
            }
        }
    })
}