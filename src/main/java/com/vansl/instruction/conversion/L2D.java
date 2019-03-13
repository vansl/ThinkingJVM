package com.vansl.instruction.conversion;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class L2D extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        long val = operandStack.popLong();
        operandStack.pushDouble((double)val);
    }
}
