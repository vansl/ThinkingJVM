package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ALOAD_3 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        ALOAD.aload(frame,3);
    }
}
