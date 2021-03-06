<?php require_once("../../static/templates/pageheader.template.php"); ?>
<script type="text/javascript">
    document.title = 'Hour of Code: Part 1 | Quorum Programming Language';

    //slide array
    var slideArray = [];
    slideArray[0] = "<h5 role=\"heading\">Variables</h5>\n\
        <ul>\n\
        <li>In programming, a <code>variable</code> is a container to store information that can be used at a later time.</li>\n\
        <li>In Quorum, there are four types of basic variables: <code>text</code>, <code>number</code>, <code>integer</code> and <code>boolean</code>.  Each type of variable holds a different kind of information.</li>\n\
        <li>In this first example, we will create a <code>text</code> variable, which holds a text string of anything you want to type in. We'll explain the other types in the next sections.</li>\n\
        <li>Notice that a <code>text</code> string is enclosed in two double quotation marks.</li>\n\
        </ul><br><p>Move on to the next slide when you are ready.<p>";

    slideArray[1] = "<h5 role=\"heading\">Creating Variables</h5>\n\
        <ul>\n\
        <li>To create a variable in Quorum, we start by telling the computer what type of variable we want to make, in this case it's a <code>text</code> variable, followed by a space and a name for the variable.</li>\n\
        <li>The important thing to remember about naming a variable is that a variable needs to start with a letter.  After that, you can have numbers or more letters in the name.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Create a text variable named dna in the window at the right by typing the code: <code>text dna</code> then go to the next slide.</div>\n\
        </ul>";

    slideArray[2] = "<h5 role=\"heading\">Storing Text in Variables: Literals</h5>\n\
        <ul>\n\
        <li>Now we have made a variable named <code>dna</code>, but we haven't stored any information in it yet, so it's empty.</li>\n\
        <li>To store a value into a variable we use the <code>=</code> operator, followed by the information we want stored.</li>\n\
        <li>For this example, let's store the text string \"GATTACA\" in our <code>dna</code> variable.</li>\n\
        <li>Remember to put double quotes around the string we're storing in a text variable to tell the computer we want to store exactly what we typed.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Store the text \"GATTACA\" to the <code>dna</code> variable: <code>text dna = \"GATTACA\"</code> then go to the next slide.</div>\n\
        </ul>";

    //rewrite the example to include a literal string concatenate with a variable holding a string
    slideArray[3] = "<h5 role=\"heading\">Using Variables for Output</h5>\n\
        <ul>\n\
        <li>Now that we've stored something in our variable, we can refer to its contents whenever we need to by using the variable name.</li>\n\
        <li>To demonstrate this, let's take what we have stored in our variable and display it to the screen.</li>\n\
        <li>In Quorum, to output information to the screen we type the word <code>output</code> followed by a space and then whatever we want to show up on screen.</li>\n\
        <span class=\"title\">Try it!</span>\n\
        <div class =\"task\">Output the contents of the dna variable by typing <code>output dna</code> on a new second line and hit the green Run button to see the output.</div>\n\
        </ul>";

    slideArray[4] = "<h5 role=\"heading\">Storing Text in Variables: From Variables</h5>\n\
        <ul>\n\
        <li>If we want to assign the value of one variable to another variable, we can use the <code>=</code> operator to copy the contents.</li>\n\
        <li>We can also use the <code>+</code> operator to put more than one thing into a variable.</li>\n\
        <li>For <code>text</code> variables putting two strings into the same variable puts them one after the other.</li>\n\
        <span class=\"title\">Try it!</span>\n\
            <div class =\"task\">Create a new variable called <code>text msg</code> and then use the <code>=</code> operator to put the string and variable <code>\"Welcome to \" + dna</code> into it.  On the next line, output the msg variable: <code>output msg</code>.</div>\n\
        </ul>";

    slideArray[5] = "<h5 role=\"heading\">Additional Information Regarding Variables</h5>\n\
        <ul>\n\
        <li>Names are case sensitive: dna is not the same as DNA.</li>\n\
        <li>When storing a string into a text variable, be sure to use double quotes.</li>\n\
        <li>Because variables are just containers, if we change what is stored inside of it we can still use the same output statement and get a different result on screen.</li>\n\
        <li>If you've been following along, you can test this by changing what is initally stored in the <code>dna</code> variable.</li>\n\
        </ul>";

    $(document).ready(function () {
//        $('#IDE-output').html("GATTACA<br>Welcome to GATTACA<br>");
    });
</script>

<div id="modal" aria-hidden="true" aria-labelledby="modalTitle" aria-describedby="modalDescription" aria-live="polite" role="dialog"><div id="modalDescription" class="screenReaderContent">Beginning of dialog window. It congratulates you on completing this exercise. Escape will cancel and close the window.</div><div id="overlay-content"><h3 class='overlay-text' id="modalTitle">Congratulations, you've completed this exercise!</h3><p class='overlay-text'>Would you like to...</p><a href='part2.php' class='overlay-option'>Move on to Part 2</a><button id="modalCloseButton" class="modalCloseButton overlay-option" href="javascript:void(0)" title="Close dialog window">Stay on this page</button><p class='overlay-text'>You can always navigate to any page at a later time.</p></div></div>

<?php include("slideshow.php"); ?>

<div class="hero-unit">
    <div class="hero-unit-container" role="banner">
        <h2 id="pageTitle">Hour of Code: Part 1</h2>
        <h4 class="sub-heading">Got a New Gig</h4>
    </div>
</div>
<?php include("../../static/templates/contentwrapperheader.template.php"); ?>

    <?php include("sidebar.php"); ?><div id='content-box'><div id="slide-content-box"><div id="slide-navigation"></div>
    <div id="slide-box-wrapper" role="description" aria-live="polite"><button id="leftArrow" class="leftArrow-disabled" aria-hidden="true" aria-label="Previous Slide"></button><div id ="slide-box"></div></div><button id="rightArrow" aria-label="Next Slide"></button>
</div><?php include("../../ide.php"); ?><div id="video-container">
    <iframe width="946" height="571" src="//www.youtube.com/embed/pwRc8bjoACw?rel=0" frameborder="0" allowfullscreen></iframe></div></div>

<img src="http://code.org/api/hour/begin_quorum.png/" style="display:none">

<?php require_once("../../static/templates/pagefooter.template.php"); ?>
