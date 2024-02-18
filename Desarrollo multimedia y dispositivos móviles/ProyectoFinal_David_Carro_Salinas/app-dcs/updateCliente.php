<?php
    // Configuración de la base de datos
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "videoclub_dcs";

    
    $idCliente = $_GET['idUsuario'];
    $nuevaContra = $_GET['nuevaContra'];

    // Abrir conexión a la base de datos
    $conn = new mysqli($servername, $username, $password, $database);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Error de conexión a la base de datos: " . $conn->connect_error);
    }

    // Consulta para actualizar la contraseña del cliente
    $sql = "UPDATE Usuario SET password = '$nuevaContra' WHERE identificador = $idCliente";

    if ($conn->query($sql) === TRUE) {
        echo "Contraseña actualizada correctamente";
    } else {
        echo "Error al actualizar la contraseña: " . $conn->error;
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>