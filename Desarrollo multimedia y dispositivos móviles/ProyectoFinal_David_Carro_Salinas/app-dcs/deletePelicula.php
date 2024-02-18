<?php
    // Configuración de la base de datos
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "videoclub_dcs";

    // Obtener el ID de la película a eliminar desde la solicitud
    $idPelicula = $_GET['idPelicula'];

    // Abrir conexión a la base de datos
    $conn = new mysqli($servername, $username, $password, $database);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Error de conexión a la base de datos: " . $conn->connect_error);
    }

    // Consulta SQL para eliminar la película
    $sql = "DELETE FROM pelicula WHERE identificador = $idPelicula";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["mensaje" => "La película con ID $idPelicula fue eliminada exitosamente"]);
    } else {
        echo json_encode(["mensaje" => "Error al eliminar la película: " . $conn->error]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>