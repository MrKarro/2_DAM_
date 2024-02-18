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
    $sql = "SELECT alquiler.*, pelicula.titulo AS titulo_pelicula, usuario.nombre AS nombre_usuario 
    FROM alquiler 
    INNER JOIN pelicula ON alquiler.id_pelicula = pelicula.identificador 
    INNER JOIN usuario ON alquiler.id_usuario = usuario.identificador";
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
            "titulo_pelicula" => $row["titulo_pelicula"],
            "nombre_usuario" => $row["nombre_usuario"],
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