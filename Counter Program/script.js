let a = document.getElementById("myLabel");
let count = 0;

document.getElementById("incBtn").onclick = function(){
    a.innerHTML = ++count;
}
document.getElementById("decBtn").onclick = function(){
    a.innerHTML = --count;
}
document.getElementById("resBtn").onclick = function(){
    a.innerHTML = 0;
    count = 0;
}