package com.vansl.instruction.stack;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.Slot;

/**
 * @description 复制栈顶的单个变量
 * @date 2019-03-12 20:38:11
 **/
public class DUP extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        Slot slot = operandStack.popSlot();
        operandStack.pushSlot(slot);
        operandStack.pushSlot(slot);
    }
}
