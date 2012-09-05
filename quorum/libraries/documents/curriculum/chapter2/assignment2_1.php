<?php include("../../include/header.php"); ?>
<script type="text/javascript">
    document.title = 'Chapter 2';
</script>

<h1>Short Assignment: Type Casts</h1>
<h2>Objectives</h2>
<p>
The goal of this assignment is to understand the following concepts:
</p>
<ul>
<li>Implicit type casting</li>
<li>Explicit type casting</li>
</ul>
<h2>Overview</h2>
<p>
Write a program that has at least 10 combinations of implicit type casts and five examples of explicit type casts.
</p>
<h2>Description</h2>
<p>
Implicit type casting takes various combinations of primitive types. Come up with at least ten different implicit type casts. For example, the implicit type cast below uses the <tt>text</tt> primitive and the <tt>integer</tt> primitive. When concatenated using the <tt>+</tt> operator, the result is a <tt>text</tt> primitive.
</p>
<p><pre class="code"><code>
text value = &quot;Hello there THX&quot; + 1138
</code></pre></p>
<p>
The output of the code above shows the following:
</p>
<p><pre class="code"><code>
Hello there THX1138
</code></pre></p>
<p>
<br />
Explicit type casting makes a conversion between types with the <tt>cast</tt> operator.  Come up with at least 5 different examples of explicit type casts.  For example, the explicit type cast below converts a <tt>text</tt> value into an <tt>integer</tt> value.
</p>
<p><pre class="code"><code>
integer a = cast(integer, &quot;1138&quot;)
</code></pre></p>
<p>
The output of the code above shows the following:
</p>
<p><pre class="code"><code>
1138
</code></pre></p>
<p>
<br />
For each cast, put a comment using // on the top of each line identifying each case of implicit and explicit type casts. An example of this might be:
</p>
<p><pre class="code"><code>
//Implicit type casting of an integer to a text type
text value = &quot;Hello there THX&quot; + 1138
say value
</code></pre></p>
<h2>Design Criteria</h2>
<ul><li>Create a new project and name it <strong>Assignment2_1</strong>.
</li></ul>

<?php include("../../include/footer.php"); ?>