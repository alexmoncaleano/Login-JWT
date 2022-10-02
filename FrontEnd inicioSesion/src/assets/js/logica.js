function logicaNegocio(url, param) {
    switch (url) {
        case 'src/componentes/registro.html':
            cambiarLogoInicio(1, 12);
            document.getElementsByName("validarRegistro")[0].onclick = compararClaves;
            break;
        case 'src/componentes/inicio.html':
            cambiarLogoInicio(1, 12);
            break;

        default:
            console.log('Doesn\'t require custom Javascript');
    }
}


