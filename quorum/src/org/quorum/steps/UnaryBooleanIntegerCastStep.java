/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quorum.steps;

import org.quorum.execution.ExecutionStepVisitor;
import org.quorum.symbols.Result;
import org.quorum.execution.ExpressionValue;

/**
 *
 * @author Melissa Stefik
 */
public class UnaryBooleanIntegerCastStep extends UnaryOperationStep{

    @Override
    protected Result calculateOpcode(ExpressionValue value) {
        Result result = new Result();
        if(value.getResult().integer == 0)
            result.boolean_value = false;
        else
            result.boolean_value = true;

        result.type = Result.BOOLEAN;
        return result;
    }
    
    @Override
    public void visit(ExecutionStepVisitor visitor) {
        visitor.visit(this);
    }
}
