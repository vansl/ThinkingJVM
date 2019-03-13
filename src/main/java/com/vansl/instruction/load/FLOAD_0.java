package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class FLOAD_0 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        FLOAD.fload(frame,0);
    }
}
