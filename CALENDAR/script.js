let audio = new Audio("Audio/chime.mp3");
const daysTag = document.querySelector(".days"),
currentDate = document.querySelector(".current-date"),
prevNextIcon = document.querySelectorAll(".icons span");
let liTag = "";
let dates;
// getting new date, current year and month
let date = new Date(),
currYear = date.getFullYear(),
currMonth = date.getMonth();
let chime = true;
// storing full name of all months in array
const months = ["January", "February", "March", "April", "May", "June", "July",
              "August", "September", "October", "November", "December"];

const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(), // getting first day of month
    lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(), // getting last date of month
    lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(), // getting last day of month
    lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // getting last date of previous month
    liTag = "";

    for (let i = firstDayofMonth; i > 0; i--) { // creating li of previous month last days
        liTag += `<li class="inactive day">${lastDateofLastMonth - i + 1}</li>`;
    }

    for (let i = 1; i <= lastDateofMonth; i++) { // creating li of all days of current month
        // adding active class to li if the current day, month, and year matched
       
        let isToday = i === date.getDate() && currMonth === new Date().getMonth() 
                     && currYear === new Date().getFullYear() ? "active day" : "day";
        liTag += `<li class="${isToday}">${i}</li>`;
    }

    for (let i = lastDayofMonth; i < 6; i++) { // creating li of next month first days
        liTag += `<li class="inactive day">${i - lastDayofMonth + 1}</li>`
    }
    currentDate.innerText = `${months[currMonth]} ${currYear}`; // passing current mon and yr as currentDate text
    daysTag.innerHTML = liTag;

    dates = document.querySelectorAll(".day");
    
    dates.forEach(element => {
        element.addEventListener("click", function(){
           //This is where you add the functions to change the history fact for that particular day
           //console.log(element);
        })
    })
    
}

renderCalendar();

prevNextIcon.forEach(icon => { // getting prev and next icons
    icon.addEventListener("click", () => { // adding click event on both icons
        // if clicked icon is previous icon then decrement current month by 1 else increment it by 1
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;
        
        if(currMonth < 0) currYear -= 1;
        if(currMonth > 11)currYear += 1;
        if(currMonth > 11){
            currMonth = 0;
        }
        if (currMonth < 0){
            currMonth = 11;
        }
       
       

        /*
        if(currMonth < 0 || currMonth > 11) { // if current month is less than 0 or greater than 11
            // creating a new date of current year & month and pass it as date value
            date = new Date(currYear, currMonth, new Date().getDate());
            currYear = date.getFullYear(); // updating current year with new date year
            currMonth = date.getMonth(); // updating current month with new date month
        } else {
            date = new Date(); // pass the current date as date value
        }
        */
        renderCalendar(); // calling renderCalendar function
    });
});

//Go to today's date on the calendar
function goToCurrentDate(){
    currMonth = date.getMonth();
    currYear = date.getFullYear();
    renderCalendar();
}
//Control settings module
const settings = document.getElementsByClassName("settings")[0];
const settingsContainer = document.getElementsByClassName("settings--container")[0];
const settingsIcon = document.getElementById("settings-icon");
const expandOrCollapseIcon = document.getElementById("expand-or-collapse-icon");

settings.addEventListener("click", ()=>{
    settingsContainer.classList.toggle("drop");
    console.log(settingsContainer);
    if(expandOrCollapseIcon.innerHTML === "expand_more"){
        expandOrCollapseIcon.innerHTML = "expand_less";
        settingsIcon.style.rotate = "90deg";
    }
    else{
        expandOrCollapseIcon.innerHTML = "expand_more";
        settingsIcon.style.rotate = "-90deg";
    } 
});

//click on the chime icon to toggle it on or off
const chimeDesc = document.getElementById("chime-desc");
const chimeContainer = document.getElementsByClassName("chime--icon")[0];
const chimeIcon = document.getElementById("chime");
chimeContainer.onclick = () =>{
    if(chimeIcon.innerHTML === "notifications_active"){
        chimeIcon.innerHTML = "notifications_off";
        chimeDesc.innerHTML = "Chime off";
        chime = false;
        audio.pause();
        audio.currentTime = 0;
    }
    else{
        chimeIcon.innerHTML = "notifications_active";
        chimeDesc.innerHTML = "Chime on";
        chime = true;
    } 
}

//add a month list to navigate between the months of the current year
let monthList = document.getElementsByClassName("months")[0].querySelectorAll("div"),
    monthContainer = document.getElementsByClassName("months")[0];

    
monthList.forEach((month) => {
    month.addEventListener("click", function(){
        // monthContainer.style.display = "none";
        monthContainer.style.transform = "scale(1.5)";
        monthContainer.style.opacity = "0";
       monthContainer.style.visibility = "hidden";
       
        currMonth = months.indexOf(month.innerHTML);
        renderCalendar();
    })
})
currentDate.addEventListener("click", function(){
    //monthContainer.style.display = "grid";
    monthContainer.style.transform = "scale(1.0)";
    monthContainer.style.opacity = "1";
    monthContainer.style.visibility = "visible";

})




//play chime every hour


function upDate(){
    
    // currYear = date.getFullYear(),
    // currMonth = date.getMonth();
    // renderCalendar();

    goToCurrentDate();
    if(chime){
        audio.play();
        
    }
    
    
}

const runEveryFullHours = (callBackFunction) => {
    const Hour = 60 * 60 * 1000;
    const tsecs = 5000;
    const firstCall =  Hour - (date.getMinutes() * 60 + date.getSeconds()) * 1000 - date.getMilliseconds();
    setTimeout(() => {
      callBackFunction();
      setInterval(callBackFunction, Hour);
    }, firstCall);
};
runEveryFullHours(upDate);


//add a clock to the calendar
let element = document.getElementById("demo");
let hoursContainer = document.getElementById("hours"),
minutesContainer = document.getElementById("minutes"),
secondsContainer = document.getElementById("seconds"),
amorpmContainer = document.getElementById("amorpm");


updateClock();    
    function updateClock(){
        let amorpm;
        let hours = date.getHours(); 
        if(hours < 12){
            amorpm = "AM";
        } else amorpm = "PM"
        hours %= 12;
        if(hours == 0){
            hours = 12;
        }
        console.log(hours);
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        let string = setZeroes(hours) + " : " + setZeroes(minutes) + " " + amorpm;
        element.innerHTML = string;
        
    }
    function setZeroes(time){
        if (time < 10) {
            time = "0" + time;
        }
        return time;
    }
   



setInterval(function() {
    
    let date = new Date();
    let amorpm;
    let hours = date.getHours(); 
    if(hours < 12){
        amorpm = "AM";
    } else amorpm = "PM"
    hours %= 12;
    if(hours == 0){
        hours = 12;
    }
    
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    let string = setZeroes(hours) + " : " + setZeroes(minutes) + " " + amorpm;
    element.innerHTML = string;

}, 1000);
