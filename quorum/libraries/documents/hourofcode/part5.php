<?php include("../../static/templates/pageheader.template.php"); ?>
<script type="text/javascript">
    document.title = 'Hour of Code: Part 5 | Quorum Programming Language';
</script>

<div class="hero-unit">
	<div class="hero-unit-container">
		<h1>Hour of Code: Part 5</h1>
                <p>Trait Inheritance</p>
	</div>
</div>
  <?php include("../../static/templates/contentwrapperheader.template.php"); ?>

<?php include("sidebar.php"); ?><div id="video-container">
    <iframe width="468" height="351" src="//www.youtube.com/embed/If3KlMxbtcc?rel=0" frameborder="0" allowfullscreen></iframe>
</div><div id="hour-of-code-IDE">
    <h2>Try It! <span class="hour-of-code-IDE-subtitle">Enter Quorum code below and press "Run" to execute it</span></h2>
    <div id="hour-of-code-IDE-controller">
    </div>
        <textarea id="hour-of-code-IDE-input" class="ide inputArea">var person = function() {
  this.eyeColor = "";
  this.hairColor = "";
}

var John = new person();
John.eyeColor = "brown";
John.hairColor = "blue";

var output = "John has " + John.eyeColor + " eyes and " + John.hairColor + " hair."
output;</textarea>
        
        <pre id="hour-of-code-IDE-output" class="outputArea"></pre><div id="run-button" class="btn-group">
                <a class="btn btn-success" href="#">Run</a>
        </div></div><div id="hour-of-code-canvas">
</div>

<?php include("../../static/templates/pagefooter.template.php"); ?>


