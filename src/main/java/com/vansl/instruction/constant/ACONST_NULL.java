package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

/**
 * @description 令把null引用推入操作数栈顶
 * @date 2019-03-12 19:46:30
 **/
public class ACONST_NULL extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushRef(null);
    }
}
