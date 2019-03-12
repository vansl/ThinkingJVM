package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

/**
 * @description 把int型-1推入操作数栈顶
 * @date 2019-03-12 19:48:03
 **/
public class ICONST_M1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        frame.getOperandStack().pushInt(-1);
    }
}
