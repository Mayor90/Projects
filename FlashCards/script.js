 console.log("TESTER");
 const createBox = document.getElementsByClassName('create-box')[0];
 const question = document.getElementById('question');
 const answer = document.getElementById('answer');
 const flashcards = document.getElementsByClassName('flashcards')[0];


 function hideCreateBox(){
    createBox.style.display = "none";
 }
 function showCreateCardBox(){
    createBox.style.display = "block";
 }
 function delFlashcards(){
    flashcards.innerHTML = "";
 }
 function addFlashcard(){
    var flashcard = document.createElement("div");
    flashcard.className = 'flashcard';

    var h2_answer = document.createElement("h2");
    var h2_question = document.createElement("h2");

    h2_question.setAttribute('style',"border-top: 1px solid red; padding: 15px; margin-top: 30px");
    h2_answer.setAttribute('style', "text-align: center; display: none; color: red;");

    h2_question.innerHTML = question.value;
    h2_answer.innerHTML = answer.value;
   console.log(answer.value);
    
    flashcard.appendChild(h2_question);
    flashcard.appendChild(h2_answer);

    flashcard.addEventListener("click", function(){
        if(h2_answer.style.display == "none"){
            h2_answer.style.display = "block";
        } else  h2_answer.style.display = "none";
    })

    flashcards.appendChild(flashcard);
    question.value = '';
    answer.value = '';

 }