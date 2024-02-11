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
    $email = $data['email'];
    $password = $data['password'];
    $rol = $data['rol'];

    $sql = "INSERT INTO usuario VALUES ('$nombre', '$email', '$password', '$rol')";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["message" => "Usuario insertado con éxito"]);
    } else {
        echo json_encode(["error" => "Error al insertar el usuario: " . $conn->error]);
    }

    $conn->close();
?>