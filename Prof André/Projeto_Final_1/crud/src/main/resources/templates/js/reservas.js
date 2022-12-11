const listaDeReservasEL = document.querySelector('#listaDeReservas');

function getReservas(){


    let username = 'user';
    let password = 'passwd';

    let headers = new Headers();

    headers.append('Authorization', 'Basic ' + btoa(username + ":" + password));

    

    fetch('http://localhost:8008/reservas',{
        headers:{
            'Authorization': `Basic ${btoa(username + ":" + password)}`
        },
        credentials: 'include',
        method: 'GET',
        mode: 'no-cors'
    }).then((response) => {
        response.text().then((data)=>{
            console.log(data);
        })
    });
}

getReservas();