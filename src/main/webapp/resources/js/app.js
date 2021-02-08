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
    }


});