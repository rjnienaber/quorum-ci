<?php $classPageTitle = "WindowEvent"; ?><?php include('../../static/templates/pageheader.template.php'); ?><?php include('../../static/templates/classheader.template.php'); ?><h1 class="page_title"> Libraries.Accessibility.WindowEvent</h1>
<input type="hidden" id="classkey" value="Libraries.Accessibility.WindowEvent" /><h2> <span class="controllable" data-componentType="class-name">Class WindowEvent</span></h2> 
<p><span class="controllable" data-componentType="class-description"><em>Description</em>:
The WindowEvent class is used to represent an event that happened to a window. These events include minimizing, restoring, moving or resizing, scrolling, etc. These components are typically used as described in the Legam Screen Reader XML documentation.</span></p>

<span class="controllable" data-componentType="class-example"><em>Example Code</em>:</span>
<pre class="code">WindowEvent wevent
wevent:SetCategory("Window")
wevent:SetAction("Minimize")
wevent:SetComponent("Window")
wevent:SetComponentName("Sodbeans 3.5")
say(wevent:GetDescription())</pre>

<em>Inherits from</em>:
<a href="../../Libraries/Accessibility/AccessibilityEvent.php">Libraries.Accessibility.AccessibilityEvent</a>, <a href="../../Libraries/Accessibility/SystemEvent.php">Libraries.Accessibility.SystemEvent</a>, <a href="../../Libraries/Language/Object.php">Libraries.Language.Object</a><h2> Inherited Actions</h2> 

<ul class="parent_variables">
<li class="package_standard"><strong>From: </strong><a href="../../Libraries/Accessibility/AccessibilityEvent.php">Libraries.Accessibility.AccessibilityEvent</a> public blueprint action GetCategory(), public blueprint action GetDescription()</li>
<li class="package_alternate"><strong>From: </strong><a href="../../Libraries/Accessibility/SystemEvent.php">Libraries.Accessibility.SystemEvent</a> public action AddChild(Libraries.Accessibility.AccessibleChild newChild), public action GetAction(), public action GetCategory(), public action GetChild(integer index), public action GetChildCount(), public action GetComponent(), public action GetComponentName(), public action GetDescription(), public action GetKeyboardShortcut(), public action SetAction(text newAct), public action SetCategory(text newCategory), public action SetChildCount(integer newChildCount), public action SetComponent(text newComponent), public action SetComponentName(text newComponentName), public action SetKeyboardShortcut(text newShortcut)</li>
<li class="package_standard"><strong>From: </strong><a href="../../Libraries/Language/Object.php">Libraries.Language.Object</a> public action Compare(Libraries.Language.Object object), public action Equals(Libraries.Language.Object object), public system action GetHashCode()</li>
</ul><?php include('../../static/templates/classfooter.template.php'); ?><?php include('../../static/templates/pagefooter.template.php'); ?>