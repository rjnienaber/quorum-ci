/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quorum.steps;
import org.quorum.execution.DataEnvironment;
import org.quorum.execution.ExecutionStepVisitor;
import org.quorum.execution.ExpressionValue;
/**
 *
 * @author Aaron Willows
 */
public class ConditionalJumpIfStep extends JumpBaseStep{

    private boolean isElseIf = false;
    private int leftRegister = -1;
    private boolean jump;

    @Override
    public void execute() {
        DataEnvironment data = vm.getDataEnvironment();
        ExpressionValue value = data.getRegister(leftRegister);
        boolean res = value.getResult().boolean_value;
        jump = res;
    }

    @Override
    public void unexecute() {
    }

    /**
     * @return the leftRegister
     */
    public int getLeftRegister() {
        return leftRegister;
    }

    /**
     * @param leftRegister the leftRegister to set
     */
    public void setLeftRegister(int leftRegister) {

        this.leftRegister = leftRegister;
    }

    @Override
    public int nextStep() {
         if(jump) {
            return vm.getExecution().getExecutionPosition() + 1;
         }
         else {
             return vm.getExecution().getExecutionPosition() + jumpLocation;
         }
    }


    /**
     * Determines whether or not the if statement would evaluate to true or
     * false. This method is a getter and does not effect the execution
     * of the program.
     * 
     * @return
     */
    public boolean isTrue() {
        return jump;
    }

    @Override
    public String toString() {
        return "[" + !jump + "]jump to: " + jumpLocation;
    }

    @Override
    public String getStaticKey() {
        return IntermediateConstants.CONDITIONAL_FALSE_JUMP_STEP.getName();
    }

    @Override
    public void visit(ExecutionStepVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return the isElseIf
     */
    public boolean isElseIf() {
        return isElseIf;
    }

    /**
     * @param isElseIf the isElseIf to set
     */
    public void setIsElseIf(boolean isElseIf) {
        this.isElseIf = isElseIf;
    }
}
