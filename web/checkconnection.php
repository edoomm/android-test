<?php

include './database.php';
$conn = open_database();

if ($conn) {
    echo "Connection is succesful";
    mysqli_close($conn);
}
else {
    echo "Cannot connect to database";
}

?>