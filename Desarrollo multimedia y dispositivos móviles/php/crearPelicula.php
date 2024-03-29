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
	$rawData = file_get_contents("php://input");
	$data = json_decode($rawData, true);

	$titulo = $data['titulo'];
	$duracion = $data['duracion'];
	$anho = $data['anho'];
	$portada = $data['portada'];
	$director = $data['idDirector'];
	

	$sql = "INSERT INTO pelicula (titulo, duracion, anho, portada, director) VALUES ('$titulo', '$duracion', '$anho', '$portada', '$director')";

	if ($conn->query($sql) === TRUE) {
	    echo json_encode(["message" => "Pelicula insertado con éxito"]);
	} else {
	    echo json_encode(["error" => "Error al insertar el Pelicula: " . $conn->error]);
	}

	// Cerrar conexión a la base de datos
	$conn->close();
?>