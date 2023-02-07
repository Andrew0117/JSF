var jld = '{"jsonLocale":[{"en":"English","elements":[{"morning":"Good morning","day":"Good day","evening":"Good evening","night":"Good night"}]},{"ru":"Russian","elements":[{"morning":"Доброе утро","day":"Добрый день","evening":"Добрый вечер","night":"Доброй ночи"}]}]}';
var jl = JSON.parse(jld);
var d = new Date();

function curTime() {
    var hour = d.getHours();
    if (hour >= 6 && hour < 9)
        return 0;
    if (hour >= 9 && hour < 19)
        return 1;
    if (hour >= 19 && hour < 23)
        return 2;
    if (hour >= 23 && hour < 6)
        return 3;
};

$(document).ready(function () {
    var cb = "";
    var curValue = document.getElementById("text").innerHTML;
    if (navigator.language.indexOf("ru") >= 0) {
        var l = jl.jsonLocale[1];
        if (curTime() === 0) {
            cb = '<p>' + l.elements[0].morning + ", " + curValue + '.</p>';
        }
        if (curTime() === 1) {
            cb = '<p>' + l.elements[0].day + ", " + curValue + '.</p>';
        }
        if (curTime() === 2) {
            cb = '<p>' + l.elements[0].evening + ", " + curValue + '.</p>';
        }
        if (curTime() === 3) {
            cb = '<p>' + l.elements[0].night + ", " + curValue + '.</p>';
        }
    } else {
        var l = jl.jsonLocale[0];
        if (curTime() === 0) {
            cb = '<p>' + l.elements[0].morning + ", " + curValue + '.</p>';
        }
        if (curTime() === 1) {
            cb = '<p>' + l.elements[0].day + ", " + curValue + '.</p>';
        }
        if (curTime() === 2) {
            cb = '<p>' + l.elements[0].evening + ", " + curValue + '.</p>';
        }
        if (curTime() === 3) {
            cb = '<p>' + l.elements[0].night + ", " + curValue + '.</p>';
        }
    };
    document.getElementById("text").innerHTML = cb;
});
