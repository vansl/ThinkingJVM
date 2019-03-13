package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class LREM extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        long v2 = operandStack.popLong();
        long v1 = operandStack.popLong();
        if (v2 == 0) {
            throw new ArithmeticException("/ by zero");
        } else {
            operandStack.pushLong(v1%v2);
        }
    }
}
