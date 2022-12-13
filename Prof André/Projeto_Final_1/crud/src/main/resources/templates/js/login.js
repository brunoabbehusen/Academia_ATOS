
const searchParams = new URLSearchParams(window.location.search);

if(searchParams.get("authError")){
    alert("Sessão expirada!");
}

document.querySelector("#idForm").addEventListener("submit", async function(event){
    event.preventDefault();

    const username = document.querySelector("#InputUsuario").value;
    const password = document.querySelector("#InputSenha").value;
    
    try{
        const credentials = JSON.stringify({username, password})
        const response = await fetch("http://localhost:8008/login", {
            method: "POST",
            headers: {
                //"Accept": "application/json",
                "Content-Type": "application/json",
            },
            body: credentials,
        })
        if (response.status === 200) {
            window.location.href = "home.html";   
            sessionStorage.setItem("credentials", credentials);
        } else{
            const alertText = await response.text();
            alert(alertText);
        }
    } catch(error){
        alert(error);
    }
});