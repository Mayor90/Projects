<?php
// Enter your host name, database username, password, and database name.
// If you have not set database password on localhost then set empty.
try {
    $con = mysqli_connect("localhost", "root", "", "loginsystem");
} catch (mysqli_sql_exception) {
    echo "Failed to connect to MySQL: ";
}
// Check connection
// if (mysqli_connect_errno()) {
//     echo "Failed to connect to MySQL: " . mysqli_connect_error();
// }
// if ($con) {
//     echo "You are connected";
// }
