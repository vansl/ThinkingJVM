package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class IREG extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int v1 = operandStack.popInt();
        operandStack.pushInt(-v1);
    }
}
