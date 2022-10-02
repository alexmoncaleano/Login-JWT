'use strict';

(function () {
    function init() {
        var router = new Router([
            new Route('login', 'inicio.html', true),
            new Route('adduser', 'registro.html')
        ]);
    }
    init();
}());
