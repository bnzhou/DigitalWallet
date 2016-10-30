
$(document)
    .ready(function () {

        getInfo();

    });

var req;
var req2;


function getInfo() {
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
        req2 = new XMLHttpRequest();
    } else {
        req = new ActiveXObject("Microsoft.XMLHTTP");
        req2 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.onreadystatechange = handleResponseCard;

    req.open("GET", "http://localhost:8081/cardGetByUser?username=user1",true);
    req.send();

    req2.onreadystatechange = handleResponseAddr;
    req2.open("GET", "http://localhost:8081/addressGetByUser?username=user1",true);
    req2.send();
}

function handleResponseCard() {
    if (req.readyState != 4 || req.status != 200) {
        return ;
    }
    var content = document.getElementById("cards");
    var ret = req.responseText.split("\n");
    var string = "";
    for(var i = 0;i < ret.length - 1;i++) {
        var part = ret[i].split(",");
        if(part.length > 2) {
            var type = part[0].split("=")[1];
            var num = part[1].split("=")[1];
            string = string + "<option value =" + num + ">" + type + ":" + num + "</option>";
        }
    }
    content.innerHTML = string;
}

function handleResponseAddr() {
    if (req2.readyState != 4 || req2.status != 200) {
        return ;
    }
    var content = document.getElementById("addrs");
    var ret = req2.responseText.split("\n");
    var string = "";
    for(var i = 0;i < ret.length - 1;i++) {
        var part = ret[i].split(",");
        if(part.length > 2) {
            var id = part[0].split("=")[1];
            var addr = part[2].split("=")[1];
            string = string + "<option value =" + id + ">" + id + ":" + addr + "</option>";
        }
    }
    content.innerHTML = string;
}