document.addEventListener("DOMContentLoaded", function() {

    window.changeSelected = changeSelected;

    function changeSelected(selectObj) {
        var index = selectObj.selectedIndex;
        var val = selectObj.options[index].value;
        var p = document.createElement("p");
        p.id = "currentValue-"+selectObj.id;
        /*
        id for strings - currentValue-str
        id for frets - currentValue-fr
        */
        p.innerHTML = val;
        var cur = document.getElementById(p.id);
        if(!cur) {
            selectObj.parentElement.appendChild(p);
        } else {
            cur.innerHTML = val;
        }
        p.style.display = "none";
        createFretboard();
    }

    function createFretboard() {
    var strVal = document.querySelector("#currentValue-str").innerHTML;
    var frVal = document.querySelector("#currentValue-fr").innerHTML;
    var tab = document.querySelector(".table--");
    var row;
    var col;
    var tblBody = document.createElement("tbody");
    for (row = 0; row < parseInt(strVal)+1; row++) {
        var tr = document.createElement("tr");
        for (col = 1; col < parseInt(frVal)+1; col++) {
            var cell = document.createElement("td");
            if (row != 0) {
                var cellText = document.createTextNode("r " + row + ", c " + col);
            } else {
                var cellText = document.createTextNode(col);
            }
            cell.appendChild(cellText);
            tr.appendChild(cell);
        }
        tblBody.appendChild(tr);
    }
    tab.appendChild(tblBody);
    }

});