var cTemp;
var fTemp;

document.getElementById("celciusInput").oninput = function(){
    cTemp = document.getElementById("celciusInput");
    fTemp = document.getElementById("farenInput");
    fTemp.value = (cTemp.value * 9/5) + 32;
    
     
}
document.getElementById("farenInput").oninput = function(){
    cTemp = document.getElementById("celciusInput");
    fTemp = document.getElementById("farenInput");
    cTemp.value = (fTemp.value - 32) * 5/9
}