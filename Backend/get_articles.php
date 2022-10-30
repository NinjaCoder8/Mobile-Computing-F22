<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

$query = $mysqli->prepare("SELECT * From articles");
$query->execute();

$results = $query->get_result();
$response = [];

while($article = $results->fetch_assoc()){
    $response[] = $article;
}

echo json_encode($response);





