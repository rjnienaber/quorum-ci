<?php include("../../../static/templates/pageheader.template.php"); ?> 
<script type="text/javascript">
    document.title = 'Lab 1.3: Deploying Applications | Quorum Programming Language';
</script>

<div class="hero-unit">
	<div class="hero-unit-container">
		<h1>Lab 1.3</h1>
                <p>Deploying Applications</p>
	</div>
</div>


    <?php include("../../../static/templates/contentwrapperheader.template.php"); ?>


<!--<h1>Lab 1.3: Deploying Applications</h1>-->
<h2>Objectives</h2>
<p>
The goal of this lab is learn the following:
</p>
<ul>
<li>How to deploy a Quorum program</li>
<li>Java Bytecode</li>
<li>How to Use the Command Line</li>
</ul>
<h2>Overview</h2>
<p>
The goal of this lab is to demonstrate building and deploying a Quorum application. For this lab, you will open and use the Hangman sample project (A zip file is provided at the bottom of the page for download).  You will also learn to run jar files from the command line.
</p>
<h2>Task 1: Building the Hangman Project</h2>
<p>
First, start Sodbeans. The main tutorial window may appear, go ahead and close this window or select the check box to prevent it from showing up every time you start Sodbeans.  There are two options to access the Hangman project: 1) use the provided sample project in Sodbeans and 2) download the project from the web site and open that existing project in Sodbeans.
</p>
<p>
Create a new project by using the keyboard shortcuts or going to the File menu.  The New Project dialog appears.  Use the arrow keys to navigate to the Samples folder in the Categories tree view.  Then, make sure the Quorum folder is selected under the Samples folder.  Use the keyboard shortcuts to switch the focus to the Projects tree view.  Select the Hangman project and press Enter.  In lieu of the keyboard shortcuts, the mouse can be used to select the project.  Leave the project name and location at default for now and press Enter (if the project name already exists on the computer make sure a unique name is chosen).
</p>
<p>
The project should open.  The main.quorum file should appear in the editor.  If the file does not appear in the editor, navigate to the Projects window and use the arrow keys to locate the file then press Enter.  The main.quorum file is where all the code is located in the Hangman project. Be sure to set the Hangman project as the main project (bring up the context menu and select &quot;Set as Main Project&quot;).
</p>
<p>
Now, build your hangman project. There should be no compiler errors.
</p>
<h2>Task 2: Java Bytecode and Jar files</h2>
<p>
When a Quorum project is built successfully Java Bytecode is generated for that project. Java Bytecode is a set of low level instructions that communicate with the Java Virtual Machine. This means that every Quorum project you build is translated, automatically, into another language that is understood by the Java Virtual Machine. The Java Virtual Machine or JVM, is the machine that executes programs written in JVM Languages. These languages include, Java, Ruby, Python, Scala, PHP, and many others.
</p>
<p>
Now, that your Hangman program is built we can go ahead and take a look at the files that were generated by the build process.
</p>
<ol><li>Open Windows Explorer
</li><li>Navigate to your Hangman project (usually in your NetBeansProjects folder)
</li></ol>
<p>
There should be a build folder and a run folder that were generated for your project. Open up the Build folder, notice there is a collection of folders containing .class files. These .class files contain the bytecode instructions for your Hangman program. Now, back out and open the Run folder. Notice there is a .jar file, this is the executable for your Hangman program. This jar file is a compressed executable containing all of the generated .class files for your project.
</p>
<p>
In addition to the Default.jar there is a folder containing all the additional libraries needed for your programs accessibility. These include:
</p>
<ul>
<li>Phonemic.jar - The text-to-speech engine used by Quorum.</li>
<li>Interop.SpeechLib.5.3.dll - This allows text-to-speech to work on Windows.</li>
<li>libCarbonSpeakJNI.jnilib - This allows text-to-speceh to work on Mac.</li>
<li>libLinuxSpeakJNI.so and libLinuxSpeakJNI64.so - This allows text-to-speech to work on Linux.</li>
<li>nvdaControllerClient32.dll and nvdaControllerClient64.dll - These files are a Dynamic-link Library. These libraries can be loaded and executed in any running process. </li>
<li>SappyJNI.dll and SappyJNI64 - Support files for common screen-reader applications</li>
</ul>
<p>
More information on Jar files can be found on <a class="ext-link" href="http://en.wikipedia.org/wiki/JAR_(file_format)"><span class="icon">wikipedia</span></a>.
</p>
<h2>Task 3: Execute the Jar File</h2>
<p>
It’s time to do the first run of the game from the command line!  To run the program, open a command prompt by going to the Start Menu and typing cmd into the search text box and pressing Enter. Once the command prompt is open navigate to the file containing the Default.jar file. As a reminder, &quot;cd &lt;name of director&gt;&quot; will change the directory you are in (&quot;cd ..&quot; will back you out of the directory) and &quot;dir&quot; will list the directories available.
</p>
<p>
You might do something like:
</p>
<p><pre class="code"><code>
cd NetBeansProject/Hangman/Run
</code></pre></p>
<p>
Once you have navigated to the Default.jar, execute your program by typing:
</p>
<p><pre class="code"><code>
java -jar Default.jar
</code></pre></p>
<p>
This tells the JVM to execute your program. You should notice your Hangman program is running.
</p>
<p>
Feel free to keep playing the game.  Change the answer to something different, then run the program again or start again with another program of your own design.
</p>

</div>
<?php include("../../../static/templates/pagefooter.template.php"); ?> 