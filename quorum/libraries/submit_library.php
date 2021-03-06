<?php 
$classPageTitle = "Submit a Library to Quorum";

require_once("static/templates/pageheader.template.php");
require_once("models/librarySubmission.model.php");
require_once("models/librarySubmissions.model.php");
require_once("models/user.model.php");
require_once("models/badge.model.php");
require_once("models/email.model.php");

function award_badge($submission) {
    $submissions = new LibrarySubmissions("", "", "", "");
    $submissions = $submissions->getLibrarySubmissionsForUser($_COOKIE['username']);
    $number_of_submissions = count($submissions);
    $badge = null;

    switch ($number_of_submissions) {
        case 1: $badge = new Badge($_COOKIE['username'], "novice-submitter", "type-submitted"); break;
        case 5: $badge = new Badge($_COOKIE['username'], "journeyman-submitter", "type-submitted"); break;
        default: $badge = null;
    }

    if ($badge != null) { // There is a badge to be awarded
        if ($badge->doesUserHaveBadge() == false) { // Double-check  
            $badge->insertBadge();
            $badge->emailUserAboutBadge($submission);
        }
    }
}

function create_input($name, $placeholder, $textarea = false) {
    $value = empty($_POST[$name]) ? "" : $_POST[$name];
    if ($textarea) {
        print '<textarea id="' . $name .'" name="' . $name .'" placeholder="' . $placeholder .'">'. $value .'</textarea>';
    }
    else {
        print '<input type="text" id="' . $name .'" name="' . $name .'" placeholder="' . $placeholder .'" value="'. $value .'">';
    }    
}

function input_invalid($name) {
    return !(isset($_POST[$name]) && !empty($_POST[$name])); 
}

function error_message($msg) {
    return '<li class="text-error">' . $msg . '</span>';
}


function insert_to_database() {
    $library_slug = slugify($_POST['library-name']);
    
    $check_for_id_existence = new LibrarySubmission($library_slug, null, null, null, null, null, null, null, null, null, null);
    $library_exists = !($check_for_id_existence->getSubmissionByID());
    
    if ($library_exists) {    
        $submissionURL = "/submissions/" . $_COOKIE['username'] . "-" . $_FILES["library-files"]["name"];
        $supplementaryFilesURL = isset($_FILES["library-supplements"]) ? "/submissions/supplements/" . $_COOKIE['username'] . "-" . $_FILES["library-supplements"]["name"] : "";
    
        $submission = new LibrarySubmission($library_slug, $_POST['library-name'], $_COOKIE['username'], $_POST['author-name'], $_POST['library-description'], $_POST['library-usage'], $submissionURL, $supplementaryFilesURL, 1, "pending-reviewer", date("Y-m-d H:i:s"));
        try {
            $submission->insertSubmission();            
            return $submission;
        }
        catch (Exception $ex) {
            return false; 
        }   
    }
    return false;
}


function email_administrators($submission) {        
    $message = "The library " . $submission->libraryName . " has been submitted by " . $submission->uploaderUsername . ". ";
    $message .= "You can see the library at http://quorumlanguage.com/submitted_library.php?id=" . $submission->libraryID;
    $email = new Email("stefika+quorumlanguagedotcom@gmail.com, kerrylritter+quorumlanguagedotcom@gmail.com","quorum@quorumlanguage.com","A library submisson has been submitted",$message);
    $email->send();
}


function email_user($submission) {
    $user = new User(null, $submission->uploaderUsername, null, null, null, null);
    $user->getDataFromUsername();

    $message = "Thank you for  submitting the library " . $submission->libraryName . ". ";
    $message .= "You can see the library at http://quorumlanguage.com/submitted_library.php?id=" . $submission->libraryID;
    $email = new Email($user->email,"quorum@quorumlanguage.com","Thank you for your library submission",$message);

    $email->send();
}

function upload_files() {
    try {
        $submissions_save_location = "/home/stefika/public_html/test/submissions/"  . $_COOKIE['username'] . "-" . $_FILES["library-files"]["name"];
        $tmp_name =  $_FILES["library-files"]["tmp_name"];
        $result = move_uploaded_file( $tmp_name, $submissions_save_location );
    
        if (isset($_FILES["library-supplements"])) {
            $tmp_name =  $_FILES["library-supplements"]["tmp_name"];
            $supplements_save_location = "/home/stefika/public_html/test/submissions/supplements/" . $_COOKIE['username'] . "-" . $_FILES["library-supplements"]["name"];
            move_uploaded_file( $tmp_name, $supplements_save_location );
        }
        return true;
    }
    catch (Exception $ex) {
        return false;
    }
}

function process_post() {
     if ($_GET['post'] == "true") {
        $errors = "";
        
        if (input_invalid("library-name")) {
            $errors .= error_message("Please enter a library name.");
        }

        if (input_invalid("author-name")) {
            $errors .= error_message("Please enter an author name.");
        }
        
        if (input_invalid("library-description")) {
            $errors .= error_message("Please enter a description for your library.");
        }
        
        if (input_invalid("library-usage")) {
            $errors .= error_message("Please enter usage instructions for the library.");
        }

        if (isset($_FILES["library-files"])) {
            if ($_FILES["library-files"]["size"] >= 524288) {
                $errors .= error_message("Your submission exceeds the maximum file size.");
            }
            $file_type = $_FILES["library-files"]["type"];
            if ($file_type != "application/zip" && $file_type != "application/x-zip-compressed") {
                $errors .= error_message("Your submission must be a ZIP file.");
            }
        }
        else {
            $errors .= error_message("Please enter a submission file.");
        }

        $supplements_file_type = $_FILES["library-supplements"]["type"];
        if ($supplements_file_type != "application/zip" && $supplements_file_type != "application/x-zip-compressed" && $_FILES["library-supplements"]["type"] != "") {
            $errors .= error_message("Your supplement file must be a ZIP file.");
        }
        
        if ($errors != "") {
            return '<ul class=" container errors">' . $errors . '</ul>';
        }
        
        // At this point, we know there are no errors so post to the DB upload the files.
        $submission = insert_to_database();
        if ($submission != false) {
            if (upload_files()) {
                email_administrators($submission);
                email_user($submission);
                award_badge($submission);
            }
            else {
                // could not upload files
                return '<ul class=" container errors"><li class="text-error">There was an error uploading your files.</span></ul>';
            }
        }
        else {
            // could not insert to database
            return '<ul class=" container errors"><li class="text-error">This library name already exists on in our database.</span></ul>';
        }
        
        return false;
    }
     return true;
}

$errors = process_post();

if ($errors == false) { // Successful submission
?>

<div class="library-submission-wizard-container container">
	<h1 class="container">Thank you for your submission!</h1>
    <h2>What is the process from here?</h2>
    <p>Now that you have submitted, someone on the team
        will take a look at what you sent us and check it out. 
        Our basic steps include:</p>
    <ol> 
        <li>Check if it's a valid submission (e.g., not spam or junk).</li>
        <li>If you submitted something new to the standard library, your library will go
        through peer review.</li>
        <li>If you are submitting an upgrade to an existing part of the standard 
        library (any file that already exists), we will review and provide 
        feedback on a case-by-case basis. Depending on the change, we may 
        require evidence that the change you have provided is helpful to humans.</li>
        <li>If you submitted a request to change the core Quorum language (e.g., 
            add a language feature), you 
            <strong>must</strong> have included, along with your submission, a 
        formal randomized controlled trial. Submissions without this component will
        be rejected.</li>
        <li>If you submitted something else, we will take a look and get back to you.</li>
        <li>Your submission will either be accepted, accepted conditionally, 
        we will request more information, or we will reject it, using a procedure
        similar to those of academic journals.</li>
        <li>If your library is accepted, you may earn a badge of awesomeness on
            your account!</li>
    </ol>
    <h2>What do I need to do in the meantime?</h2>
    <p>For now, just relax. Peer review can take time, depending on how complex it 
    will be to review what you sent us. Simple libraries may be reviewed quickly, 
    depending on the interest level of the community and availability of reviewers.
    Complex submissions (e.g., an empirical study on a potential new language feature) 
    may require we send your submission to outside experts
    for formal academic peer review.</p>
    
    <h2>Why bother with all this anyway?</h2>
    <p>The point of this system is to ensure that 
    the standard library in Quorum, and the language itself, not only grows, but also 
    improves over time. A review process helps us keep the language stable for 
    current users, with an evidence standard for making changes that could
    potentially help the community in the long run.</p>
</div>
    
<?php    
}
else {
?>

<div id="library-submission-wizard-container">
	<h1 class="container">Submit a Library to Quorum</h1>
    <?php
    if (isset($_COOKIE['username'])) {
        $user = new User(null, $_COOKIE['username'], null, null);
        $user->getDataFromUsername();

        if (trim($user->first_name) == "" || trim($user->last_name) == "") {
    ?>

    <div class="container">
        <h4 class="text-info">
            To submit a library, we need to have your first and last name. To continue with
            submitting a library, please go to the control panel and update your profile with 
            your legal first and last name. Thank you for your interest in submitting to
            the Quorum standard library!
        </h4>
    </div>

    <?php
        }
        else {
            if ($_GET["post"] == "true") {
                echo '<div class="container"><h3 class="text-error">There were errors with your submission:</h3>' . $errors . '</div>';
            }
    ?>
    	<form id="library-submission" class="form-horizontal" method="post" action="?post=true" enctype="multipart/form-data">
    		<div id="submission-wizard" class="carousel">
    			<div class="carousel-inner">
    				<div class="active item" id="wizard-1">
    					<div class="container">
    						<h2>Quorum Project Contributors Certification of Origin and Rights</h2>
                            <p>Contributors to the Quorum Programming Language must formally agree to abide by this certificate of origin by signing on the bottom with their quorumlanguage.com userid, full name, email address (you can obscure your e-mail, but it must be computable by human), and date.</p>
                            <p>By signing this agreement, you are warranting and representing that you have the right to release code contributions or other content free of any obligations to third parties and are granting Andreas Stefik and Quorum project contributors, henceforth referred to as The Quorum Project, a license to incorporate it into The Quorum Project tools (such as Sodbeans and the Quorum standard library) or related works under the BSD license. You understand that The Quorum Project may or may not incorporate your contribution and you warrant and represent the following:</p>
                            <ol>
                                <li> I am the creator of all my contributions. I am the author of all contributed work submitted and further warrant and represent that such work is my original creation and I have the right to license it to The Quorum Project for release under the 3-clause BSD license. I hereby grant The Quorum Project a nonexclusive, irrevocable, royalty-free, worldwide license to reproduce, distribute, prepare derivative works, and otherwise use this contribution as part of the Quorum project, associated documentation, books, and tools at no cost to The Quorum Project. </li>
                                <li>I have the right to submit. This submission does not violate the rights of any person or entity and that I have legal authority over this submission and to make this certification.</li>
                                <li>If I violate another's rights, liability lies with me. I agree to defend, indemnify, and hold The Quorum Project and Quorum users harmless from any claim or demand, including reasonable attorney fees, made by any third party due to or arising out of my violation of these terms and conditions or my violation of the rights of another person or entity.</li>
                                <li>I understand and agree that this project and the contribution are public and that a record of the contribution (including all personal information I submit with it, including my sign-off) is maintained indefinitely and may be redistributed consistent with this project or the open source license indicated in the file.</li>
                            </ol>

    						<div class="actions clearfix">
    							<a class="btn btn-primary btn-next pull-right" href="#submission-wizard" disabled>Next</a>
    							<label class="checkbox pull-right">
    							<input type="checkbox" id="agree-to-bsd" value="">
    							I have read this agreement and do so certify by adding my signoff to the end of the following contributors list.
    							</label>
    						</div>
    					</div>
    				</div>
    				<div class="item" id="wizard-2">
    					<div class="container">
    						<div class="control-group">
    							<label class="control-label" for="library-name">Name of the Library Submission</label>
    							<div class="controls">
                                    <?php create_input("library-name", "Library Name"); ?>
    							</div>
    						</div>
    						<div class="control-group">
    							<label class="control-label" for="author-name">Name of the Submission's Author(s)</label>
    							<div class="controls">
                                    <?php create_input("author-name", "Author Name(s)"); ?>
    							</div>
    						</div>
    						<div class="control-group">
    							<label class="control-label" for="library-description">Description of the Library Submission</label>
    							<div class="controls">
                                    <?php create_input("library-description", "", true); ?>
    							</div>
    						</div>
    						<div class="control-group">
    							<label class="control-label" for="library-usage">Instructions on the Library's Usage</label>
    							<div class="controls">
                                    <?php create_input("library-usage", "", true); ?>
    							</div>
    						</div>
    						<div class="actions clearfix">
    							<a class="btn btn-previous pull-left" href="#submission-wizard" data-slide="prev">Back</a>
    							<a class="btn btn-primary btn-next pull-right" href="#submission-wizard" data-slide="next">Next</a>
    						</div>
    					</div>
    				</div>
    				<div class="item" id="wizard-3">
    					<div class="container">
    						<div class="control-group">
    							<label class="control-label" for="library-files">Library Submission Files</label>
    							<div class="controls">
    								<input type="file" id="library-files" name="library-files" placeholder="">
    								<span class="help-block"><em>Note: ZIP files only. Please upload only text files in the archive and do not upload any binaries. <br />Maximum file size: 512KB</em></span>
    							</div>
    						</div>
    						<div class="control-group">
    							<label class="control-label" for="library-supplements">Supplementary Files</label>
    							<div class="controls">
    								<input type="file" id="library-supplements" name="library-supplements" placeholder="">
    								<span class="help-block">Upload any files relevant to the submission that can help users understand your submission, such as usability studies or testing results.</span>
    							</div>
    						</div>
    						<div class="actions clearfix">
    							<a class="btn btn-previous pull-left" href="#submission-wizard" data-slide="prev">Back</a>
    							<input type="submit" class="btn btn-primary btn-submit pull-right" value="Submit">
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</form>   
    <?php            
        }
    }
    else { // User is not logged in
        echo '<div class="container"><h4 class="text-info">You must be registered and logged in to submit a library to Quorum.</h4></div>';
    }
    ?>
</div>
<?php
}
?>
<?php require_once("static/templates/pagefooter.template.php"); ?>