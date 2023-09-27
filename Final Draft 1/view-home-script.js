
var rooms = document.getElementsByClassName("location");
var test = document.getElementById("location");


var roomsArr = Array.from(rooms);
console.log(...roomsArr);


roomsArr.forEach(updateLocation);

var colors = ["white", "red", "orange", "yellow", "blue", "indigo", "violet", "black"];
var images = document.getElementsByClassName("carousel-image");
var imageIndex = 0;
var imagesText = document.getElementsByClassName("carousel-text");

for(i = 0; i < images.length; i++){
    images[i].style.backgroundColor = colors[i];
}


showImage();
setInterval(showImage, 7000);


function showImage(){
    if(imageIndex > 0){
        images[imageIndex-1].style.opacity = "0";
        imagesText[imageIndex-1].style.opacity = "0";
    }
    if(imageIndex == images.length){
        imageIndex = 0;
    }    
    images[imageIndex].style.opacity = "1";
    imagesText[imageIndex].style.opacity = "1";
    imageIndex++;
}


function updateLocation(element){//make home layout hoverable
    
    element.addEventListener("mouseover", function(){
        test.innerHTML = element.href.baseVal.substring(1);
        
    });
    element.addEventListener("mouseout", function(){
        test.innerHTML = "Home Layout";
    });
}


