"use strict";
var formElementet;
var inputfield;

//user can only login with these names.
let usernames = ["yazeen", "ec", "softhouse"];

//Function that calls all other functions in order
//--Don't modify--
function init() {
  initLoginForm();
  initLabel();
  initInput();
  initButton();
}


function initLoginForm() {
  //Add code here to:
  //create and add form element to the Dom.
  
  formElementet = document.createElement("form");
  document.body.appendChild(formElementet);
  
}

function initLabel() {
  //Add code here to:
  //create label element and set the lable to "username" (TIP: use .textContent).
  //Add it to the form element. (TIP: use .appendChild).
  let usernameLabel = document.createElement("label");
  usernameLabel.textContent = "Username";
  document.getElementsByTagName("form")[0].appendChild(usernameLabel);
  
}
  

function initInput() {
  //Add code here to:
  //create input element and set it to be requried (TIP: use .required = true).
  //Add it to the form element. (TIP: use .appendChild).
  inputfield = document.createElement("input");
  document.getElementsByTagName("form")[0].appendChild(inputfield);
  document.getElementsByTagName("input")[0].required = true;


}

function initButton() {
  //create button element and set the text to "login" (TIP: use .textContent)
  ////Add it to the form element. (TIP: use .appendChild).

  //Add click eventListener for button and call validateLoginInfo function inside it.
  //if validateLoginInfo is true alert user with "Welcome" text.
  //if validateLoginInfo is false add border style to the input element: "3px solid red". (TIP: use .style.border).
  let buttonX = document.createElement("button");
  buttonX.textContent = "Login";
  document.getElementsByTagName("form")[0].appendChild(buttonX);
 
  buttonX.addEventListener("click", function(){
      if(validateLoginInfo()){
          alert("Welcome!");      
      } else {
       inputfield.style.border = "3px solid red";
      }
    }   
  );

}

function validateLoginInfo() {
  //Get the input using form input element (TIP: use .value)
  //if the username is in the usernames array return true if not return false.
  
  for (let i = 0; i < usernames.length; i++) {
        if ( inputfield.value == usernames[i]){                    
           return true;
           break;
        }      
    }
}





//Write code here to call the init function only after the dom has been loaded (TIP: check "DOMContentLoaded" event)



window.addEventListener('DOMContentLoaded', (event) => {
  init();
});



