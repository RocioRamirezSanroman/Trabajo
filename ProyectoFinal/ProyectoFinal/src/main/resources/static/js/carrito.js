function inicializarCarrito() {
    const precioUnitarioUvas = parseFloat(
        document.querySelector('.precio-unitario').textContent
            .replace(' €', '')
            .replace(',', '.')
    );
    
    const inputCantidad = document.querySelector('.input-cantidad');
    const btnMinus = document.querySelector('.btn-minus');
    const btnPlus = document.querySelector('.btn-plus');
    const precioTotalElement = document.querySelector('.precio-total');
    
    function actualizarPrecioTotal() {
        const cantidad = parseInt(inputCantidad.value) || 0;
        const precioTotal = cantidad * precioUnitarioUvas;
        precioTotalElement.textContent = precioTotal.toFixed(2).replace('.', ',') + ' €';
    }

    // Función para manejar el clic en "+"
    function handlePlusClick() {
        let cantidad = parseInt(inputCantidad.value) || 0;
        inputCantidad.value = cantidad + 1;
        actualizarPrecioTotal();
    }

    // Función para manejar el clic en "-"
    function handleMinusClick() {
        let cantidad = parseInt(inputCantidad.value) || 0;
        if (cantidad > 1) {
            inputCantidad.value = cantidad - 1;
            actualizarPrecioTotal();
        }
    }

    // Remueve listeners antiguos (por si acaso) y asigna nuevos
    btnPlus.removeEventListener('click', handlePlusClick);
    btnMinus.removeEventListener('click', handleMinusClick);
    btnPlus.addEventListener('click', handlePlusClick);
    btnMinus.addEventListener('click', handleMinusClick);
    
    inputCantidad.addEventListener('change', actualizarPrecioTotal);
    actualizarPrecioTotal();
}

document.addEventListener('DOMContentLoaded', inicializarCarrito);