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

  
    $sql = "SELECT pelicula.* FROM pelicula INNER JOIN alquiler ON pelicula.identificador = alquiler.id_pelicula WHERE alquiler.id_usuario = $idUsuario";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $peliculas = array();

        while ($row = $result->fetch_assoc()) {
            $duracion = (string)$row["duracion"];
            $pelicula = array(
                "identificador" => $row["identificador"],
                "titulo" => $row["titulo"],
                "duracion" => $duracion,
                "anho" => $row["anho"],
                "portada" => $row["portada"],
                "idDirector" => $row["director"],
                "disponible" => $row["disponible"] == 1 ? true : false
            );

            $peliculas[] = $pelicula;
        }

        echo json_encode($peliculas);
    } else {
        echo json_encode(["mensaje" => "No se encontraron películas para este usuario"]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>
