<?php
    // Configuración de la base de datos
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "videoclub_dcs";

    // Abrir conexión a la base de datos
    $conn = new mysqli($servername, $username, $password, $database);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Error de conexión a la base de datos: " . $conn->connect_error);
    }

    // Consulta
    $sql = "SELECT * FROM alquiler";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $alquilers = array();

    while ($row = $result->fetch_assoc()) {
        $fecha_alquiler = (string)$row["fecha_alquiler"];
        $fecha_devolucion = (string)$row["fecha_devolucion"];
        $alquiler = array(
            "identificador" => $row["identificador"],
            "id_pelicula" => $row["id_pelicula"],
            "id_usuario" => $row["id_usuario"],
            "fecha_alquiler" => $fecha_alquiler,
            "fecha_devolucion" => $fecha_devolucion,
            "extendido" => $row["extendido"] == 1 ? true : false
            
        );

    $alquilers[] = $alquiler;
    }

        echo json_encode($alquilers);
    } else {
        echo json_encode(["mensaje" => "No se encontraron alquilers"]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>