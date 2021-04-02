<div class="speed-params">
    <input id="tempo" defaultValue="60" type="number" value="60" min="60" max="240" oninput="validateTempo()">
    <span class="validity"></span>
    <select id="meter" oninput="checkMeter()">
        <option value="1">1/4</option>
        <option value="2">2/4</option>
        <option value="3">3/4</option>
        <option value="4">4/4</option>
    </select>
</div>
