<?php $classPageTitle = "FocusObserver"; ?><?php include('../../static/templates/pageheader.template.php'); ?><?php include('../../static/templates/classheader.template.php'); ?><h1 class="page_title"> Libraries.Accessibility.FocusObserver</h1>
<input type="hidden" id="classkey" value="Libraries.Accessibility.FocusObserver" /><h2> <span class="controllable" data-componentType="class-name">Class FocusObserver</span></h2> 
<p><span class="controllable" data-componentType="class-description"><em>Description</em>:
The FocusObserver class provides functionality to output any focus system event.</span></p>

<span class="controllable" data-componentType="class-example"><em>Example Code</em>:</span>
<pre class="code">AccessibilityManager manager
FocusObserver fObserver
manager:Add(fObserver)
manager:Start()
manager:Stop()</pre>

<em>Inherits from</em>:
<a href="../../Libraries/Language/Object.php">Libraries.Language.Object</a>
 <h2> Actions</h2> 
<div class="action">
	<h3 class="action_title"> <span class="controllable" data-componentType="action-name" data-actionkey="ReceiveEvent:Libraries.Accessibility.FocusEvent">public blueprint action ReceiveEvent(Libraries.Accessibility.FocusEvent event)</span></h3>

	<span class="controllable" data-componentType="action-description" data-actionkey="ReceiveEvent:Libraries.Accessibility.FocusEvent"><p>This action is a blueprint function that receives an event from the system for the programmer to use.</p></span><em>Parameters</em>:<ul class="parameters"><li><h5><span class="controllable" data-componentType="parameter-name" data-parameterkey="event"><strong>Libraries.Accessibility.FocusEvent</strong> <em>event</em>:</span></h5><span class="controllable" data-componentType="parameter-description" data-parameterkey="event">The event from the system.</span></li>

</ul>
</div><h2> Inherited Actions</h2> 

<ul class="parent_variables">
<li class="package_standard"><strong>From: </strong><a href="../../Libraries/Language/Object.php">Libraries.Language.Object</a> public action Compare(Libraries.Language.Object object), public action Equals(Libraries.Language.Object object), public system action GetHashCode()</li>
</ul><?php include('../../static/templates/classfooter.template.php'); ?><?php include('../../static/templates/pagefooter.template.php'); ?>