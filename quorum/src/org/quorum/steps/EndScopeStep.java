/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quorum.steps;

import org.quorum.execution.DataEnvironment;

/**
 * Opcode used to close a scope.
 * 
 * @author Melissa Stefik
 */
public class EndScopeStep extends IntermediateStep{

    @Override
    public void execute() {
        DataEnvironment de = vm.getDataEnvironment();
        de.callStackPop();
    }

    @Override
    public void unexecute() {
        DataEnvironment de = vm.getDataEnvironment();
        de.callStackUndo();
    }

}
