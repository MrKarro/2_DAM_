<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "videoclub_dcs";

    $conn = new mysqli($servername, $username, $password, $database);

    if ($conn->connect_error) {
        die("Error de conexión a la base de datos: " . $conn->connect_error);
    }

    $rawData = file_get_contents("php://input");
    $data = json_decode($rawData, true);

    $nombre = $data['nombre'];
    $fecha_nacimiento = $data['fecha_nacimiento'];

    $sql = "INSERT INTO director VALUES ('$nombre', '$fecha_nacimiento')";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["message" => "Director insertado con éxito"]);
    } else {
        echo json_encode(["error" => "Error al insertar el director: " . $conn->error]);
    }

    $conn->close();
?>
