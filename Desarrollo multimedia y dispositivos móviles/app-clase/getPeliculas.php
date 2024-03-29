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
	$sql = "SELECT * FROM pelicula";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
		$peliculas = array();

	while ($row = $result->fetch_assoc()) {
		$pelicula = array(
			"identificador" => $row["identificador"],
			"titulo" => $row["titulo"],
			"duracion" => $row["duracion"],
			"anho" => $row["anho"],
			"portada" => $row["portada"],
			"idDirector" => $row["idDirector"],
			if ( $row["disponible"] === 1){
				$disp = true;
			} else {
				$disp = false;
			}
			"disponible" => $disp
		);


		$peliculas[] = $pelicula;
	}

	echo json_encode($peliculas);
	} else {
	echo json_encode(["mensaje" => "No se encontraron películas"]);
	}

	// Cerrar conexión a la base de datos
	$conn->close();
?>