
var miniBar = document.getElementById("mini-bar");
var menu = document.getElementsByClassName("menu");
var navBarContent = document.getElementsByClassName("navbar-content")[0];
var menuBarContent = navBarContent.cloneNode(true);
menuBarContent.className = " menu-bar";
miniBar.appendChild(menuBarContent);


menu[0].addEventListener("click", dropDown);

function dropDown(){
    miniBar.classList.toggle("active");
}



