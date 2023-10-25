const signInEndpoint = "http://localhost:3000/user/sign_in";
let accessToken = 0;

document.querySelector('#submitButton2').addEventListener('click', () => {signIn()});

async function signIn(){

    sessionStorage.setItem('userName', document.getElementById("userNameInput").value);

    let response = await fetch(signInEndpoint, {
        method: "POST",
        headers: {'content-type': 'application/json;charset=utf-8'},
        body: JSON.stringify({
            user_name: document.getElementById("userNameInput").value,
            password: document.getElementById("passwordInput").value
        }),
        mode: "cors"
    })

    if (response.ok){
        
        accessToken = await response.json();
        accessToken = accessToken.token;
        console.log(accessToken);
        sessionStorage.setItem('accessToken', accessToken);

        document.querySelector('#submitButton2').innerHTML="signed in! Click here to proceed";
        document.querySelector('#toKeyboard').setAttribute("href", "index.html");
    }
}
