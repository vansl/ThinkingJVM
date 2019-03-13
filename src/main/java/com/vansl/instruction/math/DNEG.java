package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class DNEG extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        double v1 = operandStack.popDouble();
        operandStack.pushDouble(-v1);
    }
}
