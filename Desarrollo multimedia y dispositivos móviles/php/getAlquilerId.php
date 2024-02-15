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

    $idUsuario = $_GET['idUsuario'];

  
    $sql = "SELECT alquiler.*, pelicula.titulo AS titulo_pelicula 
            FROM alquiler 
            INNER JOIN pelicula ON alquiler.id_pelicula = pelicula.identificador 
            WHERE alquiler.id_usuario = $idUsuario";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $alquileres = array();

        while ($row = $result->fetch_assoc()) {
            $alquiler = array(
                "id_alquiler" => $row["id_alquiler"],
                "id_usuario" => $row["id_usuario"],
                "id_pelicula" => $row["id_pelicula"],
                "fecha_alquiler" => $row["fecha_alquiler"],
                "titulo_pelicula" => $row["titulo_pelicula"],
                // Agrega otros campos según tu estructura de tabla alquiler
            );

            $alquileres[] = $alquiler;
        }

        echo json_encode($alquileres);
    } else {
        echo json_encode(["mensaje" => "No se encontraron películas para este usuario"]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>
