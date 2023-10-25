const signUpEndpoint = "http://localhost:3000/user/sign_up";
const signInEndpoint = "http://localhost:3000/user/sign_in";

document.querySelector('#submitButton').addEventListener('click', () => {creatNewUser()});

function creatNewUser(){

    fetch(signUpEndpoint, {
        method: "POST",
        headers: {'content-type': 'application/json;charset=utf-8'},
        body: JSON.stringify({
            user_name: document.getElementById("userNameInput").value,
            password: document.getElementById("passwordInput").value
        }),
        mode: "cors"
    });
    }