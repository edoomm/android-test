<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Usuarios registrados</title>
    <meta name='viewport'
        content='width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no' />
    <meta name="description" content="">
    <meta name="keywords" content="">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>

<body>
    <div class="container" style="padding-top: 2%;">
        <form id="frmInsert" autocomplete="off">
            <div class="form-group">
                <label for="noEmpleado">Ingrese el número de empleado</label>
                <input type="email" class="form-control" id="noEmpleado" name="noEmpleado"
                    placeholder="###### (6 dígitos)" maxlength="6">
            </div>
            <br>
            <div class="form-group">
                <label for="nombre">Ingrese el nombre del empleado</label>
                <input type="text" class="form-control" id="nombre" name="nombre"
                    placeholder="Nombre ApellidoPaterno ApellidoMaterno (máximo 50 caracteres)" maxlength="50">
            </div>
            <br>
            <button class="btn btn-primary" onclick="validate(event);">Agregar nuevo</button>
        </form>
    </div>

    <br><br>

    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">No. Empleado</th>
                    <th scope="col">Nombre</th>
                </tr>
            </thead>
            <tbody>
                <?php
            include './database.php';
            $conn = open_database();

            $query = "SELECT numero_empleado AS num, nombre AS nom FROM Empleado";
            $result = mysqli_query($conn, $query);
            mysqli_close($conn);

            while ($row = mysqli_fetch_array($result)) {
            ?>

                <tr>
                    <td> <?php echo $row["num"]; ?> </td>
                    <td> <?php echo $row["nom"]; ?> </td>
                </tr>

            <?php
            }
            ?>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous">
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</body>

</html>

<script>
    $(document).ready(function () {
        $("#noEmpleado").focus();
        // alert("Empleados registrados: <?php echo mysqli_num_rows($result); ?>");
    });

    function validate(e) {
        e.preventDefault();

        if ($("#noEmpleado").val() == "" || $("#nombre").val() == "") {
            alert("Campos vacios");
            $("#noEmpleado").focus();

            return;
        }

        insert();
    }

    function insert() {
        $.ajax({
            url: "./insert.php",
            method: "POST",
            data: {noEmpleado: $("#noEmpleado").val(), nombre: $("#nombre").val()},
            cache: false,
            success: function (respAx) {
                alert(respAx);

                if (respAx == "Empleado registrado correctamente")
                    location.reload();
                else
                    $("#noEmpleado").focus();
            }
        });
    }
</script>