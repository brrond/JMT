// get all inputs (text & password)
// also get all hint boxes
let inpUsername = document.getElementById("inpUsername");

inpUsername.setCustomValidity("Invalid field.");

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