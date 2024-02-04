<?php
	// Configuración de la base de datos
	$servername = "localhost";
	$username = "root";
	$password = ""; //En mi caso no tengo contraseña
	$database = "ejlibros";

	// Abrir conexión a la base de datos
	$conn = new mysqli($servername, $username, $password, $database);

	// Verificar conexión
	if ($conn->connect_error) {
	    die("Error de conexión a la base de datos: " . $conn->connect_error);
	}

	// Consulta
	$idLibro = $_GET["id"];

	$sql = "SELECT * FROM libros where id = $idLibro";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
	    $row = $result->fetch_assoc();

	    $libro = array(
	        "id" => $row["id"],
	        "titulo" => $row["titulo"],
	        "autor" => $row["autor"]
	    );

	    echo json_encode($libro);
	} else {
	    echo json_encode(["mensaje" => "No se encontraron libros"]);
	}


	// Cerrar conexión a la base de datos
	$conn->close();
?>