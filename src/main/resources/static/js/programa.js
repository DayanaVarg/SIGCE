document.getElementById('button').addEventListener('click',
    function() {
        document.querySelector('.bg-modal').style.display = 'flex';
    });

document.querySelector('.close').addEventListener('click',
    function() {
        document.querySelector('.bg-modal').style.display = 'none';
    });


    function comprobarInactivar() {
        // Mensaje de confirmación
        var mensaje = "¿Está seguro que desea inactivar el programa?";
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
        var mensaje = "¿Está seguro que desea activar el programa?";
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
        var mensaje = "¿Está seguro que desea actualizar el programa?";
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