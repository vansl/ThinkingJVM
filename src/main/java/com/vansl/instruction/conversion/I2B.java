package com.vansl.instruction.conversion;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

/**
 * @description int -> byte
 * @date 2019-03-13 13:59:45
 **/
public class I2B extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        int val = operandStack.popInt();
        operandStack.pushInt((byte)val);
    }
}
