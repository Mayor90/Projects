const amount  = document.getElementById('amount');
const guests  = document.getElementById('guest');
const quality = document.getElementById('quality');
const tipAmount  = document.getElementById('tip-amount');


function calculate(){
    
    var tip = ((amount.value * quality.value)/(guests.value)).toFixed(2);
    amount.value = '';
    guests.value = '';
    quality.value = '';

    if(tip === 'NaN'){
        tipAmount.innerHTML = 'Each field must contain a value';
    } else {
        tipAmount.innerHTML = 'Tip $'+tip+' each';
    }
    
    showTipAmount();
}

function showTipAmount(){
 
    var x = tipAmount;
    x.className = 'show';
    setTimeout(function(){x.className = x.className.replace('show', '');}, 3000);
    
}
