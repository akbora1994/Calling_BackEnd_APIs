const url = 'http://localhost:8038/user';

document.getElementById("signup-form").addEventListener("submit", (event) => {
    event.preventDefault();

    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var obj = {
        "username": username,
        "email": email,
        "password": password
    }

    console.log(obj)
    registerUser(obj);

    document.getElementById("username").value = '';
    document.getElementById("email").value = '';
    document.getElementById("password").value = '';
});

async function registerUser(obj){
    const registrationMessage = document.getElementById("registrationMessage");
    try {      
        const res = await fetch(`${url}/register`,{
            method: 'POST',
            body: JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
        });

        const res1 = await res.text();
        if(res.ok){
            alert(res1)
            window.location.href = "login.html";
        }
        else{
            //alert("Something went wrong!")
            const responseJson = JSON.parse(res1);
            registrationMessage.textContent = responseJson.message;
        }

    } catch (error) {
        alert(error);
        registrationMessage.textContent = "Registration failed. Please try again later.";
    }
}