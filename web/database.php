<?php

function open_database() {
    $host = "localhost";
    $user = "root";
    $pwd = "1234";
    $db = "test";

    $conn = mysqli_connect($host, $user, $pwd, $db);
    if (mysqli_connect_errno($conn))
      echo "Failed to connect to MySQL: " . mysqli_connect_error();

    return $conn;
}

?>