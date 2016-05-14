function addMark(pub){
    $.ajax({
        url:"/client",
        method:"GET",
        data: {
            pub: pub
        },
        success:function(resp){
            $('#markResult').text("Votes are:" + resp);
            $('#addButton').hide();
        }
    })
}

$(document).ready(function (comics) {
    $.ajax({
        url:"/client",
        method:"GET",
        data: {
            comics: comics
        },
        success:function(resp){
            console.log(resp);

            if (resp[0] == true){
                $('#addButton').hide();
            }

            if (pub == "dc"){
                $('#markDc').text("Votes are:" + resp[1]);
            } else {
                $('#markMarvel').text("Votes are:" + resp[1]);
            }

        }
    })
});