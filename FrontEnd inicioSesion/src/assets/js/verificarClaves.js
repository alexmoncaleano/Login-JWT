function compararClaves() {
    const miClave = document.getElementById("cla");
    const confirmar = document.getElementById("recla");

    if (miClave.value !== "") {
        if (miClave.value != confirmar.value) {
            confirmar.setCustomValidity("Error");
        } else {
            confirmar.setCustomValidity("");
        }
    }
}
