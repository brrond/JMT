function initCurr() {
    divs[currDiv].style.display = "block";
    inp = divs[currDiv].getElementsByTagName("input")[0];
    inp.addEventListener("change", onChange);
}

function nextDiv() {
    inp.removeEventListener("change", onChange);
    divs[currDiv].style.display = "none";
    currDiv++;
    if(currDiv === 10) {
        end();
        return;
    }
    initCurr();
}

function onChange() {
    let userInp = parseInt(this.value);
    //console.log(userInp);
    if(userInp === answers[currDiv]) {
        nextDiv();
    }
}

function start() {
    initCurr();
    sw = new Stopwatch();
    sw.start(100);
}

function end() {
    sw.stop();
    let elapsed = sw.getElapsed() / 1000;
    divRes.innerHTML = "Test successful. Elapsed time : " + elapsed + "sec";
    divRes.style.display = "block";
}

let divs = document.getElementsByClassName("divTest");
let inp = null;
let currDiv = 0;
let sw = null;
let divRes = document.getElementById("divRes");