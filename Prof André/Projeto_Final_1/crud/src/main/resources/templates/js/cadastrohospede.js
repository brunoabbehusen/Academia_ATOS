document.querySelector("#idForm").addEventListener("submit",function(event){
    event.preventDefault();

    const nomeCompleto = document.querySelector("#IdNomeCompleto").value;
    const placa = document.querySelector("#IdPlaca").value;

    fetch("http://localhost:8008/hospedes", {
        method: "POST",
        headers: {
            //"Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({nomeCompleto, placa})
    }).catch(error => {
        alert(error);
    });
});