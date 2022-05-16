// get all inputs (text & password)
// also get all hint boxes
let inpEmail = document.getElementById("inpEmail");
let divEmailHelp = document.getElementById("emailHelp");
let inpPass = document.getElementById("inpPass");
let divPassHelp = document.getElementById("passHelp");
let inpUsername = document.getElementById("inpUsername");

// make all boxes "red"
inpEmail.setCustomValidity("Invalid field.");
inpPass.setCustomValidity("Invalid field.");
inpUsername.setCustomValidity("Invalid field.");

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
inpUsername.addEventListener("input", () => {
    if(inpUsername.value === "") {
        inpUsername.setCustomValidity("Invalid field.");
    } else {
        inpUsername.setCustomValidity("");
    }
});

// get image input elements
let inpBtnSelect = document.getElementById("inpBtnPhoto");
let inpPhoto = document.getElementById("inpPhoto");
let divPhotoHelp = document.getElementById("photoHelp")

// set "wrong" input
inpBtnSelect.style.border = "10px solid red";
inpPhoto.addEventListener("change", () => {
    // if there is only one file
    // and size of the file less than 1Mb
    if(inpPhoto.files.length === 1 && inpPhoto.files[0].size <= 1024 * 1024) {
        inpBtnSelect.style.border = "5px solid rgb(255, 255, 0)";
        divPhotoHelp.style.display = "none";
    }
    else {
        inpBtnSelect.style.border = "10px solid red";
        divPhotoHelp.style.display = "block";
    }
});