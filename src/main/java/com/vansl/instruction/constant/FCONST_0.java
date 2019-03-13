package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class FCONST_0 extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushFloat(0.0f);
    }
}
