<?php
  $messages = array(
      "googleValid" => "<h4>You have been authenticated with Google. Please enter a username for your account.</h4>",
      "googleErrors" => "<h4>There were errors with your Google authentication. Please use the registration form.</h4>",
      "registration" => '<h4 class="half-size">Please create an account below, or ...</h4>'
    );

  $state = "";
  $data = $_SESSION['openIdData'];
  if ($data == null) {
    $state = "registration";
  }
  else if (array_key_exists("errors", $data)) {
    $state = "googleErrors";
  }
  else if (array_key_exists("valid", $data)) {
    $state = $data['valid'] ? "googleValid" : "googleErrors";
  }
?>


<div id="modal-registration" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="modal-label-registration" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="modal-registration-header">Register for Quorum</h3>
  </div>
  <div class="modal-body">
    <?php 
      print $messages[$state];
      if ($state == "registration") {
        print '<form action="' . getFullUrl("assets/apis/lightopenid/google.php?login"). '" method="post">';
          print '<input type="hidden" name="referer" value="' . getRoot() . getPage() . '" />'; ?>
          <input type="submit" class="btn btn-success auth-with-google" value="Signup with Google" />
        </form>
    <?php
      }
    ?>
    
    <form class="form-horizontal" id="registration-form">
      <?php 
        if ($state == "googleValid") {
          $validEmailAttributes = ' value="' . $data['email'] . '" disabled="disabled"';
          print '<input type="hidden" name="registration-firstname" value="' . $data['firstName'] . '" />';  // <input type="hidden" name="registration-firstname" value="Kerry" />
          print '<input type="hidden" name="registration-lastname" value="' . $data['lastName'] . '" />';
          print '<input type="hidden" name="registration-identity" value="' . $data['identity'] . '" />';     // cout << x << y
        }
      ?>
      <fieldset>
        <div class="control-group email">
          <label class="control-label" for="registration-email">Email</label>
          <div class="controls">
            <?php
              print '<input type="text" class="input-xlarge" name="registration-email" id="registration-email"' . $validEmailAttributes . ' />';
            ?>
            <p class="text-error">Please enter a valid email</p>
          </div>
        </div>
        <div class="control-group username">
          <label class="control-label" for="registration-username">Username</label>
          <div class="controls">
            <input type="text" class="input-xlarge" name="registration-username" id="registration-username" />
            <p class="text-error">Please enter a valid username</p>
          </div>
        </div>
        <?php if ($state != "googleValid") { ?>
            <div class="control-group password">
              <label class="control-label" for="registration-password">Password</label>
              <div class="controls">
                <input type="password" class="input-xlarge" name="registration-password" id="registration-password" />
                <p class="text-error">Please enter a password</p>
              </div>
            </div>
        <?php } ?>
      </fieldset>
    </form>

  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary">Register</button>
  </div>
</div>