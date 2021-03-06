/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quorum.steps;

import java.util.ArrayList;
import org.quorum.execution.BlockScope;
import org.quorum.execution.DataEnvironment;
import org.quorum.execution.ExecutionStepVisitor;
import org.quorum.execution.ExpressionValue;
import org.quorum.execution.RuntimeScope;

/**
 * Opcode: begin the scope for a detect statement.
 * @author Melissa Stefik
 */
public class BeginDetectScopeStep extends BeginScopeStep {
    private CheckLandingPads landingPads;
    private ExpressionValue variable;
    private boolean isFirstDetect = true;
    private ArrayList<DetectInfo> detectInfo = new ArrayList<DetectInfo>();
    @Override
    public void execute() {
        DataEnvironment de = vm.getDataEnvironment();
        BlockScope cs = new BlockScope();
        RuntimeScope localScope = de.getLocalScope();

        cs.setBlockName(blockName);
        cs.setParent(localScope);
        cs.addVariableLocalScopeOnly(variable.getName(), variable);
        de.callStackPush(cs);
    }

    @Override
    public void unexecute() {
        DataEnvironment de = vm.getDataEnvironment();
        de.callStackUndo();
    }

    /**
     * Set the error variable for the detect statement.
     *
     * @param value
     */
    public void setDetectVariable(ExpressionValue value){
        variable = value;
    }
    
    @Override
    public void visit(ExecutionStepVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isFirstDetect() {
        return isFirstDetect;
    }
    
    public void setFirstDetect(boolean isFirst){
        isFirstDetect = isFirst;
    }

    /**
     * @return the landingPads
     */
    public CheckLandingPads getLandingPads() {
        return landingPads;
    }

    /**
     * @param landingPads the landingPads to set
     */
    public void setLandingPads(CheckLandingPads landingPads) {
        this.landingPads = landingPads;
    }

    public void addDetectInfo(DetectInfo detect) {
        detectInfo.add(detect);
    }
    public ArrayList<DetectInfo> getDetectParameters(){
        return detectInfo;
    }
}
