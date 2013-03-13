/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quorum.documentation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quorum.symbols.AccessModifierEnum;
import org.quorum.symbols.BlueprintDescriptor;
import org.quorum.symbols.ClassDescriptor;
import org.quorum.symbols.ContainerDescriptor;
import org.quorum.symbols.DescriptorComparator;
import org.quorum.symbols.Documentation;
import org.quorum.symbols.GenericDescriptor;
import org.quorum.symbols.MethodDescriptor;
import org.quorum.symbols.ParameterDescriptor;
import org.quorum.symbols.Parameters;
import org.quorum.symbols.SystemActionDescriptor;
import org.quorum.symbols.TypeDescriptor;
import org.quorum.symbols.VariableDescriptor;
import org.quorum.vm.implementation.QuorumJarGenerator;

/**
 *
 * @author astefik
 */
public class PHPDocumentationGenerator implements DocumentationGenerator{

    
    /**
     * This string represents the root directory, by which to compare all links.
     * For all links, it must be computed, given a class's package
     * location.
     * 
     */
    private String root = "";

    private boolean indexed = true;
    private String indexPage = "";
    private ArrayList<ClassDescriptor> classes = new ArrayList<ClassDescriptor>();
    private ClassDescriptor currentClass = null;
    
    @Override
    public boolean isIndexed() {
        return indexed;
    }

    @Override
    public void setIndexed(boolean isIndexed) {
        indexed = isIndexed;
    }

    @Override
    public String getIndex() {
        return indexPage;
    }

    @Override
    public void clearIndex() {
        startNewIndex();
    }
    
    @Override
    public void finishIndex() {
        Collections.sort(classes, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                ClassDescriptor left = (ClassDescriptor) a;
                ClassDescriptor right = (ClassDescriptor) b;
                //first compare the keys of the containers
                String leftContainer = left.getContainer().getContainer();
                String rightContainer = right.getContainer().getContainer();
                
                int result = leftContainer.compareTo(rightContainer);
                if(result == 0) {
                    return left.getStaticKey().compareTo(right.getStaticKey());
                }
                else {
                    return result;
                }
                
            }
        });
        
        String previousContainer = "!!!!----invalid----!!!!";
        boolean firstPackage = true;
        
        for(int i = 0; i < classes.size(); i++) {
            ClassDescriptor clazz = classes.get(i);
            String newContainer = clazz.getContainer().getContainer();
            if(previousContainer.compareTo(newContainer)!=0) { //if it's a new container
                previousContainer = newContainer;
                if(!firstPackage) { 
                    indexPage += "\t</ul>\n</div>\n"; 
                }
                
                indexPage += "<li class=\"grid-item grid-item-" + clazz.getName().toLowerCase() + "\">\n";
                indexPage += "\t<h2 class=\"index_package_title\">" + (newContainer.isEmpty() ? "Default Package" : newContainer) + "</h2>\n";
                indexPage += "\t<ul class=\"packages\">\n";
            }
            
            indexPage += "\t\t<li class=\"sublist-item\">" + linkForClassFromRoot(clazz) + "</li>\n";
            
            firstPackage = false;
        }
        indexPage += "</ul>\n";
        indexPage += "\n</div>";
        indexPage = "<?php include('" + root + "static/templates/pagefooter.template.php'); ?>";;
    }
    
    private String generateHeader(String key) {
        return "<?php include('" + root + "static/templates/pageheader.template.php'); ?>";
    }
    
    private void startNewIndex() {
        classes.clear();
        currentClass = null;
    }
    
    
    private void addToIndex(ClassDescriptor clazz) {
        classes.add(clazz);        
    }
    
    private String linkForClassFromRoot(ClassDescriptor clazz) {
        return link(generatePathToClassFromRoot(clazz), clazz.getName());
    }
    
    /**
     * Given a class in a package X, this method computes a string relative
     * to the root.
     * 
     * @param clazz
     * @return 
     */
    private String generatePathToClassFromRoot(ClassDescriptor clazz) {
        ContainerDescriptor con = clazz.getContainer();
        String container = con.getContainer();
        if(container.startsWith(".")) {
            container = container.substring(1);
        }
        String[] split = container.replace('.', '/').split("/");
        String path = "";
        for(int i = 0; i < split.length; i++) {
            path += split[i] + "/";
        }
        if(path.compareTo("/")==0) {
            path = "";
        }
        return path + clazz.getName() + "." + this.getFileExtension();
    }
    
    /**
     * Given a particular class descriptor object, this method returns an
     * html link for that class.
     * 
     * @param clazz
     * @return 
     */
    private String linkForClass(ClassDescriptor clazz) {
        return link(generatePathToClass(clazz), clazz.getStaticKey());
    }
    
    /**
     * This method computes a relative path root. This root is relative to
     * the package structure in Quorum.
     * 
     * @param clazz 
     */
    private void computeRelativeRoot(ClassDescriptor clazz) {
        root = "";
        ContainerDescriptor con = clazz.getContainer();
        String container = con.getContainer();
        if(container.length() == 0) {
           root = ""; //the root is the current folder
        } else {
            String[] split = container.replace('.', '/').split("/");
            for(int i = 0; i < split.length; i++) {
                root += "../";
            }
        }
    }
    
    /**
     * This method computes a relative path root. This root is relative to
     * the package structure in Quorum.
     * 
     * @param clazz 
     */
    private String computeSuperkey(ClassDescriptor clazz) {
        ContainerDescriptor con = clazz.getContainer();
        String container = con.getContainer();
        return container.replace('.', '|');
    }
    
    /**
     * Given a class in a package X, this method computes a string relative
     * to the root.
     * 
     * @param clazz
     * @return 
     */
    private String generatePathToClass(ClassDescriptor clazz) {
        ContainerDescriptor con = clazz.getContainer();
        String container = con.getContainer();
        if(container.startsWith(".")) {
            container = container.substring(1);
        }
        String[] split = container.replace('.', '/').split("/");
        String path = root;
        for(int i = 0; i < split.length; i++) {
            path += split[i] + "/";
        }
        return path + clazz.getName() + "." + this.getFileExtension();
    }
    
    private String formatCodeForHtml(String example) {
        String result = "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < example.length(); i++) {
            char val = example.charAt(i);
            String newVal = "";
            if(val == '<') {
                newVal = "&lt;";
            }
            else if(val == '>') {
                newVal = "&gt;";
            }
            else if(val == '&') {
                newVal = "&amp;";
            }
            else {
                newVal = "" + val;
            }
            builder.append(newVal);
        }
        result = builder.toString();
        return result;
    }
    
    @Override
    public String generate(ClassDescriptor clazz) {
        currentClass = clazz;
        computeRelativeRoot(clazz);
        addToIndex(clazz);
          
        String key = clazz.getStaticKey();
        String result = generateHeader(key);

        result += "<?php include('" + root + "static/templates/classheader.template.php'); ?>";
        
        result += headingSurround(key, 1, "page_title") + "\n";

        //get the class's name in wiki format
        String className = clazz.getName();

        int numTemplateVariables = 0;
        String templateString = "";
        Iterator<GenericDescriptor> templateVariables = clazz.getTemplateVariables();
        while(templateVariables.hasNext()) {
            GenericDescriptor generic = templateVariables.next();
            String genericName = generic.getName();
            if(numTemplateVariables == 0) {
                templateString += genericName;
            }
            else {
                templateString += "," + genericName;
            }

            numTemplateVariables++;
        }

        if(numTemplateVariables > 0) {
            //handle generics
            templateString = getTemplateStartCharacter() + templateString + getTemplateEndCharacter();
            className += templateString;
        }

        className = controllableComponent("Class " + className, "class-name");
        result += headingSurround(className, 2) + "\n";
        //get the class's description in wiki format
        Documentation documentation = clazz.getDocumentation();
        String description = "";

        if(documentation != null) {
            description = Documentation.breakStringIntoParagraphs(documentation.getDescription());
        }
        description = controllableComponent(italics("Description") + ":\n" + description, "class-description");
        result += paragraph(description) + "\n";

        //create the parent initialization wiki
        
        Iterator<ClassDescriptor> unsortedParents = clazz.getFlattenedListOfParents();
        ArrayList<ClassDescriptor> sortedParents = new ArrayList<ClassDescriptor>();
        while(unsortedParents.hasNext()) {
            sortedParents.add(unsortedParents.next());
        }
        DescriptorComparator compare = new DescriptorComparator();
        String parentsString = "";
        if(!sortedParents.isEmpty()) {
            parentsString = italics("Inherits from") + ":\n";
        }
        Collections.sort(sortedParents, compare);
        Iterator<ClassDescriptor> parents = sortedParents.iterator();
        
        String parentList = "";
        while(parents.hasNext()) {
            ClassDescriptor parent = parents.next();
            String parentPath = generatePathToClass(parent);
            String parentLink = link(parentPath, parent.getStaticKey());
            String parentListItem = parentLink;
            if(parents.hasNext()) { //there's another
                parentListItem += ", ";
            }
            parentList += parentListItem;
        }
        
        parentsString += parentList;
                
        if(!documentation.getExample().isEmpty()) {
            result += "\n" + controllableComponent(italics("Example Code") + ":", "class-example") + "\n";
            result += code(documentation.getExample()) + "\n\n";
        }
        result += parentsString;
        //add work for any public variables
        
        Iterator<VariableDescriptor> unsortedVariables = clazz.getVariables();
        ArrayList<VariableDescriptor> variables = new ArrayList<VariableDescriptor>();
        while(unsortedVariables.hasNext()) {
            VariableDescriptor next = unsortedVariables.next();
            if(next.getAccessModifier() == AccessModifierEnum.PUBLIC) {
                variables.add(next); //ignore private variables
            }
        }
        if(variables.size() > 0) {
            Collections.sort(variables, compare);
            Iterator<VariableDescriptor> sortedVariables = variables.iterator();
            result += "\n " + headingSurround("Variables",2, "action_or_variables_header") + "\n";
            result += "<ul class=\"variables\">";
            boolean standardListItem = true;
            while(sortedVariables.hasNext()) {
                VariableDescriptor next = sortedVariables.next();
                String listClass = "";
                if(standardListItem) {
                    listClass = "class = \"package_standard\"";
                }
                else {
                    listClass = "class = \"package_alternate\"";
                }
                standardListItem = !standardListItem;
                result += "<li " + listClass + " >" + getVariableDocumentation(next) + "</li>\n";
            }
            result += "</ul>";
        }
        
        //add work for any public actions
        ArrayList<MethodDescriptor> methods = new ArrayList<MethodDescriptor>();
        Iterator<MethodDescriptor> unsortedMethods = clazz.getMethods();
        while(unsortedMethods.hasNext()) {
            MethodDescriptor method = unsortedMethods.next();
            methods.add(method);
        }
        Iterator<BlueprintDescriptor> blueprints = clazz.getBlueprints();
        while(blueprints.hasNext()) {
            BlueprintDescriptor method = blueprints.next();
            methods.add(method);
        }
        Iterator<SystemActionDescriptor> systemsActions = clazz.getSystemActions();
        while(systemsActions.hasNext()) {
            SystemActionDescriptor method = systemsActions.next();
            methods.add(method);
        }
        
        if(!methods.isEmpty()) {
            result += "\n " + headingSurround("Actions",2) + "\n";
        }
        
        //sort the methods into alphabetical order
        Collections.sort(methods, compare);
        
        Iterator<MethodDescriptor> sortedMethods = methods.iterator();
        while(sortedMethods.hasNext()) {
            MethodDescriptor method = sortedMethods.next();
            if(method.getAccessModifier() == AccessModifierEnum.PUBLIC) {
                String methodDocumentation = getMethodDocumentation(method);
                result += "<div class=\"action\">";
                result += methodDocumentation;
                result += "</div>";
            }
        }
        //now generate any information relevant from the parents.
        parents = sortedParents.iterator();
        String pString = headingSurround("Inherited Actions",2) + "\n\n";
        int totalParentMethodsNotImplemented = 0;
        pString += "<ul class=\"parent_variables\">\n";
        boolean standard = true;
        while(parents.hasNext()) {
            ClassDescriptor parent = parents.next();
            ParentResult more = getParentMethodsNotImplemented(parent, clazz);
            if(more.numParents != 0) {
                if(standard) {
                    pString += "<li class=\"package_standard\">";
                }
                else {
                    pString += "<li class=\"package_alternate\">";
                }
                standard = !standard;
                pString += more.documentation + "</li>\n";
                totalParentMethodsNotImplemented += more.numParents;
            }
        }
        pString += "</ul>";
        if(totalParentMethodsNotImplemented > 0) {
            result += pString;
        }
        
        
        result += "<?php include('" + root + "static/templates/classfooter.template.php'); ?>";
        result += "<?php include('" + root + "static/templates/pagefooter.template.php'); ?>";
        return result;
    }
    
    private String paragraph(String string) {
        return "<p>" + string + "</p>";
    }
    
    private String italics(String string) {
        return "<em>" + string + "</em>";
    }
    
    private String bold(String string) {
        return "<strong>" + string + "</strong>";
    }
    
    private String code(String string) {
        return "<pre class=\"code\">" + formatCodeForHtml(string) + "</pre>";
    }
    
    private String link(String link, String text) {
        return "<a href=" + "\"" + link + "\">" + text + "</a>";
    }
    
    private String unorderedList(String string) {
        return "<ul>" + string + "</ul>";
    }
    
    private String listItem(String string) {
        return "<li>" + string + "</li>";
    }
    
    private String controllableComponent(String string, String componentType) {
        return "<span class=\"controllable\" data-componentType=\"" + componentType + "\">" + string + "</span>";  
    }
    
    private String getVariableDocumentation(VariableDescriptor variable) {
        String result = "";
        TypeDescriptor type = variable.getType();
        String name = italics(variable.getName());
        
        
        if(type.isTemplated()) {
            result = pascalCaseChecker(type.getTemplateName());
        }
        else {
            result = pascalCasePackageChecker(type.getStaticKey());
        }
        result = bold(result);
        
        if(type.hasSubTypes()) {
            result += getTemplateStartCharacter();
            Iterator<GenericDescriptor> subTypes = type.getSubTypes();
            while(subTypes.hasNext()) {
                GenericDescriptor next = subTypes.next();
                
                String templateName = next.getType().getTemplateName();
                result += pascalCaseChecker(templateName);
                result += ",";
            }
            result = result.substring(0, result.length() - 1);
            result += getTemplateEndCharacter();
        }
        result = result + " " + pascalCaseChecker(name);
        String description = variable.getDocumentation().getDescription();
        if(!description.isEmpty()) {
            result += ": " + description;
        }
        return result;
    }
    
    private String getTemplateStartCharacter() {
        return "&lt;";
    }
    
    private String getTemplateEndCharacter() {
        return "&gt;";
    }
    
    private String getClassStringAsPath(ClassDescriptor clazz) {
        return clazz.getStaticKey().replace('.', '/') + " " + clazz.getStaticKey();
    }
    
    private boolean isMethodInClassOrPrivate(MethodDescriptor method, ClassDescriptor clazz) {
        String staticKey = method.getStaticKey();
        if(method.getAccessModifier() == AccessModifierEnum.PRIVATE) {
            return true;
        }
        if(clazz.getMethod(staticKey) == null && clazz.getBlueprint(staticKey) == null && clazz.getSystemAction(staticKey) == null) {
            return false;
        }
        else {
            return true;
        }
    }
    
    private ParentResult getParentMethodsNotImplemented(ClassDescriptor parent, ClassDescriptor clazz) {
        String result = "";
        
        ArrayList<MethodDescriptor> documentThese = new ArrayList<MethodDescriptor>();
        
        Iterator<MethodDescriptor> methods = parent.getMethods();
        while(methods.hasNext()) {
            MethodDescriptor method = methods.next();
            if(!isMethodInClassOrPrivate(method, clazz)) {
                //we need to document this method
                documentThese.add(method);
            }
        }
        
        Iterator<BlueprintDescriptor> blueprints = parent.getBlueprints();
        while(blueprints.hasNext()) {
            MethodDescriptor method = blueprints.next();
            if(!isMethodInClassOrPrivate(method, clazz)) {
                //we need to document this method
                documentThese.add(method);
            }
        }
        
        Iterator<SystemActionDescriptor> sysActions = parent.getSystemActions();
        while(sysActions.hasNext()) {
            MethodDescriptor method = sysActions.next();
            if(!isMethodInClassOrPrivate(method, clazz)) {
                //we need to document this method
                documentThese.add(method);
            }
        }
        
        DescriptorComparator compare = new DescriptorComparator();
        Collections.sort(documentThese, compare);
        Iterator<MethodDescriptor> iterator = documentThese.iterator();
        String parentList = "";
        while(iterator.hasNext()) {
            MethodDescriptor method = iterator.next();
            parentList += getParentMethodDocumentation(parent, method);
            if(iterator.hasNext()) {
                parentList += ", ";
            }
        }
        
        result += parentList;
        
        ParentResult res = new ParentResult();
        String link = link(generatePathToClass(parent), parent.getStaticKey()) + " ";
        res.documentation = bold("From: ") + link;
        res.documentation += result;
        res.numParents = documentThese.size();
        return res;
    }

    @Override
    public String getFileExtension() {
        return "php";
    }

    @Override
    public String getIndexName() {
        return "library-index";
    }
    
    @Override
    public void finish(File standardLibrary, File documentation) {
        File css = new File(standardLibrary.getParentFile().getAbsolutePath() + "/style.css");
        File destination = new File(documentation.getAbsolutePath() + "/style.css");
        try {
            QuorumJarGenerator gen = new QuorumJarGenerator();
            gen.copyFile(css, destination);
            
            File intro = new File(standardLibrary.getParentFile().getAbsolutePath() + "/index.php");
            destination = new File(documentation.getAbsolutePath() + "/index.php");
            gen.copyFile(intro, destination);
            
            File syntax = new File(standardLibrary.getParentFile().getAbsolutePath() + "/syntax.php");
            destination = new File(documentation.getAbsolutePath() + "/syntax.php");
            gen.copyFile(syntax, destination);
            
            File libraries = new File(standardLibrary.getParentFile().getAbsolutePath() + "/libraries.php");
            destination = new File(documentation.getAbsolutePath() + "/libraries.php");
            gen.copyFile(libraries, destination);
            
            File curriculum = new File(standardLibrary.getParentFile().getAbsolutePath() + "/curriculum.php");
            destination = new File(documentation.getAbsolutePath() + "/curriculum.php");
            gen.copyFile(curriculum, destination);
            
            File downloads = new File(standardLibrary.getParentFile().getAbsolutePath() + "/download.php");
            destination = new File(documentation.getAbsolutePath() + "/download.php");
            gen.copyFile(downloads, destination);
            
            File documents = new File(standardLibrary.getParentFile().getAbsolutePath() + "/documents");
            destination = new File(documentation.getAbsolutePath() + "/documents");
            gen.copyFile(documents, destination);
            
            File statics = new File(standardLibrary.getParentFile().getAbsolutePath() + "/static");
            destination = new File(documentation.getAbsolutePath() + "/static");
            gen.copyFile(statics, destination);
            
            File assets = new File(standardLibrary.getParentFile().getAbsolutePath() + "/assets");
            destination = new File(documentation.getAbsolutePath() + "/assets");
            gen.copyFile(assets, destination);
            
            File controllers = new File(standardLibrary.getParentFile().getAbsolutePath() + "/controllers");
            destination = new File(documentation.getAbsolutePath() + "/controllers");
            gen.copyFile(controllers, destination);
            
            File models = new File(standardLibrary.getParentFile().getAbsolutePath() + "/models");
            destination = new File(documentation.getAbsolutePath() + "/models");
            gen.copyFile(models, destination);
            
        } catch (IOException ex) {
            Logger.getLogger(PHPDocumentationGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class ParentResult {
        public int numParents = 0;
        public String documentation = "";
    }
    
    private String getParentMethodDocumentation(ClassDescriptor parent, MethodDescriptor method) {
        String result = "";
        result = getMethodSignature(method) + "";
        return result;
    } 
    
    /**
     * This method assumes a string of the form Libraries.Containers.OtherStuff. It 
     * checks each dot separated
     * @param string
     * @return 
     */
    private String pascalCasePackageChecker(String string) {
        String result = "";
        String[] split = string.replace('.', '/').split("/");
        for(int i = 0; i < split.length; i++) {
            result += pascalCaseChecker(split[i]) + ".";
        }
        if(result.endsWith(".")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
    
    private String pascalCaseChecker(String string) {
//        if(string.length() == 0) {
//            return "";
//        }
//        boolean hasMoreThanTwoUppers = false;
//        int numUpper = 0;
//        for(int i = 0; i < string.length(); i++) {
//            boolean upper = Character.isUpperCase(string.charAt(i));
//            if(upper) {
//                numUpper++;
//            }
//        }
//        
//        if(numUpper >= 2) {
//            hasMoreThanTwoUppers = true;
//        }
//        boolean first = Character.isUpperCase(string.charAt(0));
//        String result = string;
//        if(hasMoreThanTwoUppers && first) {
//            result = "!" + result;
//        }
        return string;
    }
    
    private String getMethodSignature(MethodDescriptor method) {
        String result = "";
        String name = method.getName();
        String modifier = method.getAccessModifier().toString();

        result = "";
        String methodType = "";

        if(method instanceof BlueprintDescriptor) {
            methodType = " blueprint";
        }
        else if(method instanceof SystemActionDescriptor) {
            methodType = " system";
        }

        Parameters parameters = method.getParameters();
        String params = "";
        for (int i = 0; i < parameters.size(); i++) {
            if( i != 0) {
                params += ",";
            }
            ParameterDescriptor descriptor = parameters.get(i);
            TypeDescriptor type = descriptor.getType();
            if(type != null) {
                boolean templated = parameters.get(i).getType().isTemplated();
                String currentParam = "";
                if(templated) {
                    currentParam = pascalCaseChecker(parameters.get(i).getType().getTemplateName()) + " "
                        + parameters.get(i).getName();
                    
                }else {
                    currentParam = pascalCasePackageChecker(parameters.get(i).getType().getStaticKey()) + " "
                        + parameters.get(i).getName();
                }
                params += currentParam;
            }
        }
        result += controllableComponent(modifier + methodType + " action " + name + "(" + params + ")", "action-name");
        
        String returnType = getReturnTypeString(method);
        return result;
    }

    public String getMethodDocumentation(MethodDescriptor method) {
        Documentation documentation = method.getDocumentation();
        //check if there's documentation. If there isn't,
        //then check parents to see if it's available.
        if(!documentation.doesDocumentationExist() && currentClass != null) {
            //check all parents and inspect for conflicts
            Documentation parentDoc = null;
            MethodDescriptor parentMethod = null;
            for(int i = 0; i < currentClass.getNumFlatParents(); i++) {
                ClassDescriptor parent = currentClass.getFlatParent(i);
                MethodDescriptor currentMethod = parent.getMethod(method.getStaticKey());
                if(currentMethod == null) {
                    currentMethod = parent.getBlueprint(method.getStaticKey());
                }
                
                if(currentMethod == null) {
                    currentMethod = parent.getSystemAction(method.getStaticKey());
                }
                
                
                if(currentMethod != null && parentMethod == null) {
                    parentMethod = currentMethod;
                    if(currentMethod.getDocumentation().doesDocumentationExist()) {
                        parentDoc = parentMethod.getDocumentation();
                    }
                } else if(currentMethod != null && parentMethod != null) {
                    //if there is no multiple inheritance conflict, use the 
                    //parent's if one is not defined.
                    parentDoc = null;
                    parentMethod = null;
                    i = currentClass.getNumFlatParents() + 1;
                }
            }
            if(parentDoc != null) {
                documentation = parentDoc;
            }
        }
        
        String result = "";
        Parameters parameters = method.getParameters();
        String params = "";
        String paramList = "";
        if(!parameters.isEmpty()) {
            paramList = italics("Parameters") + ":";
            paramList += "<ul class=\"parameters\">";
            for (int i = 0; i < parameters.size(); i++) {
                if( i != 0) {
                    params += ",";
                }
                ParameterDescriptor descriptor = parameters.get(i);
                TypeDescriptor type = descriptor.getType();
                if(type != null) {
                    boolean templated = parameters.get(i).getType().isTemplated();
                    String currentParam = "";
                    if(templated) {
                        currentParam = pascalCaseChecker(parameters.get(i).getType().getTemplateName());

                    }else {
                        currentParam = pascalCasePackageChecker(parameters.get(i).getType().getStaticKey());
                    }
                    currentParam = controllableComponent(bold(currentParam) + " " + italics(parameters.get(i).getName()) + ": ", "parameter-name");
                    String parameterDocumentation = documentation.getParameter(parameters.get(i).getName());
                    currentParam += parameterDocumentation;
                    paramList += "<li>" + currentParam + "</li>\n\n";
                }
            }
            paramList += "</ul>";
        }
        String methodSignature = getMethodSignature(method);
        result += "\n\t" + headingSurround(methodSignature, 3, "action_title") + "\n";

        
        if(documentation != null) {
            String[] array = Documentation.breakStringIntoParagraphArray(documentation.getDescription());
            result += "\n\t" + breakIntoParagraphs(array);
        }
        result += paramList + "\n";
        
        if(!method.getReturnType().isVoid()) {
            result += italics("Returns") + ":<ul class=\"parameters\">";
            result += "\n\t<li>" + bold(getReturnTypeString(method)) + ": " + documentation.getReturns() + "</li>\n</ul>";
        }
        if(!(method instanceof BlueprintDescriptor)) {
            if(!documentation.getExample().isEmpty()) {
                result += "\n\t" + controllableComponent(paragraph(italics("Example Code:")), "action-example");
                result += "\n" + code(documentation.getExample())
                        + "\n\n";
            }
        }

        return result;
    }
    
    private String breakIntoParagraphs(String[] array) {
        String result = "";
        for(int i = 0; i < array.length; i++) {
            result += paragraph(array[i]);
        }
        return result;
    }

    private String getReturnTypeString(MethodDescriptor method) {
        String returnType = "";
        if(method.getReturnType().isVoid()) {
            returnType = "none";
        }
        else {
            boolean templated = method.getReturnType().isTemplated();
            if(templated) {
                returnType = method.getReturnType().getTemplateName();
            }
            else {
                returnType = method.getReturnType().getStaticKey();
            }
        }
        return returnType;
    }
    
    /**
     * Creates text in the style of a heading at a particular level.
     * 
     * @param input
     * @param level
     * @return 
     */
    public String headingSurround(String input, int level) {
        String result = "";
        String wiki = "";
        for(int i = 0; i < level; i++) {
            wiki += "=";
        }
        result = "<h" + level + "> " + input + "</h" + level + "> ";
        return result;
    }
    
    /**
     * Creates text in the style of a heading at a particular level.
     * 
     * @param input
     * @param level
     * @param clazz
     * @return 
     */
    public String headingSurround(String input, int level, String clazz) {
        String result = "";
        String wiki = "";
        for(int i = 0; i < level; i++) {
            wiki += "=";
        }
        result = "<h" + level + " class=\"" + clazz + "\"> " + input + "</h" + level + ">";
        return result;
    }

    @Override
    public DocumentationStyle getDocumentationStyle() {
        return DocumentationStyle.PHP;
    }
    
}