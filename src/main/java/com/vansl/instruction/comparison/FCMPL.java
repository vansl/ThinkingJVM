package com.vansl.instruction.comparison;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;
import com.vansl.rtdata.OperandStack;

public class FCMPL extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FCMPG.fcmp(frame,false);
    }
}
