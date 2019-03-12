package com.vansl.instruction.load;

import com.vansl.instruction.base.NoOperandsInstruction;
import com.vansl.rtdata.Frame;

public class ALOAD_2 extends NoOperandsInstruction {

    @Override
    public void Execute(Frame frame) {
        ALOAD.aload(frame,2);
    }
}
