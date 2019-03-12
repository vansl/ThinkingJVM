package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

/**
 * @description int按位或
 * @date 2019-03-12 21:20:42
 **/
public class IOR extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int v2 = operandStack.popInt();
        int v1 = operandStack.popInt();
        operandStack.pushInt(v1 | v2);
    }
}
