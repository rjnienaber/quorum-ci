<?php require_once("../../static/templates/pageheader.template.php"); ?>
<script type="text/javascript">
    document.title = 'Hour of Code: Part 2 | Quorum Programming Language';
    
    //slide array
    var slideArray = new Array();
    slideArray[0] = "<h5 role=\"heading\">Number Variables</h5>\n\
        <ul>\n\
        <li>Another type of variable often used in programming is a real number. In Quorum to create this type of variable we use the keyword <code>number</code>.</li>\n\
        <li>A <code>number</code> variable holds numeric values that can include decimal places such as 8.3439 or 42.0 or even 19.</li>\n\
        <li>Unlike text variables, we never use double quotes when storing a number, we just type it.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Create a number variable with the following code: <code>number pi = 3.14159</code>.</div>\n\
        </ul>";
    
    slideArray[1] = "<h5 role=\"heading\">Arithmetic with Number Variables</h5>\n\
        <ul>\n\
        <li>We can do arithmetic calculations with <code>number</code> variables, just like we would on the numbers themselves.</li>\n\
        <li>The computer substitutes the actual number in the variable into the formula and performs the calculation.</li>\n\
        <li>For example, if we make a new variable that holds the radius of a circle, then we can calculate its area using the formula area = pi X radius X radius.  On a computer, the multiplication operater is the <code>*</code>.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Create a variable to hold your circle's radius: <code>number radius = 3</code> and then calculate the area: <code>number area = pi * radius * radius</code></div>\n\
        </ul>";
    
    slideArray[2] = "<h5 role=\"heading\">Make the Computer Talk with: Say</h5>\n\
        <ul>\n\
        <li>Quorum has a built in feature to instruct the computer to say things out loud.  This is done by using the keyword <code>say</code> followed by whatever we want it to say.</li>\n\
        <li>Just like with output statements, the computer can say the contents of a stored variable or a string that we type in.</li>\n\
        <li><span class = \"bold\">Note:</span> Say statements may not work with all web browsers.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Tell the computer to say the result of the area calculation you just completed by typing a new line: <code>say \"The area is \" + area</code></div>\n\
        </ul>"; //operators, concat
    
    slideArray[3] = "<h5 role=\"heading\">Additional Information</h5>\n\
        <ul>\n\
        <li>There are 5 main operators when using numbers: <code>+</code> (addition), <code>-</code> (subtraction), <code>*</code> (multiplication), <code>/</code> division and <code>mod</code> (modulus).</li>\n\
        <li>The modulus operator is used for finding the remainder of a division operation, for example: <code>15 mod 10</code> will give us a result of 5.</li>\n\
        <li>One example of how to use the modulus operator is to deterimine if a number is even or odd: <code>evenNum mod 2</code>  equals 0 and <code>oddNum mod 2</code> equals 1.</li>\n\
        <li>When using <code>say</code> or <code>output</code> statements, you can concatenate (add) things to be output one after another using the <code>+</code> operator, just like in the previous slide.</li>\n\
        </ul>";
    
    $(document).ready(function(){
        $('#IDE-input').text('number pi = 3.14159\nnumber radius = 3\nnumber area = pi * radius * radius\nsay "The area is " + area');
    });
</script>
<?php include("slideshow.php"); ?>

<div class="hero-unit">
	<div class="hero-unit-container" role="banner">
		<h1>Hour of Code: Part 2</h1>
                <p>Sayin' Stuff</p>
	</div>
</div>
  <?php include("../../static/templates/contentwrapperheader.template.php"); ?>

      <?php include("sidebar.php"); ?><div id="content-box"><div id="slide-navigation"></div>
          <div id="slide-box-wrapper" role="description" aria-live="polite"><button id="leftArrow" class="leftArrow-disabled" aria-hidden="true" aria-label="Previous Slide"></button><div id ="slide-box"></div></div><button id="rightArrow" aria-label="Next Slide"></button>
</div><?php include ("../../ide.php"); ?><div id="video-container">
    <iframe width="946" height="710" src="//www.youtube.com/embed/jiBoy-YndQw?rel=0" frameborder="0" allowfullscreen></iframe>
</div>

<?php require_once("../../static/templates/pagefooter.template.php"); ?>