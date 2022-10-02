function iniciarSesion(formu) {
    formu.Event.prototype.preventDefault;
    consumirServicio();
}

function consumirServicio() {
    const nom = document.getElementById('usu').value;
    const cla = document.getElementById('cla').value;

    let objetoEnviar = {
        "correo": nom,
        "clave": cla
    }
    const urlAPI_iniciar = "http://localhost:8094/backiniciosesion/acceso/verificar";
    fetch(urlAPI_iniciar, {
        method: "POST",
        body: JSON.stringify(objetoEnviar),
        headers: { "Content-type": "application/json; charset=UTF-8" }
    })
        .then(respuesta => respuesta.json())
        .then(datos => {
            if (datos.status === "OK") {
                document.getElementById('frmInicioSesion').reset();
                document.getElementById("frmInicioSesion").classList.remove("was-validated");
                localStorage.setItem("UISmisionTIC", datos.token);
                location.href = "http://127.0.0.1:5501";// + datos.token;
                //window.open('http://localhost:8096/#jwt/' + datos.token, '_blank');
            } else {
                document.getElementById('frmInicioSesion').reset();
                document.getElementById("frmInicioSesion").classList.remove("was-validated");
                document.getElementById("msgResultado").style.display = "";
            }

        })
        .catch(miError => console.log(miError));
}