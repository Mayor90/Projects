let display = document.getElementById("display");
let expression = '';
//display.innerHTML = expression;
let checker = 0;

function press(value){
  
    if(checker == 1){
         if(value != '-' && value != '+' && value != '*' && value != '/') expression = '';
    }
   
    checker = 0;
    if(expression == '0' && value == 0) expression = '0'
    else expression += value;
    display.value = expression;
}
function equal(){
    
    expression = eval(expression);
    display.value = expression;
    checker = 1;
}
function erase(){
    
    expression = '';
    display.value = expression;
    checker = 0;
    
}
function del(){
    expression = expression.substring(0, expression.length-1);
    if(expression == '')expression = '0';
    display.value = expression;
}
console.log(typeof(expression));