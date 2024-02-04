<?php
	// Configuración de la base de datos
	$servername = "localhost";
	$username = "root";
	$password = "";
	$database = "ejlibros";

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
	$autor = $data['autor'];

	$sql = "INSERT INTO libros (titulo, autor) VALUES ('$titulo', '$autor')";

	if ($conn->query($sql) === TRUE) {
	    echo json_encode(["message" => "Libro insertado con éxito"]);
	} else {
	    echo json_encode(["error" => "Error al insertar el libro: " . $conn->error]);
	}

	// Cerrar conexión a la base de datos
	$conn->close();
?>