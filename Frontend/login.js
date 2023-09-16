const url = 'http://localhost:8038/user';

document.getElementById("login-form").addEventListener("submit", (e) => {
    e.preventDefault();

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var obj = {
        "username": username,
        "password": password
    }

    console.log(obj)
    loginUser(obj);

    document.getElementById("username").value = '';
    document.getElementById("password").value = '';
});

async function loginUser(obj){
    const registrationMessage = document.getElementById("registrationMessage");
    try {      
        const res = await fetch(`${url}/login`,{
            method: 'POST',
            body: JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
        });

        const res1 = await res.text();
        if(res.ok){
            alert(res1)
            console.log(res1)
            location.href = "homepage.html";
        }
        else{
            const responseJson = JSON.parse(res1);
            registrationMessage.textContent = responseJson.message;
        }

    } catch (error) {
        console.log(error);
    }
}