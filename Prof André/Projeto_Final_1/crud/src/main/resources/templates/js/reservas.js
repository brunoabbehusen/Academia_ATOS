const listaDeReservasEL = document.querySelector('#listaDeReservas');
let Reservas = [];
let ReservaIdSelecionado;

document.querySelector('#btn-checkout').addEventListener('click', checkout);


function getReservas(){

    fetch('http://localhost:8008/reservas',{
        headers:{
            'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
        },
        method: 'GET',
    }).then((response) => {
        return response.json();
    }).then((data) => {
        setReservas(data);
    });
}

function setReservas(reservas){

    reservas.sort(function(before,next){
        return before.reserva.id - next.reserva.id;
    });

    Reservas = reservas;

    reservas.forEach(reserva => {

        const html = `
            <tr onclick="selectReserva(${reserva.reserva.id})">
                <th scope="row">${reserva.reserva.id}</th>
                <td>${reserva.reserva.hospede.nome_Completo}</td>
                <td>${reserva.reserva.hospede.veiculo == null? "Sem veiculo":reserva.reserva.hospede.veiculo.placa}</td>
                <td>${reserva.cama_id == null? "Sem cama":reserva.cama_id}</td>
            </tr>
        `;

        listaDeReservasEL.insertAdjacentHTML('beforeend', html);
    })
}

function selectReserva(reservaId){

    const numeroCamaEL = document.querySelector("#inputCama");
    const valorCamaEL = document.querySelector("#inputValorDaCama");
    const valorTotalEL = document.querySelector("#inputTotal");
    const nomeCompletoEL = document.querySelector("#inputNomeCompleto");
    const placaEL = document.querySelector("#inputPlaca");

    const reserva = Reservas.find(reserva => reserva.reserva.id == reservaId);
    ReservaIdSelecionado = reservaId;
    const itensConsumidos = reserva.reserva.itens_consumidos;
    
    setItensConsumidos(itensConsumidos);
    
    numeroCamaEL.value = reserva.cama_id;
    valorCamaEL.value = reserva.reserva.valor_reserva;
    valorTotalEL.value = reserva.reserva.valor_total;
    nomeCompletoEL.value = reserva.reserva.hospede.nome_Completo;
    placaEL.value = reserva.reserva.hospede.veiculo.placa;
}

function setItensConsumidos(itensConsumidos){

    const itensConsumidosEL = document.querySelector("#itensConsumidos");

    itensConsumidosEL.innerHTML = "";

    itensConsumidos.forEach(itemConsumido => {
        const html = `
            <li class="row g-3">
                <div class="col-4">
                    <label class="form-label" for="itemConsumido">Item consumido</label>
                    <input class="form-control" type="text" value="${itemConsumido.item.nome}" readonly>
                </div>
            <div class="col-4">
                <label class="form-label" for="valorUnitario">Valor Unitário</label>
                    <div class="input-group">
                        <span class="input-group-text">R$</span>
                        <input type="text" class="form-control" value="${itemConsumido.item.valor}" readonly>
                    </div>
            </div>
            <div class="col-4">
                <label class="form-label" for="quantidadeConsumida">Quantidade Consumida</label>
                <input type="number" class="form-control" value="${itemConsumido.quantidade}" readonly>
            </div>
        </li>
        `;

        itensConsumidosEL.insertAdjacentHTML('beforeend', html);
    });
}

function checkout(){

    fetch(`http://localhost:8008/reservas/checkout/${ReservaIdSelecionado}`, {
        headers:{
            'Authorization': `Basic ${btoa(credentials.username + ":" + credentials.password)}`,
        },
        method: 'PATCH',
    }).then(data => {
        window.location.href = window.location.href;
    });
}

getReservas();