let value;
    caller();

    
function caller(){
    let date = new Date();
    let display = document.getElementById("clock");
    display.innerHTML = update();
    function update (){
        let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        let day = days[date.getDay()];
        let hour = date.getHours();
        let minute = date.getMinutes();
        let seconds = date.getSeconds();
        let tag;
        if(hour < 12){
            tag = "AM";
        } else tag = "PM"
        hour %= 12;
        if(hour == 0){
            hour = 12;
        }
        hour = setZeroes(hour);
        minute = setZeroes(minute);
        seconds = setZeroes(seconds);
        return day + "  " + hour + ":" + minute + ":" + seconds + " " + tag;
    
    }
    function setZeroes(time){
        if (time < 10) {
            time = "0" + time;
        }
        return time;
    }
    setInterval(caller, 1000);
}


