<?php
	$url = "http://localhost:8000"; // destination, like localhost:8000 or whatever
	$data = $_POST['code']; // make this your data object
	var_dump($data);

	$ch = @curl_init();
	curl_setopt($ch, CURLOPT_POST, true);
	curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	$result = curl_exec($ch);
	var_dump($result);
	curl_close($ch);
?>