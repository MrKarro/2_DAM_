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

   
    $id_pelicula = $data['id_pelicula'];
    $id_usuario = $data['id_usuario'];
    $fecha_alquiler = $data['fecha_alquiler'];
    $fecha_devolucion = $data['fecha_devolucion'];
    
    

    $sql = "INSERT INTO alquiler (id_pelicula, id_usuario, fecha_alquiler, fecha_devolucion ) VALUES ('$id_pelicula', '$id_usuario', '$fecha_alquiler', '$fecha_devolucion')";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["message" => "Alquiler insertado con éxito"]);
    } else {
        echo json_encode(["error" => "Error al insertar el alquiler: " . $conn->error]);
    }

    $conn->close();
?>