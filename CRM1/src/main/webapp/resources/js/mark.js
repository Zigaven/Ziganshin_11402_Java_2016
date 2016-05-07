function addMark(comics){
    $.ajax({
        url:"/client/mark",
        method:"POST",
        data: {
            comics: comics
        },
        success:function(resp){
            $('#markResult').text("Votes are:" + resp);
            $('#addButton').hide();
        }
    })
}

$(document).ready(function (comics) {
    $.ajax({
        url:"/client/check/mark",
        method:"POST",
        data: {
            comics: comics
        },
        success:function(resp){
            console.log(resp);

            if (resp[0] == true){
                $('#addButton').hide();
            }

            if (comics == "dc"){
                $('#markDc').text("Votes are:" + resp[1]);
            } else {
                $('#markMarvel').text("Votes are:" + resp[1]);
            }

        }
    })
});