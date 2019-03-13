package com.vansl.instruction.conversion;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

/**
 * @description int -> short
 * @date 2019-03-13 14:02:03
 **/
public class I2S extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int val = operandStack.popInt();
        operandStack.pushInt((short)val);
    }
}
