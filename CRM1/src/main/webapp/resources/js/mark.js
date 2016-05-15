function addMarvel() {
    $.ajax({
        url: "/client/mark/marvel",
        method: "POST",
        success: function (resp) {
            console.log("resp" + " " + resp);
            $('#markMarvel').text("Votes are:" + resp);
            $('#addButton').hide();
        }
    })
}

function addDc() {
    $.ajax({
        url: "/client/mark/dc",
        method: "POST",
        success: function (resp) {
            console.log("resp" + " " + resp);
            $('#markDc').text("Votes are:" + resp);
            $('#addButton').hide();
        }
    })
}

$(document).ready(function (comics) {
    $.ajax({
        url: "/client/check/mark/marvel",
        method: "POST",
        data: {
            comics: comics
        },
        success: function (resp) {
            console.log("check" + resp);

            if (resp[0] == true) {
                $('#addButton').hide();
            }

            ('#markMarvel').text("Votes are:" + resp[1]);
        }
    })
});

$(document).ready(function (comics) {
    $.ajax({
        url: "/client/check/mark/dc",
        method: "POST",
        success: function (resp) {
            console.log("check" + resp);

            if (resp[0] == true) {
                $('#addButton').hide();
            }

            $('#markDc').text("Votes are:" + resp[1]);

        }
    })
});