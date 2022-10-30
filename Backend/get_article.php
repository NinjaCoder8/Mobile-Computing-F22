<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

$id = $_GET["id"];

$query = $mysqli->prepare("SELECT * From articles WHERE id = ?");
$query->bind_param("i", $id);
$query->execute();

$results = $query->get_result();
$response = [];

$article = $results->fetch_assoc();
echo json_encode($article);





