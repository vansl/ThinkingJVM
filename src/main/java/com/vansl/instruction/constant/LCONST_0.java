package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class LCONST_0 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        frame.getOperandStack().pushLong(0L);
    }
}
