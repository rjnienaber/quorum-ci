/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quorum.vm.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import org.quorum.execution.OmniscientStack;
import org.quorum.symbols.TypeDescriptor;

/**
 * A helper class to encapsulate the standard operations stacks must deal
 * with when pushing and popping from methods, like tracking the max 
 * stack size, handling constants and variables, or other issues.
 * 
 * @author Andreas Stefik
 */
public class BytecodeStack {
    private Stack<ArrayList<CheckDetectEntry>> exceptionTables = new Stack<ArrayList<CheckDetectEntry>>();
    private Stack<TypeDescriptor> expressionTypes = new Stack<TypeDescriptor>();
    private OmniscientStack<LabelStackValue> labels = new OmniscientStack<LabelStackValue>();
    private HashMap<Integer, Integer> quorumToJavaNumberVariableMap = new HashMap<Integer, Integer>();
    private HashMap<Integer, TypeDescriptor> variables = new HashMap<Integer, TypeDescriptor>();
    private HashMap<String, Integer> methodParametersMap = new HashMap<String, Integer>();
    private Stack<Integer> loopCounterVariables = new Stack<Integer>();
    private Stack<Integer> loopMaximumVariables = new Stack<Integer>();
    private int startingVariable = 0; 
    private int maxVariablesSize = 0;
    private int currentVariablesSize = 0;
    private int maxSize = 0;
    private int numberOfHiddenVariables = 0;
    private int currentNumberIfStatements = 0;
    private Stack<CheckDetectDescriptor> checkDetects = new Stack<CheckDetectDescriptor>();
    private Stack<Integer> errorVariableNumber = new Stack<Integer>();
    private Stack<ScopeLabel> scopes = new Stack<ScopeLabel>();
    private int currentAlwaysOffset = 0;
 
    /**
     * Push a check detect entry onto a table that maintains an exception table
     * that is generated for the bytecode try/catch exception table.
     * 
     * @param table 
     */
    public void pushExceptionTable(ArrayList<CheckDetectEntry> table){
        exceptionTables.push(table);
    }
    
    /**
     * Pop the current exception table entry.
     * @return 
     */
    public ArrayList<CheckDetectEntry> popExceptionTable(){
        if(exceptionTables.empty()){
            return null;
        }else{
            return exceptionTables.pop();
        }
    }
    
    /**
     * peek the current exception table entry.
     * @return 
     */
    public ArrayList<CheckDetectEntry> peekExceptionTable(){
        if(exceptionTables.empty()){
            return null;
        }else{
            return exceptionTables.peek();
        }
    }
    
    /**
     * Push a check detect descriptor for each check/detect block. Each block
     * should maintain a max variable. This max variable determines where an always
     * block will begin defining its variables.
     * @param d 
     */
    public void pushCheckDetect(CheckDetectDescriptor d) {
        if(!checkDetects.isEmpty())
            d.setMaxVariableSize(checkDetects.peek().getMaxVariableSize());
        
        checkDetects.push(d);
    }
    
    /**
     * pop the current check detect scope. Also will maintain the proper max
     * variable values.
     * 
     * @return 
     */
    public CheckDetectDescriptor popCheckDetect() {
        if(checkDetects.isEmpty()){
            return null;
        }else{
            CheckDetectDescriptor pop = checkDetects.pop();
            int maxVariableSize = pop.getMaxVariableSize();
            if(!checkDetects.isEmpty() && !checkDetects.peek().isInAlwaysScope()){
                checkDetects.peek().setMaxVariableSize(maxVariableSize);
            }
            return pop;
        }
    }
    
    /**
     * peek the current check detect block.
     * @return 
     */
    public CheckDetectDescriptor peekCheckDetect() {
        if(checkDetects.isEmpty()){
            return null;
        }else{
            return checkDetects.peek();
        }
    }
    
    /**
     * Push an integer counter variable onto the counter stack. Since it is an
     * integer, the variable size is always one.
     * @return 
     */
    public int pushCounterVariable() {
        numberOfHiddenVariables++;
        currentVariablesSize += 1;
        variables.put(currentVariablesSize, TypeDescriptor.getIntegerType());
        
        int location = currentVariablesSize;

        if(currentVariablesSize > maxVariablesSize) {
            maxVariablesSize = currentVariablesSize;
        }
        
        loopCounterVariables.add(location);
        return location;
    }
    
    /**
     * Get the last counter variable off the stack. Handy for nested loops.
     * @return 
     */
    public int popCounterVariable() {
            return loopCounterVariables.pop();
    }
    
    /**
     * Get the counter variable off the stack without consuming it.
     */
    public int peekCounterVariable() {
        return loopCounterVariables.peek();
    }

    /**
     * Push an integer maximum variable onto the maximum variable stack. Since it is an
     * integer, the variable size is always one.
     * @return 
     */
    public int pushMaximumVariable() {
        numberOfHiddenVariables++;
        currentVariablesSize += 1;
        if(!checkDetects.isEmpty() && checkDetects.peek().isInAlwaysScope() && checkDetects.peek().getMaxVariableSize() + 1 > currentVariablesSize)
            currentVariablesSize = checkDetects.peek().getMaxVariableSize() + 1;
        variables.put(currentVariablesSize, TypeDescriptor.getIntegerType());
        
        int location = currentVariablesSize;

        if(currentVariablesSize > maxVariablesSize) {
            maxVariablesSize = currentVariablesSize;
        }
        
        loopMaximumVariables.add(location);
        return location;
    }
    
    /**
     * Pop the last maximum variable off the stack. Handy for nested loops.
     * @return 
     */
    public int popMaximumVariable() {
        return loopMaximumVariables.pop();
    }
    
    /**
     * Get the maximum variable off the stack without consuming it.
     */
    public int peekMaximumVariable() {
        return loopMaximumVariables.peek();
    }
    
    /**
     * This method pushes expression types onto the stack.
     * 
     * @param value 
     */
    public void pushExpressionType(TypeDescriptor type) {
        expressionTypes.push(type);
    }
    
    /**
     * This method pops the last expression type.
     * @return 
     */
    public TypeDescriptor popExpressionType() {
        if(!expressionTypes.isEmpty())
            return expressionTypes.pop();
        else
            return null;
    }
    
    /**
     * This method gets without removing the last expression type.
     * @return 
     */
    public TypeDescriptor peekExpressionType() {
        return expressionTypes.peek();
    }
    
    public boolean isExpressionTypeEmpty(){
        return expressionTypes.isEmpty();
    }
    
    public int getExpressionStackSize(){
        return expressionTypes.size();
    }
    
    public void clearExpressionTypeStack(){
        expressionTypes.clear();
    }

    /**
     * Push a label onto the label stack.
     * 
     * @param value 
     */
    public void pushLabel(LabelStackValue value) {
        labels.push(value);
    }
    
    /**
     * Pop a label off the label stack.
     * 
     * @return 
     */
    public LabelStackValue popLabel() {
        if(labels.isEmpty()){
            return null;
        }
        return labels.pop();
    }
    
    /**
     * peek a label on the top of the label stack.
     * 
     * @return 
     */
    public LabelStackValue peekLabel() {
        if(labels.isEmpty()){
            return null;
        }else{
            return labels.peek();
        }
    }
    
    /**
     * Undo a label pop.
     */
    public void undoLabel(){
        labels.undo();
    }
    
    /**
     * is the labels field empty.
     */
    public boolean isEmptyLabel() {
        if(labels.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Set the variable type to a new type
     * @param location
     * @param valueType 
     */
    public void setVariableType(int location, TypeDescriptor valueType){
        if(variables.containsKey(location)){
            variables.remove(location);
            variables.put(location, valueType);
        }
    }
    
    /**
     * Pushes a value for a particular variable onto a hash map that can
     * later be queried.
     * 
     * @param location
     * @param value 
     */
    public void setVariable(int location, TypeDescriptor valueType) {
        int size = QuorumConverter.getSizeOfType(valueType);
        quorumToJavaNumberVariableMap.put(location, startingVariable + currentVariablesSize);
        variables.put(startingVariable + currentVariablesSize, valueType);
        currentVariablesSize += size;
 
        if(currentVariablesSize > maxVariablesSize) {
            maxVariablesSize = currentVariablesSize;
        }
    }
    
    /**
     * Pops a value off of a hash map that stores the value
     * of variables.
     * 
     * @param location
     * @return 
     */
    public TypeDescriptor removeVariable(int location) {
        TypeDescriptor valueType = variables.remove(location);
        currentVariablesSize -= QuorumConverter.getSizeOfType(valueType);
        return valueType;
    }
    
    
    /**
     * Returns a value from a hash map storing variable values.
     * 
     * @param JVMNumber
     * @return 
     */
    public TypeDescriptor getVariable(int JVMNumber) {
        return variables.get(JVMNumber);
    }
    
    /**
     * This method tells the stack to start a new method definition.
     * Specifically, this method clears out the internal constants/variables
     * stacks and resets the max size value for a new method.
     * 
     */
    public void startMethod(int startingVariableNumber) {
        maxSize = 0;
        maxVariablesSize = 0;
        currentVariablesSize = 0;
        variables.clear();
        labels.clear();
        quorumToJavaNumberVariableMap.clear();
        loopCounterVariables.clear();
        loopMaximumVariables.clear();
        methodParametersMap.clear();
        setStartingVariableNumber(startingVariableNumber);
        checkDetects.clear();
        errorVariableNumber.clear();
    }
    
    /**
     * Returns the maximum size that this particular method has 
     * achieved while processing push and pop values.
     * 
     * @return 
     */
    public int getMaxSize() {
        return maxSize;
    }
    
    /**
     * Returns the maximum total size of the variables stored in the stack
     * achieved while processing push and pop values.
     * 
     * @return 
     */
    public int getMaxVariablesSize() {
            return maxVariablesSize;
    }
    
    /**
     * Set the variable number (given by the interpretor).
     * 
     * @param quorumLocation
     */
    public void setStartingVariableNumber(int quorumLocation) {
       startingVariable = quorumLocation + currentAlwaysOffset;
    }
        
    /**
     * Get the mapped variable number for the bytecode.
     * 
     * @param quorumLocation
     * @return 
     */
    public int getMappedVariableNumber(int quorumLocation, TypeDescriptor type, boolean isStore) {
        Integer get = quorumToJavaNumberVariableMap.get(quorumLocation);
        if (get != null){
            TypeDescriptor currentType = variables.get(get);
            if(QuorumConverter.getSizeOfType(currentType) == QuorumConverter.getSizeOfType(type)){
                if(!checkDetects.isEmpty() && checkDetects.peek().isInAlwaysScope()){
                    int result = get + checkDetects.peek().getMaxVariableSize();
                    if(isStore){
                        checkDetects.peek().setMaxVariableSize(result);
                        quorumToJavaNumberVariableMap.put(quorumLocation, result);
                        variables.put(result,variables.remove(get));
                    }else{
                        result -= checkDetects.peek().getMaxVariableSize();
                    }
                    return result;
                }else if(checkDetects.size() >= 2){
                    CheckDetectDescriptor pop = checkDetects.pop();
                    CheckDetectDescriptor peek = checkDetects.peek();
                    checkDetects.push(pop);
                    if(peek.isInAlwaysScope()){
                        int result = get + peek.getMaxVariableSize();
                        if(isStore){
                            registerMaxVariableSize(result);
                        }
                        return result;
                    }else
                        return get;
                }else{
                    return get;
                }
            }else{
                setVariableType(get, type);
                currentVariablesSize -= QuorumConverter.getSizeOfType(currentType);
                currentVariablesSize += QuorumConverter.getSizeOfType(type);
                
                ArrayList<Integer> newSet = new ArrayList<Integer>(quorumToJavaNumberVariableMap.keySet());
                Iterator<Integer> iterator = newSet.iterator();
                while(iterator.hasNext()){
                    Integer next = iterator.next();
                    if(next > quorumLocation){
                        Integer removedValue = quorumToJavaNumberVariableMap.remove(next);
                        TypeDescriptor remove = variables.remove(removedValue);
                        currentVariablesSize -= QuorumConverter.getSizeOfType(remove);
                    }
                }
                if(currentVariablesSize > maxVariablesSize) {
                    maxVariablesSize = currentVariablesSize;
                }
                
                if(!checkDetects.isEmpty() && checkDetects.peek().isInAlwaysScope()){
                    int result = get + checkDetects.peek().getMaxVariableSize();
                    if(isStore)
                        checkDetects.peek().setMaxVariableSize(result);
                    else
                        result -= checkDetects.peek().getMaxVariableSize();
                    return result;
                }else if(checkDetects.size() >= 2){
                    CheckDetectDescriptor pop = checkDetects.pop();
                    CheckDetectDescriptor peek = checkDetects.peek();
                    checkDetects.push(pop);
                    if(peek.isInAlwaysScope()){
                        int result = get + peek.getMaxVariableSize();
                        if(isStore)
                            registerMaxVariableSize(result);
                        return result;
                    }else
                        return get;
                }else{
                    return get;
                }
            }
        }else{
            return -1;
        }
    }

    /**
     * Add a parameter to the local variable pool.
     * 
     * **MUST** be called before any other variables are added.
     * 
     * @param name
     * @param type
     */
    public void addParameter(String name, TypeDescriptor type) {
        int size = QuorumConverter.getSizeOfType(type);
        methodParametersMap.put(name, currentVariablesSize + 1);
        currentVariablesSize += size;
        
        if(currentVariablesSize > maxVariablesSize) {
            maxVariablesSize = currentVariablesSize;
        }
    }
    
    /**
     * Get the number (in the local variable pool) of the given parameter.
     * 
     * @param name
     * @return 
     */
    public int getParameterNumber(String name) {
        return methodParametersMap.get(name);
    }

    /**
     * Add to the counter for the number of if blocks.
     */
    public void addIfBlock() {
        currentNumberIfStatements++;
    }
    
    public void endIfBlock(){
        currentNumberIfStatements--;
    }
    /**
     * get the number of 
     * @return 
     */
    public int getCurrentNumberOfIfStatements(){
        return currentNumberIfStatements;
    }
    
    /**
     * Register the max variable size with a check detect block
     * this allows us to determine the variable numbers in the always scope.
     * 
     */
    public void registerMaxVariableSize(){
        if(!checkDetects.isEmpty() && checkDetects.peek().getMaxVariableSize() < this.maxVariablesSize)
            checkDetects.peek().setMaxVariableSize(maxVariablesSize);      
    }
    
    /**
     * Get the registered max variable from the check detect scope.
     * @return 
     */
    public int getRegisteredMaxVariableSize(){
        return checkDetects.peek().getMaxVariableSize();
    }

    /**
     * Register an exact offset amount for the always variable starting position.
     * 
     * @param offset 
     */
    public void registerMaxVariableSize(int offset) {
        if(offset > maxVariablesSize)
            maxVariablesSize = offset;
        
        this.registerMaxVariableSize();
    }
    public void pushScope(ScopeLabel scopeLabel){
        scopes.push(scopeLabel);
    }
    public ScopeLabel popScope(){
        if(scopes.isEmpty()){
            return null;
        }else{
            return scopes.pop();
        }
    }
    public ScopeLabel peekScope(){
        if(scopes.isEmpty()){
            return null;
        }else{
            return scopes.peek();
        }
    }
}
