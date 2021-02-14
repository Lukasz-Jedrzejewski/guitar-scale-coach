document.addEventListener("DOMContentLoaded", function() {

    window.changeSelected = changeSelected;
    window.fillIn = fillIn;

    function changeSelected(selectObj) {
        var index = selectObj.selectedIndex;
        var val = selectObj.options[index].innerHTML;
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

        /**
        need to work on displaying, duplicating elements when changing input data.
        */

        createFretboard();
        createTuningFields();
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

    function createTuningFields() {
        var strVal = document.querySelector("#currentValue-str").innerHTML;
        var tune = document.querySelector("#tune");
        var ts = document.querySelector("#t-s")
        var label = document.createElement("label");
        label.innerHTML = "Choose your tuning";
        tune.appendChild(label);

        for (i = 1; i < parseInt(strVal)+1; i++) {
            var dot = document.createElement("div");
            dot.className = "dot";
            /*
            need to work with dot sizes
            */
            dot.style.width = i*3;
            dot.style.height = i*3;
            var clone = ts.cloneNode(true);
            clone.className = "t-select";
            clone.id = i;
            clone.style.display = "block";
            tune.appendChild(dot);
            tune.appendChild(clone);
        }
    }

    function readSounds() {
        var opts = document.querySelector("#t-s").options;
        var sounds = [];
        for (i = 0; i < opts.length; i++) {
            var item = opts[i].innerHTML;
            if (item.length <= 2) {
                sounds.push(item);
            }
        }
        return sounds;
    }

    function fillIn(selectObj) {
        console.log(s);

    }

    var s = readSounds();

});