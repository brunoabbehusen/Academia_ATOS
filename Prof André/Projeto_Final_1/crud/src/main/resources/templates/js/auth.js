let credentials = sessionStorage.getItem("credentials")

if(credentials === null) {

    window.location.href = "login.html?authError=true"
    alert("Sessão expirada!");
}else{

    credentials = JSON.parse(sessionStorage.getItem("credentials"));
}