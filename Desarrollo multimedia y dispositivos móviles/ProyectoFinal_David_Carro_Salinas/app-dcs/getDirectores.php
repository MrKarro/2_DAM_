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

    // Consulta directores
    $sql = "SELECT * FROM director";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $directores = array();

    while ($row = $result->fetch_assoc()) {
        $director = array(
            "identificador" => $row["identificador"],
            "nombre" => $row["nombre"],
            "fecha_nacimiento" => $row["fecha_nacimiento"]
        );

    $directores[] = $director;
    }

    echo json_encode($directores);
    } else {
        echo json_encode(["mensaje" => "No se encontraron directores"]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>