package com.vansl.instruction.comparison;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

/**
 * @description 比较long变量
 * @date 2019-03-12 21:46:28
 **/
public class LCMP extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        long v2 = operandStack.popLong();
        long v1 = operandStack.popLong();
        if (v1>v2) {
            operandStack.pushInt(1);
        } else if (v1==v2) {
            operandStack.pushInt(0);
        } else {
            operandStack.pushInt(-1);
        }
    }
}
