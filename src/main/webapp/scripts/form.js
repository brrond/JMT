// get all inputs (text & password)
// also get all hint boxes
let inpEmail = document.getElementById("inpEmail");
let divEmailHelp = document.getElementById("emailHelp");
let inpPass = document.getElementById("inpPass");
let divPassHelp = document.getElementById("passHelp");

// make all boxes "red"
inpEmail.setCustomValidity("Invalid field.");
inpPass.setCustomValidity("Invalid field.");

// add event listeners to manipulate styles
inpEmail.addEventListener("input", () => {
    if(inpEmail.value === "") {
        inpEmail.setCustomValidity("Invalid field.");
    } else {
        inpEmail.setCustomValidity("");
    }

    if(!inpEmail.validity.valid) {
        divEmailHelp.style.display = "block";
    } else {
        divEmailHelp.style.display = "none";
    }
});
inpPass.addEventListener("input", () => {
    if(inpPass.value === "") {
        inpPass.setCustomValidity("Invalid field.");
    } else {
        inpPass.setCustomValidity("");
    }

    if(!inpPass.validity.valid) {
        divPassHelp.style.display = "block";
    } else {
        divPassHelp.style.display = "none";
    }
});