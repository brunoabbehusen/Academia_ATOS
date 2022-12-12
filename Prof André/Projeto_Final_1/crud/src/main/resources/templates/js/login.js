document.querySelector("#idForm").addEventListener("submit",function(event){
    event.preventDefault();

    const username = document.querySelector("#InputUsuario").value;
    const password = document.querySelector("#InputSenha").value;

    fetch("http://localhost:8008/login", {
        method: "POST",
        headers: {
            //"Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({username, password}),
    }).catch(error => {
        alert(error);
    });
});