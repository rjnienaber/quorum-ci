<?php require_once("../../static/templates/pageheader.template.php"); ?>
<script type="text/javascript">
    document.title = 'Hour of Code: Part 7 | Quorum Programming Language';
    
    //slide array
    var slideArray = new Array();
    slideArray[0] = "<h5 role=\"heading\">Superbugs.</h5><ul><li role=\"listitem\"><li>We made superbugs with superpowerd DNA sequences, meaning they have superpowers.</li>";
    slideArray[1] = "";
    slideArray[2] = "";
    slideArray[3] = "";
    slideArray[4] = "";
    
    $(document).ready(function(){
        $('#IDE-input').text('');
    });
</script>
<?php include("slideshow.php"); ?>

<div class="hero-unit">
	<div class="hero-unit-container" role="banner">
		<h1>Hour of Code: Part 7</h1>
                <p>Take Over the World!</p>
	</div>
</div>
  <?php include("../../static/templates/contentwrapperheader.template.php"); ?>

      <?php include("sidebar.php"); ?><div id="content-box"><div id="slide-navigation"></div>
          <div id="slide-box-wrapper" role="description" aria-live="polite"><button id="leftArrow" class="leftArrow-disabled" aria-hidden="true" aria-label="Previous Slide"></button><div id ="slide-box"></div></div><button id="rightArrow" aria-label="Next Slide"></button>
</div><?php include ("../../ide.php"); ?><div id="video-container">
    <iframe width="946" height="710" src="//www.youtube.com/embed/If3KlMxbtcc?rel=0" frameborder="0" allowfullscreen></iframe>
</div>

<?php require_once("../../static/templates/pagefooter.template.php"); ?>