package com.vansl.instruction.conversion;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class F2D extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        float val = operandStack.popFloat();
        operandStack.pushDouble((double)val);
    }
}
