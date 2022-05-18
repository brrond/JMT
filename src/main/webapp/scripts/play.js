

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
    userAnswers.push(userInp === answers[currDiv]);
    nextDiv();
}

function start() {
    initCurr();
    sw = new Stopwatch();
    sw.start(100);
}

function end() {
    sw.stop();
    let elapsed = sw.getElapsed() / 1000;

    // show all divs
    let exp = 0.0;
    for (let i = 0; i < divs.length; i++) {
        let div = divs[i];
        let inp = div.getElementsByTagName("input")[0];
        div.style.display = 'block';
        inp.removeEventListener("change", onChange);
        if(!userAnswers[i]) {
            inp.setCustomValidity("False");
        } else {
            exp += experience[i];
        }
    }

    divRes.innerHTML = "<br>Elapsed time : " + elapsed + "sec<br>";
    if(exp >= experienceToNextLevel) {
        divRes.innerHTML += "<p>New level!</p>";
    }
    divRes.innerHTML += "<a href='save_session?time=" + elapsed + "&exp=" + exp + "'>Done</a>";
    divRes.style.display = "block";
}

let divs = document.getElementsByClassName("divTest");
let inp = null;
let currDiv = 0;
let sw = null;
let divRes = document.getElementById("divRes");