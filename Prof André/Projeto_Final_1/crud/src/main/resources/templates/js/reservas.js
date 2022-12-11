const listaDeReservasEL = document.querySelector('#listaDeReservas');

function getReservas(){


    let username = 'user';
    let password = 'passwd';


    fetch('http://localhost:8008/reservas',{
        headers:{
            'Authorization': `Basic ${btoa(username + ":" + password)}`,
        },
        //credentials: 'include',
        method: 'GET',
        //mode: 'cors'
    }).then((response) => {
        return response.json();
    }).then((data) => {
        console.log(data);
    });
}

getReservas();