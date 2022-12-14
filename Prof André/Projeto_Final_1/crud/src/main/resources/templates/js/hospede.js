let listaHospedes = [];

document.querySelector("#idForm").addEventListener("submit",function(event){
    event.preventDefault();

    const nomeCompleto = document.querySelector("#IdNomeCompleto").value;
    const placa = document.querySelector("#IdPlaca").value;

    fetch("http://localhost:8008/hospedes", {
        method: "POST",
        headers: {
            'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({nomeCompleto, placa})
    }).catch(error => {
        alert(error);
    }).then(data => {
        document.querySelector("#IdNomeCompleto").value = "";
        document.querySelector("#IdPlaca").value = "";
        alert("Hospede criado com sucesso!");
        getHospedes();
    }).catch(error => {
        alert(error);
    });
});

getHospedes();

function getHospedes(){

    fetch("http://localhost:8008/hospedes", {
        method: "GET",
        headers: {
            'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
        },
    }).catch(error => {
        alert(error);
    }).then((response) => {
        return response.json();
    }).catch(error => {
        alert(error);
    }).then((data) => {
        setHospedes(data);
    });
}

function setHospedes(hospedes){

    const listaDeHospedesEL = document.querySelector("#listaDeHospedes");
    listaDeHospedesEL.innerHTML = "";

    hospedes.sort(function(before,next){
        return before.id - next.id;
    });

    listaHospedes = hospedes;

    hospedes.forEach(hospede => {

        const html = `
            <tr>
                <th scope="row" data-hospede-id="${hospede.id}">${hospede.id}</th>
                <td>${hospede.nome_Completo}</td>
                <td>${hospede.veiculo == null? "sem veiculo": hospede.veiculo.placa}</td>
                <td class="d-flex gap-3">
                    <button class="btn btn-primary rounded" onclick="setEditarHospede(${hospede.id})">
                        <i class="fa-regular fa-pen-to-square fa-sm"></i>
                    </button>
                    <button class="btn btn-danger rounded" onclick="deleteHospede(${hospede.id})">
                        <i class="fa-solid fa-trash fa-sm"></i>
                    </button>
                </td>
            </tr>
        `;

        listaDeHospedesEL.insertAdjacentHTML('beforeend', html);
    })
}

function deleteHospede(hospedeId){

    fetch(`http://localhost:8008/hospedes/${hospedeId}`, {
        method: "DELETE",
        headers: {
            'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
        },
    }).catch(error => {
        alert(error);
    }).then(data => {
        alert("Hospede deletado com sucesso!");
        getHospedes();
    });
}

function setEditarHospede(hospedeId){

    const hospede = listaHospedes.find(hospede => hospede.id == hospedeId);

    const linha = document.querySelector(`#listaDeHospedes th[data-hospede-id="${hospede.id}"]`).parentElement;

    const html = `
        <tr>
            <th data-hospede-id="${hospede.id}" scope="row">${hospede.id}</th>
            <td>
                <input name='nome_completo' type="text" value="${hospede.nome_Completo}" class="form-control">
            </td>
            <td>
                <input name='placa' type="text" value="${hospede.veiculo == null? '' : hospede.veiculo.placa}" class="form-control">
            </td>
            <td class='d-flex gap-3'>
                <button class="btn btn-success rounded" onclick="editarHospede(${hospede.id})">
                    <i class="fa-regular fa-pen-to-square fa-sm"></i>
                </button>
                <button class="btn btn-danger rounded" onclick="deleteHospede(${hospede.id})">
                    <i class="fa-solid fa-trash fa-sm"></i>
                </button>
            </td>
        </tr>
    `;

    linha.innerHTML = '';

    linha.insertAdjacentHTML('beforeend', html);
}

async function editarHospede(hospedeId){
    
    const hospede = listaHospedes.find(hospede => hospede.id == hospedeId);
    
    const linha = document.querySelector(`#listaDeHospedes th[data-hospede-id="${hospede.id}"]`).parentElement;

    const nomeCompleto = linha.querySelector('input[name="nome_completo"]').value;
    const placa = linha.querySelector('input[name="placa"]').value;

    try {
        await fetch(`http://localhost:8008/hospedes/${hospede.id}`,{
            method: 'PUT',
            headers: {
                'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
                "Content-Type": "application/json"
            },
            body: JSON.stringify({nomeCompleto, placa})
        });
        getHospedes();
        alert('Hóspede alterado com sucesso!');
    } catch (error) {
        alert('Erro ao editar hóspede');
    }
}