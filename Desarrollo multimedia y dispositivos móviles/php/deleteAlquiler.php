<?php
    // Configuración de la base de datos
    $servername = "localhost";
    $username = "root";
    $password = "";
    $database = "videoclub_dcs";

    // Obtener el ID de la película y del usuario desde la solicitud
    $idPelicula = $_GET['idPelicula'];
    $idUsuario = $_GET['idUsuario'];

    // Abrir conexión a la base de datos
    $conn = new mysqli($servername, $username, $password, $database);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Error de conexión a la base de datos: " . $conn->connect_error);
    }

    
    $conn->begin_transaction();

    
    $sqlDeleteAlquiler = "DELETE FROM alquiler WHERE id_pelicula = $idPelicula AND id_usuario = $idUsuario";


    $sqlUpdatePelicula = "UPDATE pelicula SET disponible = 1 WHERE identificador = $idPelicula";

    if ($conn->query($sqlDeleteAlquiler) === TRUE) {
       
        if ($conn->query($sqlUpdatePelicula) === TRUE) {
           
            $conn->commit();
            echo json_encode(["mensaje" => "El alquiler correspondiente a la película con ID $idPelicula y al usuario con ID $idUsuario fue eliminado exitosamente. La película ahora está disponible."]);
        } else {
            
            $conn->rollback();
            echo json_encode(["mensaje" => "Error al actualizar la disponibilidad de la película: " . $conn->error]);
        }
    } else {
     
        $conn->rollback();
        echo json_encode(["mensaje" => "Error al eliminar el alquiler: " . $conn->error]);
    }

    // Cerrar conexión a la base de datos
    $conn->close();
?>