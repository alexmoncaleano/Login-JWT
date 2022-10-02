(() => {
    'use strict'
    const forms = document.querySelectorAll('.validarFormulario')

    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        }, false)
    })
})();