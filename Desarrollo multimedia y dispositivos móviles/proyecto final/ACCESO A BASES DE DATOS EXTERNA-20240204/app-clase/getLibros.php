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
	$sql = "SELECT * FROM libros";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
	    $libros = array();

	    while ($row = $result->fetch_assoc()) {
	        $libro = array(
	            "id" => $row["id"],
	            "titulo" => $row["titulo"],
	            "autor" => $row["autor"]
	        );

	        $libros[] = $libro;
	    }

	    echo json_encode($libros);
	} else {
	    echo json_encode(["mensaje" => "No se encontraron libros"]);
	}


	// Cerrar conexión a la base de datos
	$conn->close();
?>