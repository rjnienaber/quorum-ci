<?php
	require("../models/user.model.php");

	function register() {
		$email = $_POST['registration-email'];
		$username = $_POST['registration-username'];
		$password = $_POST['registration-password'];
		$google_id = $_POST['registration-identity'];
		$first_name = $_POST['registration-first-name'];
		$last_name = $_POST['registration-last-name'];

		$user = new User($email, $username, $password, $google_id, $first_name, $last_name);
		
		if ($user->insert() == true) {
			try {
				$user->createCookies();
				print "1";
			}
			catch (Exception $ex) {
				print "-1";
			}
		}
		else {
			print "0";
		}
	}

	function standardLogin() {
		$username = $_POST['login-username'];
		$password = $_POST['login-password'];

		$user = new User(null, $username, $password, null);
		
		print (login($user) == true) ? "1" : "0";
	}

	function login($user) {
		if ($user->checkLogin() == true) {
			try {
				$user->createCookies();
				return true;
			}
			catch (Exception $ex) {
				return false;
			}
		}
		else {
			return false;
		}
	}

	function signOut() {
		header("Location: " . $_POST['referer']);

		ob_start();
		$timeUntilExpire = time() - 3600; // expire an hour in the past
		setcookie( "username", "", $timeUntilExpire, '/');
		setcookie( "password", "", $timeUntilExpire, '/');
		ob_end_flush();
	}

	function cancelGoogle() {
		session_start();
		$_SESSION['openIdData'] = null;
		$_SESSION['referer'] = null;
		$_SESSION['extension'] = null;
		header('Location: ' . $_GET['returnurl']);
	}

	function googleUserLoginAuthenticate() {
		session_start();

		$openIdData = $_SESSION['openIdData'];
		$user = new User($openIdData['email'], null, null, $openIdData['identity']);
		$user->getUsernameFromGoogleId();

		$result = login($user); 
		print ($result == true) ? "1" : "0";
		
		$_SESSION['openIdData'] = null;
	}

	function router($action) {
		switch ($action) {
			case "login": standardLogin(); break;
			case "register": register(); break;
			case "signout": signOut(); break;
			case "cancelgoogle": cancelGoogle(); break;
			case "googleUserLoginAuthenticate": googleUserLoginAuthenticate(); break;
		}
	}

	router($_GET['action']);
?>