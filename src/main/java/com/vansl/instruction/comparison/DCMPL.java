package com.vansl.instruction.comparison;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class DCMPL extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        DCMPG.fcmp(frame,false);
    }
}
