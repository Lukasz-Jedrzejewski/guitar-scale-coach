document.addEventListener("DOMContentLoaded", function() {

    window.changeSelected = changeSelected;
    window.fillIn = fillIn;
    window.test = test;
    window.hide = hide;
    window.executeSpider = executeSpider;

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

        try {
            var strVal = document.querySelector("#currentValue-str").innerHTML;
            var frVal = document.querySelector("#currentValue-fr").innerHTML;
            var tab = document.querySelector("tbody");
            if (strVal && frVal && tab) {
                tab.remove();
                createFretboard();
                createTuningFields();
            } else {
                createFretboard();
                createTuningFields();
            }
        } catch {
            console.log('At least one value is null')
        }
    }

    function createFretboard() {
    var frVal = document.querySelector("#currentValue-fr").innerHTML;
    var tab = document.querySelector(".table--");
    var tblBody = document.createElement("tbody");
    var tr = document.createElement("tr");
    tr.id = 0;
    var td = document.createElement("td");
    td.className = "fretboard-head";
    var td1 = document.createElement("td");
    td1.className = "fretboard-head";
    var cellTextChoose = document.createTextNode("choose your tuning");
    var cellTextString = document.createTextNode("String");
    td.style.border = "none";
    td1.style.borderRight = "9px solid silver";
    td.appendChild(cellTextChoose);
    tr.appendChild(td);
    td1.appendChild(cellTextString);
    tr.appendChild(td1);
    for (col = 1; col < parseInt(frVal)+1; col++) {
        var cell = document.createElement("td");
        cell.className = "fretboard-head";
        var cellText = document.createTextNode(col);
        cell.appendChild(cellText);
        tr.appendChild(cell);
        tblBody.appendChild(tr);
    }
    tab.appendChild(tblBody);
    }

    function createTuningFields() {
        var strVal = document.querySelector("#currentValue-str").innerHTML;
        var frVal = document.querySelector("#currentValue-fr").innerHTML;
        var tblBody = document.querySelector("tbody");
        var ts = document.querySelector("#t-s");

        for (i = 1; i < parseInt(strVal)+1; i++) {
            var dot = document.createElement("div");
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            var td1 = document.createElement("td");
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
            tr.id = i;
            td1.appendChild(clone);
            td1.style.border = "none";
            td.style.borderRight = "9px solid silver";
            tr.appendChild(td1);
            td.appendChild(dot);
            tr.appendChild(td);
            for (j = 0; j < frVal; j++) {
                var cell = document.createElement("td");
                    var cellText = document.createTextNode('?');
                    cell.appendChild(cellText);
                    tr.appendChild(cell);
                }
            tblBody.appendChild(tr);
        }
    }

    function readSounds() {
        try {
            var opts = document.querySelector("#t-s").options;
            var sounds = [];
                for (i = 0; i < opts.length; i++) {
                    var item = opts[i].innerHTML;
                    if (item.length <= 2) {
                        sounds.push(item);
                    }
                }
            return sounds;
        } catch {
            console.log("Element not exist.");
        }

    }

    try {
        var scalePart = document.getElementById('scale');
        scalePart.style.display = 'none';
    } catch {
        console.log("Element not exist.")
    }

    function scaleDefinitionVisibility () {
        var scalePart = document.getElementById('scale');
        var stringsDefinitions = checkStringsDefinition();
        if (stringsDefinitions) {
            scalePart.style.display = 'block';
        }
    }

    function fillIn(selectObj) {
        var selectedIndex = selectObj.selectedIndex;
        var selectedValue = selectObj.options[selectedIndex].innerHTML;
        var frVal = document.querySelector("#currentValue-fr").innerHTML;
        var strVal = document.querySelector("#currentValue-str").innerHTML;
        var tblBody = document.querySelector("tbody");
        var currentSelect = selectObj.id;
        var index = soundsTable.indexOf(selectedValue)+1;
        for (i = 0; i < tblBody.children.length; i++) {
            if (tblBody.children[i].id == currentSelect) {
                for (j = 0; j < frVal; j++) {
                tblBody.children[i].deleteCell(2);
                }
            }
        }
        for (j = 0; j < frVal; j++) {
            var cell = document.createElement("td");
            if (index >= soundsTable.length) {
                index = 0;
            }
            var cellText = document.createTextNode(soundsTable[index]);
            index++;
            cell.appendChild(cellText);
            selectObj.parentElement.parentElement.appendChild(cell);
            }
            scaleDefinitionVisibility();
        }

    function checkStringsDefinition () {
        var select = document.querySelectorAll('.t-select');
        var counter = 0;
        for (i = 0; i <select.length; i++) {
            var ind = select[i].selectedIndex;
            var val = select[i].options[ind].innerHTML;
            if (val != ' -- select the sound -- ') {
                counter++;
            }
        }
        return counter == select.length;
    }

    function validate() {
        try {
            var strVal = document.querySelector("#currentValue-str").innerHTML;
            var frVal = document.querySelector("#currentValue-fr").innerHTML;
            var definitions = checkStringsDefinition();
            if (definitions && strVal != 'undefined' && frVal != 'undefined') {
                return true;
            }
            return false;
        } catch {
            console.log('At least one value is null');
        }
    }

    function test(button) {
        var message = document.getElementById('valid-guitar');
        var res = validate();
        if (!res) {
            message.style.display = "inline";
        }
        return true;
    }

    function hide(button) {
        var message = document.getElementById('valid-guitar');
        message.style.display = "none";
    }

    var soundsTable = readSounds();

    function executeSpider() {
        var current;
        var tab = document.getElementById('spider-tab');
        var rows = tab.rows;
        for (let i = 1; i < rows.length-1; i++) {
            var cols = tab.rows[i].cells;
            for (let j = 2; j < cols.length; j++) {
                var current = tab.rows[i].cells[j];
                setInterval(() => {
                    current.style.background = "green";
                }, 1000);
            }
        }
    }

});