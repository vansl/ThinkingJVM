package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class LREG extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        long v1 = operandStack.popLong();
        operandStack.pushLong(-v1);
    }
}
