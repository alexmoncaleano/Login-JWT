function generarAleatorio(minimo, maximo) {
    min = Math.ceil(minimo);
    max = Math.floor(maximo);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function cambiarLogoInicio(inicio, fin) {
    document.getElementById("fotoAcceso").src = "src/assets/images/eye" + generarAleatorio(inicio, fin) + ".png";
}
