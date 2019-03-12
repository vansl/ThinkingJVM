package com.vansl.instruction.constant;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DCONST_1 extends NoOperandsInstruction {
    @Override
    public void Execute(Frame frame) {
        frame.getOperandStack().pushDouble(1.0);
    }
}
