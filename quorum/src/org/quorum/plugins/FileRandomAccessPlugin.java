/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quorum.plugins;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quorum.vm.interfaces.Plugin;
import org.quorum.vm.interfaces.PluginCall;
import org.quorum.vm.interfaces.PluginReturn;
import org.quorum.execution.ExecutionStep;
import org.quorum.execution.ExpressionValue;
import org.quorum.symbols.Structure;
import org.quorum.symbols.TypeDescriptor;
import java.util.HashMap;
import org.quorum.vm.interfaces.AbstractVirtualMachine;
import org.quorum.symbols.ErrorTypeDescriptor;

/**
 * TODO: Exception handling needs to be done properly.
 * @author Jeff Wilson
 */
public class FileRandomAccessPlugin implements Plugin {
    protected AbstractVirtualMachine vm;
    public static final String KEY = "Libraries.System.FileRandomAccess";
    public static final String OPEN_FOR_RANDOM_ACCESS_NATIVE = "OpenForRandomAccessNative:text";
    public static final String CLOSE = "Close";
    public static final String GET_POSITION = "GetPosition";
    public static final String SET_POSITION = "SetPositionNative:number";
    public static final String IS_AT_END_OF_FILE = "IsAtEndOfFile";
    public static final String READ = "ReadNative";
    public static final String READ_AMOUNT = "ReadNative:integer";
    public static final String READ_LINE = "ReadLineNative";
    public static final String WRITE = "WriteNative:text";
    public static final String WRITE_LINE = "WriteLineNative:text";
    public static final String READ_LINES_NATIVE = "ReadLinesNative";
    public static final String GET_SYSTEM_NEWLINE = "GetSystemNewline";
    
    protected HashMap<Integer, QuorumFileRandomAccess> instances;

    public FileRandomAccessPlugin() {
        instances = new HashMap<Integer, QuorumFileRandomAccess>();
    }

    public PluginReturn debug(PluginCall call) {
        //return execute(call);
        return null;
    }

    public PluginReturn undebug(PluginCall call) {
        return null;
    }

    public boolean canDebugBackward() {
        return false;
    }

    public boolean isValidCall(PluginCall call) {
        return false;
    }

    public String getName() {
        return "FileRandomAccess";
    }

    public int getVersion() {
        return 1;
    }

    public String getKey() {
        return KEY;
    }

    public PluginReturn unexecute(PluginCall call) {
        return null;
    }

    public boolean isDebugPlugin() {
        return false;
    }

    public boolean isExecutePlugin() {
        return true;
    }

    public void reset() {
        instances = new HashMap<Integer, QuorumFileRandomAccess>();
    }

    public PluginReturn execute(PluginCall call) {
        String action = call.getActionName();
        PluginReturn ret = new PluginReturn();
        
        QuorumFileRandomAccess inst = instances.get(call.getCallingObject().getHashKey());
        
        if (inst == null) {
            // This instance hasn't been logged yet. Put it in.
            inst = new QuorumFileRandomAccess();
            instances.put(call.getCallingObject().getHashKey(), inst);
        }
        
        vm = call.getVirtualMachine();
       
        if (action.equals(READ_LINES_NATIVE)) {
            String lines = null;
            try {
                lines = inst.ReadLinesNative();
            } catch (EOFException ex) {
                throwQuorumException("EndOfFileError: " + ex.getMessage(), ErrorTypeDescriptor.getEndOfFileError());
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
            
            setPluginReturnValue(ret, lines);
        }
        else if(action.equals(GET_SYSTEM_NEWLINE)) {
            setPluginReturnValue(ret, inst.GetSystemNewline());
        }
        else if (action.equals(OPEN_FOR_RANDOM_ACCESS_NATIVE)) {
            ExpressionValue argument = call.getArgument("path");
            String arg = argument.getResult().text;
            try {
                inst.OpenForRandomAccessNative(arg);
            } catch (FileNotFoundException ex) {
                throwQuorumException("FileNotFoundError: " + ex.getMessage(), ErrorTypeDescriptor.getFileNotFoundError());
            }
        }
        else if (action.equals(CLOSE)) {
            try {
                inst.Close();
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
        }
        else if (action.equals(GET_POSITION)) {
            double result = 0;
            
            try {
                result = inst.GetPosition();
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
            
            setPluginReturnValue(ret, result);
        }
        else if (action.equals(SET_POSITION)) {
            ExpressionValue argument = call.getArgument("position");
            double arg = argument.getResult().number;
            try {
                inst.SetPositionNative((long)arg);
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
        }
        else if (action.equals(IS_AT_END_OF_FILE)) {
            boolean result = inst.IsAtEndOfFile();
            
            setPluginReturnValue(ret, result);
        }
        else if (action.equals(READ)) {
            String result = "";
            try {
                result = inst.ReadNative();
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
            
            setPluginReturnValue(ret, result);
        }
        else if (action.equals(READ_AMOUNT)) {
            ExpressionValue argument = call.getArgument("numberOfBytes");
            int arg = argument.getResult().integer;
            String result = "";
            try {
                result = inst.ReadNative(arg);
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
            
            setPluginReturnValue(ret, result);        
        }
        else if (action.equals(READ_LINE)) {
            String result = "";
            try {
                result = inst.ReadLineNative();
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }
            
            setPluginReturnValue(ret, result);        }
        else if (action.equals(WRITE)) {
            ExpressionValue argument = call.getArgument("textToWrite");
            String arg = argument.getResult().text;
            String result = "";
            try {
                inst.WriteNative(arg);
            } catch (IOException ex) {
                throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }     
        }
        else if (action.equals(WRITE_LINE)) {
            ExpressionValue argument = call.getArgument("textToWrite");
            String arg = argument.getResult().text;
            String result = "";
            try {
                inst.WriteLineNative(arg);
            } catch (IOException ex) {
               throwQuorumException("InputOutputError: " + ex.getMessage(), ErrorTypeDescriptor.getInputOutputError());
            }             
        }
        return ret;
    }

    protected void setPluginReturnValue(PluginReturn ret, int num) {
        ExpressionValue value = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getNumberType());
        value.getResult().integer = num;
        ret.setReturnValue(value);
    }
    
    protected void setPluginReturnValue(PluginReturn ret, double num) {
        ExpressionValue value = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getNumberType());
        value.getResult().number = num;
        ret.setReturnValue(value);
    }

    protected void setPluginReturnValue(PluginReturn ret, String str){
        ExpressionValue value = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getTextType());
        value.getResult().text = str;
        ret.setReturnValue(value);
    }

    protected void setPluginReturnValue(PluginReturn ret, boolean bool){
        ExpressionValue value = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getBooleanType());
        value.getResult().boolean_value = bool;
        ret.setReturnValue(value);
    }

    protected void setPluginReturnValue(PluginReturn ret, Structure obj){
        ExpressionValue value = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getTextType());
        value.getResult().structure = obj;
        ret.setReturnValue(value);
    }

    protected void setExpressionValue(ExpressionValue exp, String str){
        exp = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getTextType());
        exp.getResult().text = str;
    }

    protected void setExpressionValue(ExpressionValue exp, double num){
        exp = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getNumberType());
        exp.getResult().number = num;
    }

    protected void setExpressionValue(ExpressionValue exp, Boolean bool){
        exp = ExpressionValue.getPrimitiveDefault(TypeDescriptor.getBooleanType());
        exp.getResult().boolean_value = bool;
    }
    
    protected void throwQuorumException(String message, ErrorTypeDescriptor e) {
        //This will throw the exception to the virtual machine
        ExecutionStep currentStep = vm.getExecution().getCurrentStep();
        currentStep.setRuntimeError(new RuntimeError(message, e, vm));
        currentStep.setCallStateBeforeException(vm.getDataEnvironment().callStackPeek());
        currentStep.setIsInErrorState(vm.throwException(currentStep.getRuntimeError()));
        currentStep.setWasInErrorState(true);
    }
}