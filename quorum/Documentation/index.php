<?php require_once("static/templates/pageheader.template.php"); ?>
<div class="hero-unit">
	<div class="hero-unit-container">
		<h1>The Quorum Programming Language</h1>
		<p>Quorum is a general purpose, object-oriented, programming
                    language. Designed in formal 
    empirical studies with human subjects, Quorum has been iteratively 
    refined to make it easy to understand and use.</p>
	</div>
</div>

<div class="content index-content">
<h1>Introducing Quorum</h1>
<p>
    Quorum 2.0 (see 
    the <a href="documents/release.php">Quorum release notes</a>), 
    has the following features and more:
</p>
 
 <?php require("ide.php"); ?>
 <div class="ide-embed-info">
    <label>Embed to your website: </label>
    <input type="text" value='<iframe src="http://www.quorumlanguage.com/embedded-ide.php" height="432" width="582" scrolling="no" class="quorum-ide" style="border:0; box-shadow: 2px 2px 2px #999999; -webkit-box-shadow: 2px 2px 2px #999999; -moz-box-shadow: 2px 2px 2px #999999; ">'>
 </div>

<ul>
    <li>Source code is compiled to Java bytecode</li>
    <li>Static type checking with some type inference</li>
    <li>Unique control structures, heavily tested to be easily understood by 
        novices and professionals</li>
    <li>Object-orientation</li>
    <li>A growing <a href="libraries.php">Standard Library</a> (e.g., data structures, 
        music generation, text-to-speech)</li>
    <li>A <a href="documents/syntax/plugins.php">Plugin system</a> for extending Quorum with Java or C++</li>
    
    <li>A talking Omniscient debugger (e.g., debug backwards, analyze variable histories)</li>
    <li>NetBeans Integration (see the <a href="documents/releaseIDE.php">Sodbeans release notes</a>) </li>
</ul>
<h2>Getting Started</h2>
<ul>
    <li>Here is the <a href="download.php">download and installation</a> page. 
        Quorum also comes included in 
        <a href="http://sodbeans.sourceforge.net/download.php">Sodbeans</a>.</li>
    <li>If you are new to Quorum and want to learn how to write programs, check 
        out information on the <a href="syntax.php">syntax.</a></li>
    <li>If you are taking a class on Quorum, <a href="curriculum.php">labs, 
            programming assignments, and curriculum</a> is available.</li>
    <li>If you want a quick reference for Quorum's console arguments, go
        to the <a href="documents/console.php">command line reference page</a>.

</ul>
<h2>Example Code in Quorum</h2>
<p>
    Below are some full examples of programs written in Quorum. These examples 
    are complete standalone programs. Here's hello, world:
</p>
<p><pre class="code"><code>
output &quot;Hello, world!&quot;
</code></pre></p>
<p>
    Here's how you make Quorum talk:
</p>
<p><pre class="code"><code>
say &quot;Hello, World!&quot;
</code></pre></p>
<p>
    and here's how you create a chromatic musical scale (starting at middle C) 
    play out of your computer's speakers:
</p>
<p><pre class="code"><code>
use Libraries.Sound.Music
Music muse
integer i = 0
repeat 12 times
   muse:Play(60 + i,1)
   i = i + 1
end
</code></pre></p>
</div>
<?php require_once("static/templates/pagefooter.template.php"); ?>