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
    $dni = $data['dni'];
    $login = $data['login'];
    $password = $data['password'];
    $trabajador = $data['trabajador'];
    if ($trabajador === true){
        $trab = 1;
    } else {
        $trab = 0;
    }
        
    

    $sql = "INSERT INTO usuario (nombre, dni, login, password, trabajador) VALUES ('$nombre', '$dni', '$login', '$password', $trab)";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["message" => "Usuario insertado con éxito"]);
    } else {
        echo json_encode(["error" => "Error al insertar el usuario: " . $conn->error]);
    }

    $conn->close();
?>