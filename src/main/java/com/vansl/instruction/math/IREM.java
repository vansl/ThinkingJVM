package com.vansl.instruction.math;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class IREM extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int v2 = operandStack.popInt();
        int v1 = operandStack.popInt();
        if (v2 == 0) {
            throw new ArithmeticException("/ by zero");
        } else {
            operandStack.pushInt(v1%v2);
        }
    }
}
