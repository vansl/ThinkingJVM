package com.vansl.instruction.stack;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.JVMStack;
import com.vansl.rtdata.OperandStack;

/**
 * @description 弹出栈顶（int、float等一个操作数栈位置）
 * @date 2019-03-12 20:34:44
 **/
public class POP extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        OperandStack operandStack = frame.getOperandStack();
        operandStack.popSlot();
    }
}
