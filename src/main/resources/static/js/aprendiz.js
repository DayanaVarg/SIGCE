function convertirMayusculas() {
    var nombreInput = document.getElementById("nombre_Apr");
    var apellidoInput = document.getElementById("apellido_Apr");
    var nombreInput1 = document.getElementById("nombre_Ins");
    var apellidoInput1 = document.getElementById("apellido_Ins");
    
    nombreInput.value = nombreInput.value.toUpperCase();
    apellidoInput.value = apellidoInput.value.toUpperCase();

     
    nombreInput1.value = nombreInput.value.toUpperCase();
    apellidoInput1.value = apellidoInput.value.toUpperCase();
}

function comprobarInactivar() {
    // Mensaje de confirmación
    var mensaje = "¿Está seguro que desea inactivar al aprendiz?";
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
    var mensaje = "¿Está seguro que desea activar al aprendiz?";
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
    var mensaje = "¿Está seguro que desea actualizar al aprendiz?";
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