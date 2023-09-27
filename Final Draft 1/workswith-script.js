console.log("hello");

var dropdownClickArea = document.getElementsByClassName("categories-title")[0];
var dropdownMenu = document.getElementsByClassName("dropdown-menu")[0];
var dropdownIcon = document.getElementById("dropdown-icon");
dropdownClickArea.addEventListener("click", dropDown);



var logos = document.getElementsByClassName("logos")[0].getElementsByClassName("child");
var dropdownItems = dropdownMenu.getElementsByTagName("li");


console.log(dropdownItems[0].innerHTML);
var dropdownItemsArr = Array.from(dropdownItems);
var logosArr = Array.from(logos);

dropdownItemsArr.forEach(clicker);



function clicker(dropdownItem){//drop down function for categories when the window is shrunk
    
    dropdownItem.addEventListener("click", function(){
        dropDown();
        console.log(dropdownItem);
        var itemID = dropdownItem.id;
        if (itemID != "all"){
            logosArr.forEach(logo => {
                if(logo.classList.contains(itemID)){
                    logo.style.display = "flex";
                } else logo.style.display = "none";
            });
        } else logosArr.forEach(logo => {
            logo.style.display = "flex";
        })
        
    })
    
}


function dropDown(){//drop down icon rotate
    
    dropdownMenu.classList.toggle("active");
    if(dropdownMenu.classList.contains("active")){
        dropdownIcon.style.transform = "rotate(180deg)";
    } else dropdownIcon.style.transform = "rotate(360deg)";
    
}