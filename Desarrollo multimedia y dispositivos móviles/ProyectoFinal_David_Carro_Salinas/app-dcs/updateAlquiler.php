<?php
// Configuración de la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$database = "videoclub_dcs";

// Obtener los datos enviados por el cliente
$idAlquiler = $_GET['idAlquiler'];
$extendido = $_GET['extendido'];

// Establecer conexión con la base de datos
$conn = new mysqli($servername, $username, $password, $database);

// Verificar la conexión
if ($conn->connect_error) {
    die("Error de conexión a la base de datos: " . $conn->connect_error);
}

// Consulta SQL para actualizar el estado de extendido del alquiler
$sql = "UPDATE Alquiler SET extendido = '$extendido' WHERE identificador = $idAlquiler";

if ($conn->query($sql) === TRUE) {
    echo "Estado de extendido actualizado correctamente";
} else {
    echo "Error al actualizar el estado de extendido: " . $conn->error;
}

// Cerrar la conexión a la base de datos
$conn->close();
?>