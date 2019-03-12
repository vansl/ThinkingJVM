package com.vansl.instruction.stack;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;
import com.vansl.rtdata.Slot;

/**
 * @description 交换栈顶的两个变量
 * @date 2019-03-12 20:44:19
 **/
public class SWAP extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        Slot slot1 = operandStack.popSlot();
        Slot slot2 = operandStack.popSlot();
        operandStack.pushSlot(slot1);
        operandStack.pushSlot(slot2);
    }
}
