document.addEventListener('DOMContentLoaded', function() {
    // Función para actualizar todos los precios
    function updateAllPrices() {
        let subtotal = 0;
        
        // Seleccionar todas las filas de productos
        document.querySelectorAll('tbody tr').forEach(row => {
            const quantityInput = row.querySelector('.quantity input');
            const priceText = row.querySelector('td:nth-child(3) p').textContent;
            const totalCell = row.querySelector('td:nth-child(5) p') || row.nextElementSibling.querySelector('td p');
            
            if (quantityInput && priceText && totalCell) {
                const quantity = parseInt(quantityInput.value) || 0;
                const unitPrice = parseFloat(priceText.replace(' €', '').replace(',', '.'));
                const productTotal = quantity * unitPrice;
                
                // Actualizar el total del producto
                totalCell.textContent = productTotal.toFixed(2).replace('.', ',') + ' €';
                subtotal += productTotal;
            }
        });
        
        // Actualizar el subtotal
        const subtotalElement = document.querySelector('.bg-light .d-flex.justify-content-between.mb-4 p');
        if (subtotalElement) {
            subtotalElement.textContent = subtotal.toFixed(2).replace('.', ',') + ' €';
        }
        
        // Calcular el total (subtotal + envío)
        const shipping = 3.00; // Tarifa fija de envío
        const total = subtotal + shipping;
        
        // Actualizar el total
        const totalElement = document.querySelector('.py-4.mb-4.border-top.border-bottom p');
        if (totalElement) {
            totalElement.textContent = total.toFixed(2).replace('.', ',') + ' €';
        }
		
		localStorage.setItem('cartTotal', total.toFixed(2));
    }
    
    // Configurar event listeners para todos los inputs de cantidad
    function setupQuantityInputs() {
        document.querySelectorAll('.quantity input').forEach(input => {
            const btnMinus = input.parentElement.querySelector('.btn-minus');
            const btnPlus = input.parentElement.querySelector('.btn-plus');
            
            if (btnMinus) {
                btnMinus.addEventListener('click', function() {
                    setTimeout(updateAllPrices, 10);
                });
            }
            
            if (btnPlus) {
                btnPlus.addEventListener('click', function() {
                    setTimeout(updateAllPrices, 10);
                });
            }
            
            input.addEventListener('change', updateAllPrices);
        });
    }
    
    // Inicializar
    setupQuantityInputs();
    updateAllPrices();
});