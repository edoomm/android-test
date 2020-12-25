<?php
    include './database.php';
    $conn = open_database();

    // retrieving info
    $no_empleado = $_POST['noEmpleado'];
    $nombre = $_POST['nombre'];

    // checking if there isn't same value on other records
    $select_qry = "SELECT * FROM Empleado WHERE numero_empleado = $no_empleado";
    $result = mysqli_query($conn, $select_qry);

    if (!$result) {
        mysqli_close($conn);
        $respAx = "Error al tratar de obtener datos de la base de datos";
        echo $respAx;
        return;
    }
    if (mysqli_num_rows($result) != 0) {
        mysqli_close($conn);
        $respAx = "Ya existe un empleado con número $no_empleado";
        echo $respAx;
        return;
    }

    $insert_qry = "INSERT INTO Empleado VALUE ('$no_empleado', '$nombre')";

    if (mysqli_query($conn, $insert_qry))
        $respAx = "Empleado registrado correctamente";
    else
        $respAx = "Error al registrar al empleado";

    mysqli_close($conn);

    echo $respAx;
?>