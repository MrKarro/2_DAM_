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

    // Consulta usuarios
    $sql = "SELECT * FROM usuario";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $usuarios = array();

    while ($row = $result->fetch_assoc()) {
        $usuario = array(
            "identificador" => $row["identificador"],
            "dni" => $row["dni"],
            "nombre" => $row["nombre"],
            "login" => $row["login"],
            "password" => $row["password"],
            if ( $row["trabajador"] === 1){
				$trab = true;
			} else {
				$trab = false;
			}
            "trabajador" => $trab,
            if ( $row["bloqueado"] === 1){
				$bloq = true;
			} else {
				$bloq = false;
			}
            "bloqueado" => $bloq
        );

    $usuarios[] = $usuario;
    }

        echo json_encode($usuarios);
    } else {
        echo json_encode(["mensaje" => "No se encontraron usuarios"]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>