let correct = document.getElementById("correct");
let incorrect = document.getElementById("incorrect");
const solution = document.getElementById("solution");
const checkMark = document.getElementById("right"),
xMark = document.getElementById("wrong");
let a = 0;
let b = 0;
start();

console.log(checkMark);

function start(){
    document.getElementById("leftNum").innerHTML = Math.floor(Math.random() * 10);
    document.getElementById("rightNum").innerHTML = Math.floor(Math.random() * 100);
    let symbols = ["+", "-", "*"];
    document.getElementById("symbol").innerHTML = symbols[Math.floor(Math.random() * symbols.length)];
}
function submit(){
    let leftNum = document.getElementById("leftNum").innerHTML;
    let rightNum = document.getElementById("rightNum").innerHTML;
    let symbol = document.getElementById("symbol").innerHTML;

    let answer = eval(leftNum+""+symbol+""+rightNum);
    if (answer == solution.value){
        a++;
        correct.innerHTML = a;
        checkMark.style.display = "block";
        let animation = setTimeout(() => {
            checkMark.style.display = "none";
        }, 500);
        

    }else {
        b++;
        incorrect.innerHTML = b;
        correct.innerHTML = a;
        xMark.style.display = "block";
        let animation = setTimeout(() => {
            xMark.style.display = "none";
        }, 500);
    }
    solution.value = "";
    start();
    
    
}
function reset(){
    a = 0;
    b = 0;
    correct.innerHTML = a;
    incorrect.innerHTML = b;
}

solution.addEventListener("keydown", function(event){
    if(event.key == "Enter"){
        submit();
    }
});