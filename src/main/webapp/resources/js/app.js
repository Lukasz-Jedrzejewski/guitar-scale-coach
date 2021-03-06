document.addEventListener("DOMContentLoaded", function() {

    window.changeSelected = changeSelected;
    window.fillIn = fillIn;
    window.test = test;
    window.hide = hide;
    window.executeSpider = executeSpider;
    window.validateTempo = validateTempo;
    window.checkMeter = checkMeter;
    window.plusSlides = plusSlides;
    window.executeBackwardSpider =executeBackwardSpider;
    window.showPopup = showPopup;

    function changeSelected(selectObj) {
        var index = selectObj.selectedIndex;
        var val = selectObj.options[index].innerHTML;
        var p = document.createElement("p");
        p.id = "currentValue-"+selectObj.id;
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
            scalePart.style.display = 'flex';
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

    var string = 1;
    var fret = 2;
    var counter = 0;
    var position = 2;
    var direction = true;
    var id = 0;

    function validateTempo() {
        var tempo = document.getElementById('tempo').value;
        var spiderBtn = document.querySelector('#spider-btn');
        if(tempo < 60 || tempo > 240) {
            spiderBtn.style.display = "none";
        } else {
            spiderBtn.style.display = "inline";
        }
    }

    function checkMeter() {
        var meter = document.getElementById('meter').value;
        return meter;
    }

    function executeSpider() {
        resetVariables(6,2,0,2,false);
        var tempo = document.getElementById('tempo').value;
        var meter = checkMeter();
        stopInterval();
        id = setInterval(runSpider, (60000/tempo)/meter);
    }

    function runSpider() {
        var tab = document.getElementById('spider-tab');
        var rows = tab.rows;
        var cols = tab.rows[string].cells;
        var current = tab.rows[string].cells[fret];
        if (direction) {
        current.classList.add('highlight');
        setTimeout(() => {
            current.classList.remove('highlight');
        }, 100)
        fret++;
        counter++;
        if (counter == 4) {
            string++;
            fret = position;
            counter = 0;
            }
        if (string == rows.length-1) {
            position += 1;
            counter = 0;
            fret = position;
            string--;
            direction = false;
            }
        } else {
        current.classList.add('highlight');
        setTimeout(() => {
            current.classList.remove('highlight');
        }, 100)
        counter++;
        fret++;
        if (counter == 4) {
            string--;
            fret = position;
            counter = 0;
            }
        if (string == 0) {
            position += 1;
            counter = 0;
            fret = position;
            string++;
            direction = true;
            }
        }
        if (position == 23) {
            stopInterval();
            executeSpider();
            }
        }

        function stopInterval() {
            clearInterval(id);
        }

        function resetVariables(s, f, c, p, direct) {
            string = s;
            fret = f;
            counter = c;
            position = p;
            direction = direct;
        }

    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
      showSlides(slideIndex += n);
    }

    function currentSlide(n) {
      showSlides(slideIndex = n);
    }

    function showSlides(n) {
      var i;
      var slides = document.getElementsByClassName("single-ex");
      if (n > slides.length) {slideIndex = 1}
      if (n < 1) {slideIndex = slides.length}
      for (i = 0; i < slides.length; i++) {
          slides[i].style.display = "none";
      }
      slides[slideIndex-1].style.display = "block";
    }

    function executeBackwardSpider() {
        resetVariables(6,25,0,25,false);
        var tempo = document.getElementById('tempo').value;
        var meter = checkMeter();
        stopInterval();
        id = setInterval(runBackwardSpider, (60000/tempo)/meter);
    }

    function runBackwardSpider() {
        var tab = document.getElementById('spider-tab');
        var rows = tab.rows;
        var cols = tab.rows[string].cells;
        var current = tab.rows[string].cells[fret];
        if (!direction) {
        current.classList.add('highlight');
        setTimeout(() => {
            current.classList.remove('highlight');
        }, 100)
        fret--;
        counter++;
        if (counter == 4) {
            string--;
            fret = position;
            counter = 0;
        } if (string == 0) {
            position -= 1;
            counter = 0;
            fret = position;
            string++;
            direction = true;
            }
        } else {
        current.classList.add('highlight');
        setTimeout(() => {
            current.classList.remove('highlight');
        }, 100)
        fret--;
        counter++;
        if (counter == 4) {
            string++;
            fret = position;
            counter = 0;
        }
        if (string == rows.length-1) {
            position -= 1;
            counter = 0;
            fret = position;
            string--;
            direction = false;
        }
        }
        if (position == 4) {
            stopInterval();
            executeBackwardSpider();
        }
    }

    var cursorX;
    var cursorY;
    document.onmousemove = function(e){
        cursorX = e.pageX;
        cursorY = e.pageY;
    }

    function checkId(element) {
        return element.id;
    }

    var text;

    function setPopupText(element) {
        switch (checkId(element)) {
            case "switch":
                text = "switch exercise";
                break;
            case "ex-name":
                text = "exercise name";
                break;
            case "spider-btn":
                text = "run exercise";
                break;
            case "tempo":
                text = "setting tempo";
                break;
            case "meter":
                text = "setting meter";
                break;
            case "tune-head":
                text = "string tuning information";
                break;
            case "str-head":
                text = "string thickness information";
                break;
            case "fr-head":
                text = "information about the fret number";
                break;
            case "tune-sound":
                text = "tuning of a given string";
                break;
            case "dot":
                text = "thickness of a given string";
                break;
            case "sound":
                text = "sound at the given fret";
                break;
            case "single-dot":
                text = "marking a particular fret, like on your guitar";
                break;
            case "double-dot":
                text = "marking a particular fret (12 and 24), like on your guitar";
                break;
            default:
                text = "default information";
        }
    }

    function showPopup(select) {
        setPopupText(select);
        var span = document.createElement('span');
        span.className = "popupText";
        span.style.position = "absolute";
        span.style.left = cursorX+20;
        span.style.top = cursorY-50;
        span.innerHTML = text;
        if (checkAddress()) {
            document.body.appendChild(span);
        }
        select.onmouseleave = function(){
            span.remove();
        }
    }

    function checkAddress() {
        if(window.location.href == "http://localhost:8080/instructions/general-instructions") {
            return true;
        }
        return false;
    }
});