document.getElementById('button').addEventListener('click',
    function() {
        document.querySelector('.Container-modal').style.display = 'flex';
    });

document.querySelector('.closeB').addEventListener('click',
    function() {
        document.querySelector('.Container-modal').style.display = 'none';
    });


    function comprobarInactivar() {
        // Mensaje de confirmación
        var mensaje = "¿Está seguro que desea inactivar la ficha?";
        var eleccion = confirm(mensaje);
    
        // Verificar la elección del usuario
        if (eleccion) {
            alert("Se inactivó correctamente.");
            return true;
        } else {
            return false; 
        }
    }
    
    function comprobarActivar() {
        // Mensaje de confirmación
        var mensaje = "¿Está seguro que desea activar la ficha?";
        var eleccion = confirm(mensaje);
    
        // Verificar la elección del usuario
        if (eleccion) {
            alert("Se activó correctamente.");
            return true;
        } else {
            return false; 
        }
    }
    
    function comprobarActualizar() {
    
        // Mensaje de confirmación
        var mensaje = "¿Está seguro que desea actualizar la ficha?";
        var eleccion = confirm(mensaje);
    
        if (eleccion) {
            alert("Se actualizó correctamente.");
            return true;
        } else {
            location.reload(); 
            alert("Operación cancelada.");
            return false;  
        }
    }