<?php include("../../include/header.php"); ?>
<script type="text/javascript">
    document.title = 'Chapter 2';
</script>

<h1>Lab 2.1: Types</h1>
<h2>Objectives</h2>
<p>
Our goal for this lab is to understand the following concepts:
</p>
<ul>
<li>Using the Sodbeans Integrated Development Environment (IDE)</li>
<li>Variable declarations</li>
<li>Naming rules for variable declarations</li>
<li>Text concatenation and the + operator</li>
</ul>
<h2>Overview</h2>
<p>
This lab will guide us through declaring variables with the appropriate name, primitive data type, and matching value. In addition to declaring variables we will practice following the guidelines listed in chapter 2, including variable naming and variable initialization conventions. Then we will learn to use the say command and the + operator. We will also revisit creating a new project and navigating the Sodbeans IDE.
</p>
<h2>Task 1: Getting Started with Sodbeans</h2>
<p>
Let’s start by opening Sodbeans and creating a new project. Instructions for creating a new project can be found in either <a href="../chapter1/lab1_1">Lab Manual 1.1</a> or Chapter 1 of the book.  In the New Project dialog, make sure &quot;Quorum&quot; is selected in the Categories list.  Then select the &quot;Blank Quorum Application&quot; project in the Projects list and press Enter.  On the next step, name a new project “Lab2_1” in the Project Name text field. Press Enter or click the Finish button to create a new project. Before we begin writing any code, be sure to check the new project is the main project.
</p>
<p>
For this lab, we will use the following windows in Sodbeans:  1) the Projects window, 2) the Sodbeans Output window, and 3) the Editor.  The Projects window holds a list of folders and files that allows us to organize and navigate the project.  This is where source files and other files will be found.  The Sodbeans Output window displays any compiler errors we may have and it displays any print statements executed during the programs runtime. Finally, the Editor window is where we will write our code.
</p>
<p>
Below is a list of shortcut keys that may be helpful when completing this lab:
</p>
<p>
General
</p>
<table class="wiki">
<tr><td><strong>Task</strong></td><td><strong>Hotkey</strong></td><td><strong>Action</strong>
</td></tr><tr><td>Create Project</td><td>CTRL + SHIFT + N</td><td>Creates a new project
</td></tr></table>
<p>
Tree Views
</p>
<table class="wiki">
<tr><td><strong>Task</strong></td><td><strong>Hotkey</strong></td><td><strong>Action</strong>
</td></tr><tr><td>Collapse Folder</td><td>Left Arrow</td><td>Collapses the folder
</td></tr><tr><td>Expand Folder</td><td>Right Arrow</td><td>Expands the folder
</td></tr></table>
<p>
New Project Dialog
</p>
<table class="wiki">
<tr><td><strong>Task</strong></td><td><strong>Hotkey</strong></td><td><strong>Action</strong>
</td></tr><tr><td>Categories List</td><td>CTRL + SHIFT + Left Arrow</td><td>Changes the focus to the Categories list
</td></tr><tr><td>Projects List</td><td>CTRL + SHIFT + Right Arrow</td><td>Changes the focus to the Projects list
</td></tr></table>
<p>
Using Project
</p>
<table class="wiki">
<tr><td><strong>Task</strong></td><td><strong>Hotkey</strong></td><td><strong>Action</strong>
</td></tr><tr><td>Build Project</td><td>F11</td><td>Builds a main project
</td></tr><tr><td>Editor Window</td><td>CTRL + 0</td><td>Changes the focus to the editor window
</td></tr><tr><td>Output Window</td><td>CTRL + 5</td><td>Changes the focus to the Sodbeans output window
</td></tr><tr><td>Projects Window</td><td>CTRL + 1</td><td>Changes the focus to the Projects window
</td></tr><tr><td>Run Project</td><td>F6</td><td>Runs a main project
</td></tr></table>
<p>
Editor Window
</p>
<table class="wiki">
<tr><td><strong>Task</strong></td><td><strong>Hotkey</strong></td><td><strong>Action</strong>
</td></tr><tr><td>Code Completion</td><td>CTRL + SPACE</td><td>Activates the code completion window
</td></tr></table>
<h2>Task 2: Write and Test a Program</h2>
<p>
We will start by writing code in the main.quorum file.  In the Projects window, use arrow keys to navigate to the "main.quorum" file and press Enter.
</p>
<p>
To build a program that declares several variables we should first make sure main.quorum is blank (go ahead and delete anything that might have been generated in this file). The first line should declare the variable <strong>myInteger</strong> with the <strong><tt>integer</tt></strong> type and assign the variable the value of 4. Once this variable is declared build your project and check for any compiler errors.
</p>
<p>
Build the project by going to Run -&gt; Build Main Project or press F11.  The program should compile with no errors. If it does have errors there is a problem with the line of code in our project. The message in the Sodbeans Output window should give you a clue as to what went wrong. In addition, Sodbeans will automatically display a line under the code that has an error so that we will know where something went wrong. Remember, compiling this code will not check that you assigned the value 4 to the variable <strong>myInteger</strong>. Instead, it checks that the format of the code is valid: <strong><tt>&lt;type&gt; &lt;unique name&gt; = &lt;value&gt;</tt></strong>.  Sodbeans compiles the code and checks for any errors in the background, so there is no need to keep building the project when we want to compile our code again. Once all of the compiler errors are gone run the program by going to Run -&gt; Run Main Project or press F6.  When the project runs nothing should have happened because we have not gone that far yet!
</p>
<p>
Next, add two lines of code:
</p>
<p><pre class="code"><code>
integer 2myInteger = 5
integer _myInteger = 6
</code></pre></p>
<p>
Run the program.  The compiler errors will appear in the Sodbeans Output window as shown below:
</p>
<p><pre class="code"><code>
no variable alternative as character ‘_’
extraneous input ‘2’
</code></pre></p>
<p>
We are receiving those compiler errors because variable names must start with a letter(they do not follow the appropriate format).  After the required first letter, variable names can have any number of letters, numbers, or underscores.  Fix two incorrect variable names and run the program again. The compiler errors should go away.
</p>
<p>
Let's add more variables and types to the program.  Do the following steps to add types:
</p>
<ul><li>Define an <strong><tt>integer</tt></strong> type and give the variable name <strong>firstInteger</strong>. Assign firstInteger to 4.
</li><li>In the next line, define a <strong><tt>number</tt></strong> type and give the variable name <strong>secondNumber</strong>. Assign secondNumber to 8.9.
</li><li>In the next line, define a <strong><tt>boolean</tt></strong> type and give the variable name <strong>checkResult</strong>. Assign checkResult to true.
</li><li>In the next line, define a <strong><tt>text</tt></strong> type and give the variable name <strong>quorumText</strong>. Assign quorumText to “Quorum is fun.”
</li></ul>
<p>
Now that we have defined all four variables, have Sodbeans speak each variable out to the speakers. We can make the computer speak our variables by using the <strong><tt>say</tt></strong> statement. Once this is completed the output should say the following:
</p>
<p><pre class="code"><code>
4
8.9
true
Quorum is fun
</code></pre></p>
<p>
Now let's have our program speak another sentence but this time the variables should be used in the sentence. Try to use only one <strong><tt>say</tt></strong> statement to speak the above text (hint:  use concatenation). The output should say the following:
</p>
<p><pre class="code"><code>
The program returns true when 8.9 is greater than 4. Quorum is fun.
</code></pre></p>
<p>
We still have the three unused integers variables.  Although it is okay to leave them declared and not use them somewhere in the program, it is a better practice to use all declared variables.  Below the line with the fifth <strong><tt>say</tt></strong> statement, write one line of code that adds all of the unused integer variables together and assigns the result to the variable <b>firstInteger</b>.
</p>
<p>
Then add a new <strong><tt>say</tt></strong> statement that matches the following output.  Be sure to set any new values to the the necessary variables (hint: checkResult and quorumText have new values).
</p>
<p><pre class="code"><code>
The program returns false when 8.9 is less than 15. Quorum is cool.
</code></pre></p>
<p>
We are done! Show your work to the instructor.
</p>

<?php include("../../include/footer.php"); ?>