const toDOItems = document.getElementsByClassName("to-do-items")[0];
const input = document.getElementById("input");


input.addEventListener("keydown", function(event){
    if(event.key == "Enter"){
        addItem();
    }
})

function addItem(){
    var divParent = document.createElement("div");
    var divChild = document.createElement("div");
    var checkIcon = document.createElement("i");
    var trashIcon = document.createElement("i");


    divParent.className = "item";
    divParent.innerHTML =  '<div>' + input.value + '</div>';

    checkIcon.className = "fas fa-check-square";
    checkIcon.style.color = "lightgray"
    checkIcon.addEventListener("click", function(){
        if (checkIcon.style.color == "lightgray") checkIcon.style.color = "green"
        else checkIcon.style.color = "lightgray"
    })

    divChild.appendChild(checkIcon);

    trashIcon.className = "fas fa-trash";
    trashIcon.style.color = "darkgray";
    trashIcon.addEventListener("click", function(){
        divParent.remove();
    })

    divChild.appendChild(trashIcon);

    divParent.appendChild(divChild);

    toDOItems.appendChild(divParent);

    input.value = '';
}