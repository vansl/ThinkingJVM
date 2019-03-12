package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ICONST_2 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        frame.getOperandStack().pushInt(2);
    }
}
